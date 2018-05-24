/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.pronoia.junit.sftp;

import com.pronoia.junit.sftp.impl.SftpFilesystemFactory;
import com.pronoia.junit.sftp.impl.SimplePasswordAuthenticator;

import java.io.File;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import org.apache.sshd.common.NamedFactory;
import org.apache.sshd.common.file.virtualfs.VirtualFileSystemFactory;
import org.apache.sshd.common.scp.ScpTransferEventListener;

import org.apache.sshd.server.Command;
import org.apache.sshd.server.SshServer;
import org.apache.sshd.server.auth.UserAuth;
import org.apache.sshd.server.auth.keyboard.UserAuthKeyboardInteractiveFactory;
import org.apache.sshd.server.auth.password.UserAuthPasswordFactory;
import org.apache.sshd.server.keyprovider.SimpleGeneratorHostKeyProvider;
import org.apache.sshd.server.scp.ScpCommandFactory;
import org.apache.sshd.server.subsystem.sftp.SftpEventListener;
import org.apache.sshd.server.subsystem.sftp.SftpSubsystem;
import org.apache.sshd.server.subsystem.sftp.SftpSubsystemFactory;

import org.junit.rules.ExternalResource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmbeddedSftpServerResource extends ExternalResource {
    public static final String DEFAULT_SFTP_HOST = "0.0.0.0";
    public static final int DEFAULT_SFTP_PORT = 22222;
    public static final Path DEFAULT_SFTP_ROOT_PATH = Paths.get("target/sftp");
    public static final String DEFAULT_SFTP_BASE_USER_HOME_DIRECTORY = "home";

    protected SshServer sshd;
    protected boolean cleanFilesystemOnStartup = true;

    private Logger log = LoggerFactory.getLogger(EmbeddedSftpServerResource.class);

    final ScpCommandFactory scpCommandFactory;
    final SftpSubsystemFactory sftpSubsystemFactory;

    public EmbeddedSftpServerResource() {
        this(new ScpCommandFactory.Builder().build(), new SftpSubsystemFactory.Builder().build());
    }

    public EmbeddedSftpServerResource(ScpCommandFactory scpCommandFactory) {
        this(scpCommandFactory, new SftpSubsystemFactory.Builder().build());
    }

    public EmbeddedSftpServerResource(SftpSubsystemFactory sftpSubsystemFactory) {
        this(new ScpCommandFactory.Builder().build(), sftpSubsystemFactory);
    }

    public EmbeddedSftpServerResource(ScpCommandFactory scpCommandFactory, SftpSubsystemFactory sftpSubsystemFactory) {
        this.scpCommandFactory = scpCommandFactory;
        this.sftpSubsystemFactory = sftpSubsystemFactory;

        SftpSubsystem tmp;



        sshd = SshServer.setUpDefaultServer();

        setHost(DEFAULT_SFTP_HOST);
        setPort(DEFAULT_SFTP_PORT);

        List<NamedFactory<UserAuth>> userAuthFactories = new ArrayList<>();
        userAuthFactories.add(UserAuthPasswordFactory.INSTANCE);
        userAuthFactories.add(UserAuthKeyboardInteractiveFactory.INSTANCE);
        sshd.setUserAuthFactories(userAuthFactories);

        sshd.setKeyPairProvider(new SimpleGeneratorHostKeyProvider());
        sshd.setCommandFactory(this.scpCommandFactory);

        List<NamedFactory<Command>> subsystemFactories = new ArrayList<>();
        subsystemFactories.add(this.sftpSubsystemFactory);
        sshd.setSubsystemFactories(subsystemFactories);

        sshd.setPasswordAuthenticator(new SimplePasswordAuthenticator());

        Path absolutePath = DEFAULT_SFTP_ROOT_PATH.toAbsolutePath();
        absolutePath.toFile().mkdirs();

        sshd.setFileSystemFactory(new SftpFilesystemFactory(DEFAULT_SFTP_ROOT_PATH, DEFAULT_SFTP_BASE_USER_HOME_DIRECTORY));
    }

    @Override
    protected void before() throws Throwable {
        super.before();
        try {
            this.configure();
            Path rootDirectory = getRootDirectory();
            if (cleanFilesystemOnStartup) {
                if (Files.exists(rootDirectory)) {
                    log.info("Cleaning SFTP Filesystem {}", rootDirectory);
                    FileUtils.deleteDirectory(rootDirectory.toFile());
                }
            }
            log.info("Starting embedded SSH server: {}:{} {}",
                this.getHost(), this.getPort(), rootDirectory);
            this.start();
        } catch (Exception ex) {
            throw new RuntimeException("Exception encountered starting embedded SSH server: " + this.getHost() + ':' + this.getPort());
        }
    }

    @Override
    protected void after() {
        super.after();
        log.info("Stopping embedded SSH server: {}:{}", this.getHost(), this.getPort());
        try {
            this.stop();
        } catch (IOException stopEx) {
            log.warn("Exception encountered stopping embedded SSH server: {}:{}", this.getHost(), this.getPort(), stopEx);
        }
    }

    public void start() throws IOException {
        sshd.start();
    }

    public void stop() throws IOException {
        sshd.stop();
    }

    public void stop(boolean immediately) throws IOException {
        sshd.stop(immediately);
    }

    /**
     * Override this method to customize the configuration of the SFTP Server Resource.
     */
    protected void configure() {
    }

    public String getHost() {
        return sshd.getHost();
    }

    public void setHost(String host) {
        sshd.setHost(host);
    }

    public EmbeddedSftpServerResource host(String hostname) {
        this.setHost(hostname);

        return this;
    }

    public int getPort() {
        return sshd.getPort();
    }

    public void setPort(int port) {
        sshd.setPort(port);
    }

    public EmbeddedSftpServerResource port(int port) {
        this.setPort(port);

        return this;
    }

    public Path getRootDirectory() {
        return getFileSystemFactory().getDefaultHomeDir();
    }

    public void setRootDirectory(Path rootDirectory) {
        getFileSystemFactory().setDefaultHomeDir(rootDirectory);
    }

    public void setRootDirectory(String rootDirectory) {
        getFileSystemFactory().setDefaultHomeDir(Paths.get(rootDirectory).toAbsolutePath());
    }

    public EmbeddedSftpServerResource rootDirectory(String rootDirectory) {
        this.setRootDirectory(rootDirectory);

        return this;
    }

    public EmbeddedSftpServerResource rootDirectory(Path rootDirectory) {
        this.setRootDirectory(rootDirectory);

        return this;
    }

    public boolean isCleanFilesystemOnStartup() {
        return cleanFilesystemOnStartup;
    }

    public void setCleanFilesystemOnStartup(boolean cleanFilesystemOnStartup) {
        this.cleanFilesystemOnStartup = cleanFilesystemOnStartup;
    }

    public EmbeddedSftpServerResource cleanFilesystemOnStartup(boolean cleanFilesystemOnStartup) {
        setCleanFilesystemOnStartup(cleanFilesystemOnStartup);
        return this;
    }

    public void addUser(String userName, String password) {
        getPasswordAuthenticator().addUser(userName, password);
    }

    public EmbeddedSftpServerResource user(String userName, String password) {
        this.addUser(userName, password);

        return this;
    }

    public SshServer getSshServer() {
        return sshd;
    }

    public SimplePasswordAuthenticator getPasswordAuthenticator() {
        return (SimplePasswordAuthenticator) sshd.getPasswordAuthenticator();
    }

    public VirtualFileSystemFactory getFileSystemFactory() {
        return (VirtualFileSystemFactory) sshd.getFileSystemFactory();
    }

    public ScpCommandFactory getScpCommandFactory() {
        return scpCommandFactory;
    }

    public SftpSubsystemFactory getSftpSubsystemFactory() {
        return sftpSubsystemFactory;
    }

    public EmbeddedSftpServerResource addScpTransferEventListener(ScpTransferEventListener listener) {
        scpCommandFactory.addEventListener(listener);

        return this;
    }

    public EmbeddedSftpServerResource addSftpEventListener(SftpEventListener listener) {
        sftpSubsystemFactory.addSftpEventListener(listener);

        return this;
    }
}
