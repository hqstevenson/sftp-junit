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

package com.pronoia.junit.sftp.impl;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

import org.apache.sshd.common.file.root.RootedFileSystemProvider;
import org.apache.sshd.common.file.virtualfs.VirtualFileSystemFactory;
import org.apache.sshd.common.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SftpFilesystemFactory extends VirtualFileSystemFactory {
    private Logger log = LoggerFactory.getLogger(SftpFilesystemFactory.class);

    public SftpFilesystemFactory(Path rootPath, String virtualHomeDirectoryBase) {
        super(rootPath.toAbsolutePath());
    }

    @Override
    public FileSystem createFileSystem(Session session) throws IOException {
        Path rootPath = getRootPath();

        if (!Files.exists(rootPath)) {
            rootPath.toFile().mkdirs();
        }

        return new RootedFileSystemProvider().newFileSystem(rootPath, Collections.emptyMap());
    }

    public Path getRootPath() {
        return getDefaultHomeDir();
    }

    public void setRootPath(String rootPath) {
        this.setRootPath(Paths.get(rootPath));
    }

    public void setRootPath(Path rootPath) { super.setDefaultHomeDir(rootPath.toAbsolutePath());
    }

}
