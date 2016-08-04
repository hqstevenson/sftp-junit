package com.pronoia.junit.rule.sftp;

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
