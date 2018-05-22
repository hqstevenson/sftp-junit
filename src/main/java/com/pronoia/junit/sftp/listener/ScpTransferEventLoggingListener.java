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
package com.pronoia.junit.sftp.listener;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Set;

import org.apache.sshd.common.scp.ScpTransferEventListener;

import org.slf4j.event.Level;

public class ScpTransferEventLoggingListener extends EventLoggingListenerSupport implements ScpTransferEventListener {
    Level startFileEventLevel;
    Level endFileEventLevel;
    Level startFolderEventLevel;
    Level endFolderEventLevel;

    public ScpTransferEventLoggingListener() {
    }

    public ScpTransferEventLoggingListener(int level) {
        super(level);
    }

    public ScpTransferEventLoggingListener(String level) {
        super(level);
    }

    public ScpTransferEventLoggingListener(Level level) {
        super(level);
    }

    @Override
    public void startFileEvent(FileOperation op, Path file, long length, Set<PosixFilePermission> perms) throws IOException {
        doLog(startFileEventLevel, "startFileEvent(FileOperation = {}, file = {}, length = {}, permission = {})", op, file, length, perms);
    }

    @Override
    public void endFileEvent(FileOperation op, Path file, long length, Set<PosixFilePermission> perms, Throwable thrown) throws IOException {
        doLog(endFileEventLevel, "endFileEvent(FileOperation = {}, file = {}, length = {}, permission = {}, thrown = {})", op, file, length, perms, thrown);
    }

    @Override
    public void startFolderEvent(FileOperation op, Path file, Set<PosixFilePermission> perms) throws IOException {
        doLog(startFolderEventLevel, "startFolderEvent(FileOperation = {}, file = {}, permission = {})", op, file, perms);
    }

    @Override
    public void endFolderEvent(FileOperation op, Path file, Set<PosixFilePermission> perms, Throwable thrown) throws IOException {
        doLog(endFolderEventLevel, "endFolderEvent(FileOperation = {}, file = {}, permission = {}, thrown = {})", op, file, perms, thrown);
    }

    public Level getStartFileEventLevel() {
        return startFileEventLevel;
    }

    public void setStartFileEventLevel(int level) {
        setStartFileEventLevel(toLevel(level));
    }

    public void setStartFileEventLevel(String level) {
        setStartFileEventLevel(toLevel(level));
    }

    public void setStartFileEventLevel(Level startFileEventLevel) {
        this.startFileEventLevel = startFileEventLevel;
    }

    public Level getEndFileEventLevel() {
        return endFileEventLevel;
    }

    public void setEndFileEventLevel(int level) {
        setEndFileEventLevel(toLevel(level));
    }

    public void setEndFileEventLevel(String level) {
        setEndFileEventLevel(toLevel(level));
    }

    public void setEndFileEventLevel(Level endFileEventLevel) {
        this.endFileEventLevel = endFileEventLevel;
    }

    public Level getStartFolderEventLevel() {
        return startFolderEventLevel;
    }

    public void setStartFolderEventLevel(int level) {
        setStartFolderEventLevel(toLevel(level));
    }

    public void setStartFolderEventLevel(String level) {
        setStartFolderEventLevel(toLevel(level));
    }

    public void setStartFolderEventLevel(Level startFolderEventLevel) {
        this.startFolderEventLevel = startFolderEventLevel;
    }

    public Level getEndFolderEventLevel() {
        return endFolderEventLevel;
    }

    public void setEndFolderEventLevel(int level) {
        setEndFolderEventLevel(toLevel(level));
    }

    public void setEndFolderEventLevel(String level) {
        setEndFolderEventLevel(toLevel(level));
    }

    public void setEndFolderEventLevel(Level endFolderEventLevel) {
        this.endFolderEventLevel = endFolderEventLevel;
    }

    public ScpTransferEventLoggingListener defaultLevel(int level) {
        setDefaultLevel(level);
        return this;
    }

    public ScpTransferEventLoggingListener defaultLevel(String level) {
        setDefaultLevel(level);
        return this;
    }

    public ScpTransferEventLoggingListener defaultLevel(Level level) {
        setDefaultLevel(level);
        return this;
    }

    public ScpTransferEventLoggingListener startFileEventLevel(int level) {
        setStartFileEventLevel(level);
        return this;
    }

    public ScpTransferEventLoggingListener startFileEventLevel(String level) {
        setStartFileEventLevel(level);
        return this;
    }

    public ScpTransferEventLoggingListener startFileEventLevel(Level level) {
        setStartFileEventLevel(level);
        return this;
    }

    public ScpTransferEventLoggingListener endFileEventLevel(int level) {
        setEndFileEventLevel(level);
        return this;
    }

    public ScpTransferEventLoggingListener endFileEventLevel(String level) {
        setEndFileEventLevel(level);
        return this;
    }

    public ScpTransferEventLoggingListener endFileEventLevel(Level level) {
        setEndFileEventLevel(level);
        return this;
    }

    public ScpTransferEventLoggingListener startFolderEventLevel(int level) {
        setStartFolderEventLevel(level);
        return this;
    }

    public ScpTransferEventLoggingListener startFolderEventLevel(String level) {
        setStartFolderEventLevel(level);
        return this;
    }

    public ScpTransferEventLoggingListener startFolderEventLevel(Level level) {
        setStartFolderEventLevel(level);
        return this;
    }

    public ScpTransferEventLoggingListener endFolderEventLevel(int level) {
        setEndFolderEventLevel(level);
        return this;
    }

    public ScpTransferEventLoggingListener endFolderEventLevel(String level) {
        setEndFolderEventLevel(level);
        return this;
    }

    public ScpTransferEventLoggingListener endFolderEventLevel(Level level) {
        setEndFolderEventLevel(level);
        return this;
    }
}