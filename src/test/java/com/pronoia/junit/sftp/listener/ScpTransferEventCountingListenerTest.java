package com.pronoia.junit.sftp.listener;

import static org.junit.Assert.assertEquals;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;
import java.util.Set;

import org.apache.sshd.common.scp.ScpTransferEventListener;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Tests for the  class.
 */
public class ScpTransferEventCountingListenerTest {

    ScpTransferEventCountingListener instance;

    ScpTransferEventListener.FileOperation op = ScpTransferEventListener.FileOperation.SEND;
    Path file = Paths.get("target/test-path");
    long length = 1234;
    Set<PosixFilePermission> perms = new HashSet<>();
    Throwable thrown = new Exception("Dummy Exception");

    @Before
    public void setUp() throws Exception {
        instance = new ScpTransferEventCountingListener();
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testStartFileEvent() throws Exception {
        assertEquals("Unexpected initial value", 0, instance.startFileEventCount);

        instance.startFileEvent(op, file, length, perms);
        assertEquals(1, instance.startFileEventCount);

        instance.startFileEvent(null, file, length, perms);
        assertEquals(2, instance.startFileEventCount);

        instance.startFileEvent(op, null, length, perms);
        assertEquals(3, instance.startFileEventCount);

        instance.startFileEvent(op, file, length, null);
        assertEquals(4, instance.startFileEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testEndFileEvent() throws Exception {
        assertEquals("Unexpected initial value", 0, instance.endFileEventCount);

        instance.endFileEvent(op, file, length, perms, thrown);
        assertEquals(1, instance.endFileEventCount);

        instance.endFileEvent(null, file, length, perms, thrown);
        assertEquals(2, instance.endFileEventCount);

        instance.endFileEvent(op, null, length, perms, thrown);
        assertEquals(3, instance.endFileEventCount);

        instance.endFileEvent(op, file, length, null, thrown);
        assertEquals(4, instance.endFileEventCount);

        instance.endFileEvent(op, file, length, perms, null);
        assertEquals(5, instance.endFileEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testStartFolderEvent() throws Exception {
        assertEquals("Unexpected initial value", 0, instance.startFolderEventCount);

        instance.startFolderEvent(op, file, perms);
        assertEquals(1, instance.startFolderEventCount);

        instance.startFolderEvent(null, file, perms);
        assertEquals(2, instance.startFolderEventCount);

        instance.startFolderEvent(op, null, perms);
        assertEquals(3, instance.startFolderEventCount);

        instance.startFolderEvent(op, file, null);
        assertEquals(4, instance.startFolderEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testEndFolderEvent() throws Exception {
        assertEquals("Unexpected initial value", 0, instance.endFolderEventCount);

        instance.endFolderEvent(op, file, perms, thrown);
        assertEquals(1, instance.endFolderEventCount);

        instance.endFolderEvent(null, file, perms, thrown);
        assertEquals(2, instance.endFolderEventCount);

        instance.endFolderEvent(op, null, perms, thrown);
        assertEquals(3, instance.endFolderEventCount);

        instance.endFolderEvent(op, file, null, thrown);
        assertEquals(4, instance.endFolderEventCount);

        instance.endFolderEvent(op, file, perms, null);
        assertEquals(5, instance.endFolderEventCount);
    }
}