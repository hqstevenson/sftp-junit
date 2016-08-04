package com.pronoia.junit.rule.sftp;

import java.io.File;
import java.util.Arrays;

import org.apache.sshd.SshServer;
import org.apache.sshd.common.NamedFactory;
import org.apache.sshd.common.file.virtualfs.VirtualFileSystemFactory;
import org.apache.sshd.server.Command;
import org.apache.sshd.server.PasswordAuthenticator;
import org.apache.sshd.server.command.ScpCommandFactory;
import org.apache.sshd.server.keyprovider.SimpleGeneratorHostKeyProvider;
import org.apache.sshd.server.session.ServerSession;
import org.apache.sshd.sftp.subsystem.SftpSubsystem;
import org.junit.rules.ExternalResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmbeddedSftpServerResource extends ExternalResource {
    Logger log = LoggerFactory.getLogger(this.getClass());

    File sftpRootDirectory = new File("target/sftp");

    private SshServer sshd = SshServer.setUpDefaultServer();


    public EmbeddedSftpServerResource() {
        sshd.setPasswordAuthenticator(new SimplePasswordAuthenticator());
        sshd.setSubsystemFactories(Arrays.<NamedFactory<Command>>asList(new SftpSubsystem.Factory()));
        sshd.setCommandFactory(new ScpCommandFactory());
        sshd.setKeyPairProvider(new SimpleGeneratorHostKeyProvider(sftpRootDirectory.getAbsolutePath() + '/' + "hostkey.ser"));
    }

    public EmbeddedSftpServerResource(int port) {
        sshd.setPort(port);
    }

    public EmbeddedSftpServerResource(String host, int port) {
        sshd.setHost(host);
        sshd.setPort(port);
    }

    @Override
    protected void before() throws Throwable {
        super.before();
        log.info("Starting embedded SSH server: {}:{}", this.getHost(), this.getPort());
        try {
            this.configure();
            sshd.start();
        } catch (Exception ex) {
            throw new RuntimeException("Exception encountered starting embedded SSH server: " + this.getHost() + ':' + this.getPort());
        }
    }

    @Override
    protected void after() {
        super.after();
        log.info("Stopping embedded SSH server: {}:{}", this.getHost(), this.getPort());
        try {
            sshd.stop();
        } catch (InterruptedException e) {
            log.warn("Exception encountered stopping embedded SSH server: {}:{}" + this.getHost(), this.getPort());
        }
    }

    private void configure() {
        if (!sftpRootDirectory.exists()) {
            sftpRootDirectory.mkdirs();
        }

        String rootDirectoryAbsolutePath = sftpRootDirectory.getAbsolutePath();

        VirtualFileSystemFactory fileSystemFactory = new VirtualFileSystemFactory();
        new VirtualFileSystemFactory(rootDirectoryAbsolutePath);
        fileSystemFactory.setUserHomeDir(getUsername(), rootDirectoryAbsolutePath);
        sshd.setFileSystemFactory(fileSystemFactory);

    }

    public String getHost() {
        return sshd.getHost();
    }

    public void setHost(String host) {
        sshd.setHost(host);
    }

    public int getPort() {
        return sshd.getPort();
    }

    public void setPort(int port) {
        sshd.setPort(port);
    }

    public String getUsername() {
        return getPasswordAuthenticator().getUsername();
    }

    public void setUsername(String username) {
        getPasswordAuthenticator().setUsername(username);
    }

    public String getPassword() {
        return getPasswordAuthenticator().getPassword();
    }

    public void setPassword(String password) {
        getPasswordAuthenticator().setPassword(password);
    }

    public String getRootDirectory() {
        return sftpRootDirectory.getPath();
    }

    public void setRootDirectory(String rootDirectory) {
        sftpRootDirectory = new File(rootDirectory);
    }

    class SimplePasswordAuthenticator implements PasswordAuthenticator {
        String username = "user";
        String password = "passwd";

        @Override
        public boolean authenticate(String username, String password, ServerSession session) {
            if (getUsername().equalsIgnoreCase(username) && getPassword().equals(password)) {
                return true;
            }
            return false;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    private SimplePasswordAuthenticator getPasswordAuthenticator() {
        return (SimplePasswordAuthenticator) sshd.getPasswordAuthenticator();
    }
}
