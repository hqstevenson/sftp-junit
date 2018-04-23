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

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.sshd.server.auth.password.PasswordAuthenticator;
import org.apache.sshd.server.session.ServerSession;

public class SimplePasswordAuthenticator implements PasswordAuthenticator {
    Map<String, String> users = new ConcurrentHashMap<>();

    @Override
    public boolean authenticate(String username, String password, ServerSession session) {
        return users.containsKey(username) && users.get(username).equals(password);
    }

    public Set<String> getUsers() {
        return users.keySet();
    }

    public void addUser(String userName, String password) {
        users.put(userName, password);
    }

    public boolean isUserDefined(String userName) {
        return users.containsKey(userName);
    }

}
