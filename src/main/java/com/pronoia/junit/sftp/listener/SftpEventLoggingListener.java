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

import java.nio.file.CopyOption;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Map;

import org.apache.sshd.server.session.ServerSession;
import org.apache.sshd.server.subsystem.sftp.DirectoryHandle;
import org.apache.sshd.server.subsystem.sftp.FileHandle;
import org.apache.sshd.server.subsystem.sftp.Handle;
import org.apache.sshd.server.subsystem.sftp.SftpEventListener;

import org.slf4j.event.Level;

public class SftpEventLoggingListener extends EventLoggingListenerSupport implements SftpEventListener {
    Level sessionLevel;
    Level createLevel;
    Level openLevel;
    Level readLevel;
    Level writeLevel;
    Level blockLevel;
    Level moveLevel;
    Level linkLevel;
    Level modifyAttributesLevel;

    public SftpEventLoggingListener() {
        super();
    }

    public SftpEventLoggingListener(int defaultLevel) {
        super(defaultLevel);
    }

    public SftpEventLoggingListener(String defaultLevel) {
        super(defaultLevel);
    }

    public SftpEventLoggingListener(Level defaultLevel) {
        super(defaultLevel);
    }


    @Override
    public void initialized(ServerSession session, int version) {
        doLog(sessionLevel, "initialized(ServerSession = {}, version = {})", session, version);
    }

    @Override
    public void destroying(ServerSession session) {
        doLog(sessionLevel, "destroying(ServerSession = {})", session);
    }

    @Override
    public void creating(ServerSession session, Path path, Map<String, ?> attrs) {
        doLog(createLevel, "creating(ServerSession = {}, Path = {}, attrs = {})", session, path, attrs);
    }

    @Override
    public void created(ServerSession session, Path path, Map<String, ?> attrs, Throwable thrown) {
        doLog(createLevel, "created(ServerSession = {}, Path = {}, attrs = {})", session, path, thrown);
    }

    @Override
    public void removing(ServerSession session, Path path) {
        doLog(createLevel, "removing(ServerSession = {}, Path = {})", session, path);
    }

    @Override
    public void removed(ServerSession session, Path path, Throwable thrown) {
        doLog(createLevel, "removed(ServerSession = {}, Path = {}, Throwable = {})", session, path, thrown);
    }

    @Override
    public void opening(ServerSession session, String remoteHandle, Handle localHandle) {
        doLog(openLevel, "opening(ServerSession = {}, remoteHandle = {}, localHandle = {})", session, remoteHandle, localHandle);
    }

    @Override
    public void open(ServerSession session, String remoteHandle, Handle localHandle) {
        doLog(openLevel, "open(ServerSession = {}, remoteHandle = {}, localHandle = {})", session, remoteHandle, localHandle);
    }

    @Override
    public void close(ServerSession session, String remoteHandle, Handle localHandle) {
        doLog(openLevel, "close(ServerSession = {}, remoteHandle = {}, localHandle = {})", session, remoteHandle, localHandle);
    }

    @Override
    public void read(ServerSession session, String remoteHandle, DirectoryHandle localHandle, Map<String, Path> entries) {
        doLog(readLevel, "read(ServerSession = {}, remoteHandle = {}, DirectoryHandle ={}, entries = {})", session, remoteHandle, localHandle, entries);
    }

    @Override
    public void reading(ServerSession session, String remoteHandle, FileHandle localHandle, long offset, byte[] data, int dataOffset, int dataLen) {
        doLog(readLevel, "reading(ServerSession = {}, remoteHandle = {}, FileHandle = {}, offset = {}, data = byte[{}], dataOffset = {}, dataLen = {})",
            session, remoteHandle, localHandle, offset, data == null ? -1 : data.length, dataOffset, dataLen);
    }

    @Override
    public void read(ServerSession session, String remoteHandle, FileHandle localHandle, long offset, byte[] data, int dataOffset, int dataLen, int readLen, Throwable thrown) {
        doLog(readLevel, "read(ServerSession = {}, remoteHandle = {}, FileHandle = {}, offset = {}, data = byte[{}], dataOffset = {}, dataLen = {}, readLen = {}, thrown = {})",
            session, remoteHandle, localHandle, offset,  data == null ? -1 : data.length, dataOffset, dataLen, readLen, thrown);
    }

    @Override
    public void writing(ServerSession session, String remoteHandle, FileHandle localHandle, long offset, byte[] data, int dataOffset, int dataLen) {
        doLog(writeLevel, "writing(ServerSession = {}, remoteHandle = {}, FileHandle = {}, offset = {}, data = byte[{}], dataOffset = {}, dataLen = {})",
            session, remoteHandle, localHandle, offset,  data == null ? -1 : data.length, dataOffset, dataLen);
    }

