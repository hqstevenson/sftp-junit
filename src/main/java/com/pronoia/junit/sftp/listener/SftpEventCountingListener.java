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

import java.nio.file.CopyOption;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Map;

import org.apache.sshd.server.session.ServerSession;
import org.apache.sshd.server.subsystem.sftp.DirectoryHandle;
import org.apache.sshd.server.subsystem.sftp.FileHandle;
import org.apache.sshd.server.subsystem.sftp.Handle;
import org.apache.sshd.server.subsystem.sftp.SftpEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SftpEventCountingListener implements SftpEventListener {
    Logger log = LoggerFactory.getLogger(this.getClass());

    int initializedEventCount;
    int destroyingEventCount;
    int creatingEventCount;
    int createdEventCount;
    int removingEventCount;
    int removedEventCount;
    int openingEventCount;
    int openEventCount;
    int closeEventCount;
    int readDirectoryEventCount;
    int readingFileEventCount;
    int readFileEventCount;
    int writingFileEventCount;
    int writtenFileEventCount;
    int blockingEventCount;
    int blockedEventCount;
    int unblockingEventCount;
    int unblockedEventCount;
    int movingEventCount;
    int movedEventCount;
    int linkingEventCount;
    int linkedEventCount;
    int modifyingAttributesEventCount;
    int modifiedAttributesEventCount;

    public SftpEventCountingListener() {
        super();
    }

    public int getInitializedEventCount() {
        return initializedEventCount;
    }

    public void setInitializedEventCount(int initializedEventCount) {
        this.initializedEventCount = initializedEventCount;
    }

    public void clearInitializedEventCount() {
        setInitializedEventCount(0);
    }

    public int getDestroyingEventCount() {
        return destroyingEventCount;
    }

    public void setDestroyingEventCount(int destroyingEventCount) {
        this.destroyingEventCount = destroyingEventCount;
    }

    public void clearDestroyingEventCount() {
        setDestroyingEventCount(0);
    }

    public int getCreatingEventCount() {
        return creatingEventCount;
    }

    public void setCreatingEventCount(int creatingEventCount) {
        this.creatingEventCount = creatingEventCount;
    }

    public void clearCreatingEventCount() {
        setCreatingEventCount(0);
    }

    public int getCreatedEventCount() {
        return createdEventCount;
    }

    public void setCreatedEventCount(int createdEventCount) {
        this.createdEventCount = createdEventCount;
    }

    public void clearCreatedEventCount() {
        setCreatedEventCount(0);
    }

    public int getRemovingEventCount() {
        return removingEventCount;
    }

    public void setRemovingEventCount(int removingEventCount) {
        this.removingEventCount = removingEventCount;
    }

    public void clearRemovingEventCount() {
        setRemovingEventCount(0);
    }

    public int getRemovedEventCount() {
        return removedEventCount;
    }

    public void setRemovedEventCount(int removedEventCount) {
        this.removedEventCount = removedEventCount;
    }

    public void clearRemovedEventCount() {
        setRemovedEventCount(0);
    }

    public int getOpeningEventCount() {
        return openingEventCount;
    }

    public void setOpeningEventCount(int openingEventCount) {
        this.openingEventCount = openingEventCount;
    }

    public void clearOpeningEventCount() {
        setOpeningEventCount(0);
    }

    public int getOpenEventCount() {
        return openEventCount;
    }

    public void setOpenEventCount(int openEventCount) {
        this.openEventCount = openEventCount;
    }

    public void clearOpenEventCount() {
        setOpenEventCount(0);
    }

    public int getCloseEventCount() {
        return closeEventCount;
    }

    public void setCloseEventCount(int closeEventCount) {
        this.closeEventCount = closeEventCount;
    }

    public void clearCloseEventCount() {
        setCloseEventCount(0);
    }

    public int getReadDirectoryEventCount() {
        return readDirectoryEventCount;
    }

    public void setReadDirectoryEventCount(int readDirectoryEventCount) {
        this.readDirectoryEventCount = readDirectoryEventCount;
    }

    public void clearReadDirectoryEventCount() {
        setReadDirectoryEventCount(0);
    }

    public int getReadingFileEventCount() {
        return readingFileEventCount;
    }

    public void setReadingFileEventCount(int readingFileEventCount) {
        this.readingFileEventCount = readingFileEventCount;
    }

    public void clearReadingFileEventCount() {
        setReadingFileEventCount(0);
    }

    public int getReadFileEventCount() {
        return readFileEventCount;
    }

    public void setReadFileEventCount(int readFileEventCount) {
        this.readFileEventCount = readFileEventCount;
    }

    public void clearReadFileEventCount() {
        setReadFileEventCount(0);
    }

    public int getWritingFileEventCount() {
        return writingFileEventCount;
    }

    public void setWritingFileEventCount(int writingFileEventCount) {
        this.writingFileEventCount = writingFileEventCount;
    }

    public void clearWritingFileEventCount() {
        setWritingFileEventCount(0);
    }

    public int getWrittenFileEventCount() {
        return writtenFileEventCount;
    }

    public void setWrittenFileEventCount(int writtenFileEventCount) {
        this.writtenFileEventCount = writtenFileEventCount;
    }

    public void clearWrittenFileEventCount() {
        setWrittenFileEventCount(0);
    }

    public int getBlockingEventCount() {
        return blockingEventCount;
    }

    public void setBlockingEventCount(int blockingEventCount) {
        this.blockingEventCount = blockingEventCount;
    }

    public void clearBlockingEventCount() {
        setBlockingEventCount(0);
    }

    public int getBlockedEventCount() {
        return blockedEventCount;
    }

    public void setBlockedEventCount(int blockedEventCount) {
        this.blockedEventCount = blockedEventCount;
    }

    public void clearBlockedEventCount() {
        setBlockedEventCount(0);
    }

    public int getUnblockingEventCount() {
        return unblockingEventCount;
    }

    public void setUnblockingEventCount(int unblockingEventCount) {
        this.unblockingEventCount = unblockingEventCount;
    }

    public void clearUnblockingEventCount() {
        setUnblockingEventCount(0);
    }

    public int getUnblockedEventCount() {
        return unblockedEventCount;
    }

    public void setUnblockedEventCount(int unblockedEventCount) {
        this.unblockedEventCount = unblockedEventCount;
    }

    public void clearUnblockedEventCount() {
        setUnblockedEventCount(0);
    }

    public int getMovingEventCount() {
        return movingEventCount;
    }

    public void setMovingEventCount(int movingEventCount) {
        this.movingEventCount = movingEventCount;
    }

    public void clearMovingEventCount() {
        setMovingEventCount(0);
    }

    public int getMovedEventCount() {
        return movedEventCount;
    }

    public void setMovedEventCount(int movedEventCount) {
        this.movedEventCount = movedEventCount;
    }

    public void clearMovedEventCount() {
        setMovedEventCount(0);
    }

    public int getLinkingEventCount() {
        return linkingEventCount;
    }

    public void setLinkingEventCount(int linkingEventCount) {
        this.linkingEventCount = linkingEventCount;
    }

    public void clearLinkingEventCount() {
        setLinkingEventCount(0);
    }

    public int getLinkedEventCount() {
        return linkedEventCount;
    }

    public void setLinkedEventCount(int linkedEventCount) {
        this.linkedEventCount = linkedEventCount;
    }

    public void clearLinkedEventCount() {
        setLinkedEventCount(0);
    }

    public int getModifyingAttributesEventCount() {
        return modifyingAttributesEventCount;
    }

    public void setModifyingAttributesEventCount(int modifyingAttributesEventCount) {
        this.modifyingAttributesEventCount = modifyingAttributesEventCount;
    }

    public void clearModifyingAttributesEventCount() {
        setModifyingAttributesEventCount(0);
    }

    public int getModifiedAttributesEventCount() {
        return modifiedAttributesEventCount;
    }

    public void setModifiedAttributesEventCount(int modifiedAttributesEventCount) {
        this.modifiedAttributesEventCount = modifiedAttributesEventCount;
    }

    public void clearModifiedAttributesEventCount() {
        setModifiedAttributesEventCount(0);
    }

    @Override
    public void initialized(ServerSession session, int version) {
        ++initializedEventCount;
        log.trace("{} - initialized", session);
    }

    @Override
    public void destroying(ServerSession session) {
        ++destroyingEventCount;
        log.trace("{} - destroying", session);
    }

    @Override
    public void creating(ServerSession session, Path path, Map<String, ?> attrs) {
        ++creatingEventCount;
        log.trace("{} - creating {}", session, path);
    }

    @Override
    public void created(ServerSession session, Path path, Map<String, ?> attrs, Throwable thrown) {
        ++createdEventCount;
        log.trace("{} - created {}", session, path);
    }

    @Override
    public void removing(ServerSession session, Path path) {
        ++removingEventCount;
        log.trace("{} - removing {}", session, path);
    }

    @Override
    public void removed(ServerSession session, Path path, Throwable thrown) {
        ++removedEventCount;
        log.trace("{} -removed {}", session, path);
    }

    @Override
    public void opening(ServerSession session, String remoteHandle, Handle localHandle) {
        ++openingEventCount;
        log.trace("{} - opening remote = {}, local = {}", session, remoteHandle, localHandle);
    }

    @Override
    public void open(ServerSession session, String remoteHandle, Handle localHandle) {
        ++openEventCount;
        log.trace("{} - open remote = {}, local = {}", session, remoteHandle, localHandle);
    }

    @Override
    public void close(ServerSession session, String remoteHandle, Handle localHandle) {
        ++closeEventCount;
        log.trace("{} - close remote = {}, local = {}", session, remoteHandle, localHandle);
    }

    @Override
    public void read(ServerSession session, String remoteHandle, DirectoryHandle localHandle, Map<String, Path> entries) {
        ++readDirectoryEventCount;
        log.trace("{} - read DirectoryHandle remote = {}, local = {}", session, remoteHandle, localHandle);
    }

    @Override
    public void reading(ServerSession session, String remoteHandle, FileHandle localHandle, long offset, byte[] data, int dataOffset, int dataLen) {
        ++readingFileEventCount;
        log.trace("{} - reading FileHandle remote = {}, local = {}", session, remoteHandle, localHandle);
    }

    @Override
    public void read(ServerSession session, String remoteHandle, FileHandle localHandle, long offset, byte[] data, int dataOffset, int dataLen, int readLen, Throwable thrown) {
        ++readFileEventCount;
        log.trace("{} -read FileHandle remote = {}, local = {}", session, remoteHandle, localHandle);
    }

    @Override
    public void writing(ServerSession session, String remoteHandle, FileHandle localHandle, long offset, byte[] data, int dataOffset, int dataLen) {
        ++writingFileEventCount;
        log.trace("{} - writing FileHandle remote = {}, local = {}", session, remoteHandle, localHandle);
    }

    @Override
    public void written(ServerSession session, String remoteHandle, FileHandle localHandle, long offset, byte[] data, int dataOffset, int dataLen, Throwable thrown) {
        ++writtenFileEventCount;
        log.trace("{} - written FileHandle remote = {}, local = {}", session, remoteHandle, localHandle);
    }

    @Override
    public void blocking(ServerSession session, String remoteHandle, FileHandle localHandle, long offset, long length, int mask) {
        ++blockingEventCount;
        log.trace("{} - blocking remote = {}, local = {}", session, remoteHandle, localHandle);
    }

    @Override
    public void blocked(ServerSession session, String remoteHandle, FileHandle localHandle, long offset, long length, int mask, Throwable thrown) {
        ++blockedEventCount;
        log.trace("{} - blocked remote = {}, local = {}", session, remoteHandle, localHandle);
    }

    @Override
    public void unblocking(ServerSession session, String remoteHandle, FileHandle localHandle, long offset, long length) {
        ++unblockingEventCount;
        log.trace("{} - unblocking remote = {}, local = {}", session, remoteHandle, localHandle);
    }

    @Override
    public void unblocked(ServerSession session, String remoteHandle, FileHandle localHandle, long offset, long length, Throwable thrown) {
        ++unblockedEventCount;
        log.trace("{} - unblocked remote = {}, local = {}", session, remoteHandle, localHandle);
    }

    @Override
    public void moving(ServerSession session, Path srcPath, Path dstPath, Collection<CopyOption> opts) {
        ++movingEventCount;
        log.trace("{} - moving {} to {}", session, srcPath, dstPath);
    }

    @Override
    public void moved(ServerSession session, Path srcPath, Path dstPath, Collection<CopyOption> opts, Throwable thrown) {
        ++movedEventCount;
        log.trace("{} - moved {} to {}", session, srcPath, dstPath);
    }

    @Override
    public void linking(ServerSession session, Path source, Path target, boolean symLink) {
        ++linkingEventCount;
        log.trace("{} - linking {} to {}", session, source, target);
    }

    @Override
    public void linked(ServerSession session, Path source, Path target, boolean symLink, Throwable thrown) {
        ++linkedEventCount;
        log.trace("{} - linked {} to {}", session, source, target);
    }

    @Override
    public void modifyingAttributes(ServerSession session, Path path, Map<String, ?> attrs) {
        ++modifyingAttributesEventCount;
        log.trace("{} - modifyingAttributes on {}", session, path);
    }

    @Override
    public void modifiedAttributes(ServerSession session, Path path, Map<String, ?> attrs, Throwable thrown) {
        ++modifiedAttributesEventCount;
        log.trace("{} - modifiedAttributes on {}", session, path);
    }
}