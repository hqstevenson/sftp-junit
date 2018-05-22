package com.pronoia.junit.sftp.listener;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;
import java.util.Set;

import org.apache.sshd.common.scp.ScpTransferEventListener;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.event.Level;

/**
 * Tests for the ScpTransferEventLoggingListener class.
 */
public class ScpTransferEventLoggingListenerTest {

    ScpTransferEventLoggingListener instance;
    Level expected;

    ScpTransferEventListener.FileOperation op = ScpTransferEventListener.FileOperation.SEND;
    Path file = Paths.get("target/test-path");
    long length = 1234;
    Set<PosixFilePermission> perms = new HashSet<>();
    Throwable thrown = new Exception("Dummy Exception");

    @Before
    public void setUp() throws Exception {
        instance = spy(new ScpTransferEventLoggingListener());

        expected = Level.ERROR;
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testStartFileEvent() throws Exception {
        instance.setStartFileEventLevel(expected);
        instance.startFileEvent(op, file, length, perms);
        verify(instance).doLog(eq(expected), any(String.class), any(), any(), any(), any());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testEndFileEvent() throws Exception {
        instance.setEndFileEventLevel(expected);
        instance.endFileEvent(op, file, length, perms, thrown);
        verify(instance).doLog(eq(expected), any(String.class), any(), any(), any(), any(), any());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testStartFolderEvent() throws Exception {
        instance.setStartFolderEventLevel(expected);
        instance.startFolderEvent(op, file, perms);
        verify(instance).doLog(eq(expected), any(String.class), any(), any(), any());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testEndFolderEvent() throws Exception {
        instance.setEndFolderEventLevel(expected);
        instance.endFolderEvent(op, file, perms, thrown);
        verify(instance).doLog(eq(expected), any(String.class), any(), any(), any(), any());
    }
}