    @Override
    public void written(ServerSession session, String remoteHandle, FileHandle localHandle, long offset, byte[] data, int dataOffset, int dataLen, Throwable thrown) {
        doLog(writeLevel, "written(ServerSession = {}, remoteHandle = {}, FileHandle = {}, offset = {}, data = byte[{}], dataOffset = {}, dataLen = {}, thrown = {})",
            session, remoteHandle, localHandle, offset, data == null ? -1 : data.length, dataOffset, dataLen, thrown);
    }

    @Override
    public void blocking(ServerSession session, String remoteHandle, FileHandle localHandle, long offset, long length, int mask) {
        doLog(blockLevel, "blocking(ServerSession = {}, remoteHandle = {}, FileHandle = {}, offset = {}, length = {}, mask = {})", session, remoteHandle, localHandle, offset, length, mask);
    }

    @Override
    public void blocked(ServerSession session, String remoteHandle, FileHandle localHandle, long offset, long length, int mask, Throwable thrown) {
        doLog(blockLevel, "blocked(ServerSession = {}, remoteHandle = {}, FileHandle = {}, offset = {}, length = {}, mask = {}, Throwable = {})",
            session, remoteHandle, localHandle, offset, length, mask, thrown);
    }

    @Override
    public void unblocking(ServerSession session, String remoteHandle, FileHandle localHandle, long offset, long length) {
        doLog(blockLevel, "unblocking(ServerSession = {}, remoteHandle = {}, FileHandle = {}, offset = {}, length = {})", session, remoteHandle, localHandle, offset, length);
    }

    @Override
    public void unblocked(ServerSession session, String remoteHandle, FileHandle localHandle, long offset, long length, Throwable thrown) {
        doLog(blockLevel, "unblocked(ServerSession = {}, remoteHandle = {}, FileHandle = {}, offset = {}, length = {}, Throwable = {})",
            session, remoteHandle, localHandle, offset, length, thrown);
    }

    @Override
    public void moving(ServerSession session, Path srcPath, Path dstPath, Collection<CopyOption> opts) {
        doLog(moveLevel, "moved(ServerSession = {}, srcPath = {}, dstPath = {}, opts = {})", session, srcPath, dstPath, opts);
    }

    @Override
    public void moved(ServerSession session, Path srcPath, Path dstPath, Collection<CopyOption> opts, Throwable thrown) {
        doLog(moveLevel, "moved(ServerSession = {}, srcPath = {}, dstPath = {}, opts = {}, Throwable = {})", session, srcPath, dstPath, opts, thrown);
    }

    @Override
    public void linking(ServerSession session, Path srcPath, Path dstPath, boolean symLink) {
        doLog(linkLevel, "linking(ServerSession = {}, srcPath = {}, dstPath = {}, symLink = {})", session, srcPath, dstPath, symLink);
    }

    @Override
    public void linked(ServerSession session, Path srcPath, Path dstPath, boolean symLink, Throwable thrown) {
        doLog(linkLevel, "linked(ServerSession = {}, srcPath = {}, dstPath = {}, symLink = {},  Throwable ={})", session, srcPath, dstPath, symLink, thrown);
    }

    @Override
    public void modifyingAttributes(ServerSession session, Path path, Map<String, ?> attrs) {
        doLog(modifyAttributesLevel, "modifyingAttributes(ServerSession = {}, Path = {}, attrs = {})", session, path, attrs);
    }

    @Override
    public void modifiedAttributes(ServerSession session, Path path, Map<String, ?> attrs, Throwable thrown) {
        doLog(modifyAttributesLevel, "modifiedAttributes(ServerSession = {}, Path = {}, attrs = {}, Throwable = {})", session, path, attrs, thrown);
    }

    public Level getSessionLevel() {
        return sessionLevel;
    }

    public void setSessionLevel(int level) {
        setSessionLevel(toLevel(level));
    }

    public void setSessionLevel(String level) {
        setSessionLevel(toLevel(level));
    }

    public void setSessionLevel(Level level) {
        this.sessionLevel = level;
    }

    public Level getCreateLevel() {
        return createLevel;
    }

    public void setCreateLevel(int level) {
        setCreateLevel(toLevel(level));
    }

    public void setCreateLevel(String level) {
        setCreateLevel(toLevel(level));
    }

    public void setCreateLevel(Level level) {
        this.createLevel = level;
    }

    public Level getOpenLevel() {
        return openLevel;
    }

    public void setOpenLevel(int level) {
        setOpenLevel(toLevel(level));
    }

    public void setOpenLevel(String level) {
        setOpenLevel(toLevel(level));
    }

    public void setOpenLevel(Level level) {
        this.openLevel = level;
    }

    public Level getReadLevel() {
        return readLevel;
    }

    public void setReadLevel(int level) {
        setReadLevel(toLevel(level));
    }

    public void setReadLevel(String level) {
        setReadLevel(toLevel(level));
    }

    public void setReadLevel(Level level) {
        this.readLevel = level;
    }

    public Level getWriteLevel() {
        return writeLevel;
    }

    public void setWriteLevel(int level) {
        setWriteLevel(toLevel(level));
    }

