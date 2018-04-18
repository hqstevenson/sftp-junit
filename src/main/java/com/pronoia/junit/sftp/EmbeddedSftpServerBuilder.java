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

public class EmbeddedSftpServerBuilder {
    EmbeddedSftpServerResource sshServerResource = new EmbeddedSftpServerResource();

    public EmbeddedSftpServerResource build() {
        return sshServerResource;
    }

    public EmbeddedSftpServerBuilder host(String hostname) {
        sshServerResource.setHost(hostname);

        return this;
    }

    public EmbeddedSftpServerBuilder port(int port) {
        sshServerResource.setPort(port);

        return this;
    }

    public EmbeddedSftpServerBuilder rootDirectory(String rootDirectory) {
        sshServerResource.setRootDirectory(rootDirectory);

        return this;
    }

    public EmbeddedSftpServerBuilder username(String username) {
        sshServerResource.setUsername(username);

        return this;
    }

    public EmbeddedSftpServerBuilder password(String password) {
        sshServerResource.setPassword(password);

        return this;
    }

}
