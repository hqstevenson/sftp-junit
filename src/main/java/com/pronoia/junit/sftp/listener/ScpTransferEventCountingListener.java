/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.pronoia.junit.sftp.listener;

import java.nio.file.Path;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Set;

import org.apache.sshd.common.scp.ScpTransferEventListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScpTransferEventCountingListener implements ScpTransferEventListener {
    Logger log = LoggerFactory.getLogger(this.getClass());

    int startFileEventCount;
    int endFileEventCount;
    int startFolderEventCount;
    int endFolderEventCount;

    public ScpTransferEventCountingListener() {
    }

    @Override
    public void startFileEvent(FileOperation op, Path file, long length, Set<PosixFilePermission> perms) {
        ++startFileEventCount;
        log.trace("startFileEvent(FileOperation = {}, file = {})", op, file);
    }

    @Override
    public void endFileEvent(FileOperation op, Path file, long length, Set<PosixFilePermission> perms, Throwable thrown) {
        ++endFileEventCount;
        log.trace("endFileEvent(FileOperation = {}, file = {}", op, file);
    }

    @Override
    public void startFolderEvent(FileOperation op, Path file, Set<PosixFilePermission> perms) {
        ++startFolderEventCount;
        log.trace("startFolderEvent(FileOperation = {}, file = {})", op, file);
    }

    @Override
    public void endFolderEvent(FileOperation op, Path file, Set<PosixFilePermission> perms, Throwable thrown) {
        ++endFolderEventCount;
        log.trace("endFolderEvent(FileOperation = {}, file = {})", op, file);
    }

    public int getStartFileEventCount() {
        return startFileEventCount;
    }

    public void setStartFileEventCount(int startFileEventCount) {
        this.startFileEventCount = startFileEventCount;
    }

    public void clearStartFileEventCount() {
        setStartFileEventCount(0);
    }

    public int getEndFileEventCount() {
        return endFileEventCount;
    }

    public void setEndFileEventCount(int endFileEventCount) {
        this.endFileEventCount = endFileEventCount;
    }

    public void clearEndFileEventCount() {
        setEndFileEventCount(0);
    }

    public int getStartFolderEventCount() {
        return startFolderEventCount;
    }

    public void setStartFolderEventCount(int startFolderEventCount) {
        this.startFolderEventCount = startFolderEventCount;
    }

    public void clearStartFolderEventCount() {
        setStartFolderEventCount(0);
    }

    public int getEndFolderEventCount() {
        return endFolderEventCount;
    }

    public void setEndFolderEventCount(int endFolderEventCount) {
        this.endFolderEventCount = endFolderEventCount;
    }

    public void clearEndFolderEventCount() {
        setEndFolderEventCount(0);
    }
}