    public void setWriteLevel(String level) {
        setWriteLevel(toLevel(level));
    }

    public void setWriteLevel(Level level) {
        this.writeLevel = level;
    }

    public Level getBlockLevel() {
        return blockLevel;
    }

    public void setBlockLevel(int level) {
        setBlockLevel(toLevel(level));
    }

    public void setBlockLevel(String level) {
        setBlockLevel(toLevel(level));
    }

    public void setBlockLevel(Level level) {
        this.blockLevel = level;
    }

    public Level getMoveLevel() {
        return moveLevel;
    }

    public void setMoveLevel(int level) {
        setMoveLevel(toLevel(level));
    }

    public void setMoveLevel(String level) {
        setMoveLevel(toLevel(level));
    }

    public void setMoveLevel(Level level) {
        this.moveLevel = level;
    }

    public Level getLinkLevel() {
        return linkLevel;
    }

    public void setLinkLevel(int level) {
        setLinkLevel(toLevel(level));
    }

    public void setLinkLevel(String level) {
        setLinkLevel(toLevel(level));
    }

    public void setLinkLevel(Level level) {
        this.linkLevel = level;
    }

    public Level getModifyAttributesLevel() {
        return modifyAttributesLevel;
    }

    public void setModifyAttributesLevel(int level) {
        setModifyAttributesLevel(toLevel(level));
    }

    public void setModifyAttributesLevel(String level) {
        setModifyAttributesLevel(toLevel(level));
    }

    public void setModifyAttributesLevel(Level level) {
        this.modifyAttributesLevel = level;
    }

    public SftpEventLoggingListener defaultLevel(int level) {
        setDefaultLevel(level);
        return this;
    }

    public SftpEventLoggingListener defaultLevel(String level) {
        setDefaultLevel(level);
        return this;
    }

    public SftpEventLoggingListener defaultLevel(Level level) {
        setDefaultLevel(level);
        return this;
    }

    public SftpEventLoggingListener sessionLevel(int level) {
        setSessionLevel(level);
        return this;
    }

    public SftpEventLoggingListener sessionLevel(String level) {
        setSessionLevel(level);
        return this;
    }

    public SftpEventLoggingListener sessionLevel(Level level) {
        setSessionLevel(level);
        return this;
    }

    public SftpEventLoggingListener createLevel(int level) {
        setCreateLevel(level);
        return this;
    }

    public SftpEventLoggingListener createLevel(String level) {
        setCreateLevel(level);
        return this;
    }

    public SftpEventLoggingListener createLevel(Level level) {
        setCreateLevel(level);
        return this;
    }

    public SftpEventLoggingListener openLevel(int level) {
        setOpenLevel(level);
        return this;
    }

    public SftpEventLoggingListener openLevel(String level) {
        setOpenLevel(level);
        return this;
    }

    public SftpEventLoggingListener openLevel(Level level) {
        setOpenLevel(level);
        return this;
    }

    public SftpEventLoggingListener readLevel(int level) {
        setReadLevel(level);
        return this;
    }

    public SftpEventLoggingListener readLevel(String level) {
        setReadLevel(level);
        return this;
    }

    public SftpEventLoggingListener readLevel(Level level) {
        setReadLevel(level);
        return this;
    }

    public SftpEventLoggingListener writeLevel(int level) {
        setWriteLevel(level);
        return this;
    }

    public SftpEventLoggingListener writeLevel(String level) {
        setWriteLevel(level);
        return this;
    }

    public SftpEventLoggingListener writeLevel(Level level) {
        setWriteLevel(level);
        return this;
    }

    public SftpEventLoggingListener blockLevel(int level) {
        setBlockLevel(level);
        return this;
    }

    public SftpEventLoggingListener blockLevel(String level) {
        setBlockLevel(level);
        return this;
    }

    public SftpEventLoggingListener blockLevel(Level level) {
        setBlockLevel(level);
        return this;
    }

    public SftpEventLoggingListener moveLevel(int level) {
        setMoveLevel(level);
        return this;
    }

    public SftpEventLoggingListener moveLevel(String level) {
        setMoveLevel(level);
        return this;
    }

    public SftpEventLoggingListener moveLevel(Level level) {
        setMoveLevel(level);
        return this;
    }

    public SftpEventLoggingListener linkLevel(int level) {
        setLinkLevel(level);
        return this;
    }

    public SftpEventLoggingListener linkLevel(String level) {
        setLinkLevel(level);
        return this;
    }

    public SftpEventLoggingListener linkLevel(Level level) {
        setLinkLevel(level);
        return this;
    }

    public SftpEventLoggingListener modifyAttributesLevel(int level) {
        setModifyAttributesLevel(level);
        return this;
    }

    public SftpEventLoggingListener modifyAttributesLevel(String level) {
        setModifyAttributesLevel(level);
        return this;
    }

    public SftpEventLoggingListener modifyAttributesLevel(Level level) {
        setModifyAttributesLevel(level);
        return this;
    }

}