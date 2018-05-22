package com.pronoia.junit.sftp.listener;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.apache.sshd.server.session.ServerSession;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Tests for the  class.
 */
public class SftpEventCountingListenerTest {

    SftpEventCountingListener instance;

    ServerSession session = mock(ServerSession.class);
    Path path = Paths.get("target/dummy");
    Map<String, Object> attrs = new HashMap<>();
    Throwable thrown = null;

    @Before
    public void setUp() throws Exception {
        instance = new SftpEventCountingListener();
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testInitialized() throws Exception {
        assertEquals("Unexpected initial value", 0, instance.initializedEventCount);

        instance.initialized(session, 1);
        assertEquals(1, instance.initializedEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testDestroying() throws Exception {
        assertEquals("Unexpected initial value", 0, instance.destroyingEventCount);

        instance.destroying(session);
        assertEquals(1, instance.destroyingEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testCreating() throws Exception {
        assertEquals("Unexpected initial value", 0, instance.creatingEventCount);

        instance.creating(session, path, attrs);
        assertEquals(1, instance.creatingEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testCreated() throws Exception {
        assertEquals("Unexpected initial value", 0, instance.createdEventCount);

        instance.created(session, path, attrs, thrown);
        assertEquals(1, instance.createdEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testRemoving() throws Exception {
        assertEquals("Unexpected initial value", 0, instance.removingEventCount);

        instance.removing(session, path);
        assertEquals(1, instance.removingEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testRemoved() throws Exception {
        assertEquals("Unexpected initial value", 0, instance.removedEventCount);

        instance.removed(session, path, thrown);
        assertEquals(1, instance.removedEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testOpening() throws Exception {
        assertEquals("Unexpected initial value", 0, instance.openingEventCount);

        instance.opening(session, null, null);
        assertEquals(1, instance.openingEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testOpen() throws Exception {
        assertEquals("Unexpected initial value", 0, instance.openEventCount);

        instance.open(session, null, null);
        assertEquals(1, instance.openEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testClose() throws Exception {
        assertEquals("Unexpected initial value", 0, instance.closeEventCount);

        instance.close(session, null, null);
        assertEquals(1, instance.closeEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testReadDirectory() throws Exception {
        assertEquals("Unexpected initial value", 0, instance.readDirectoryEventCount);

        instance.read(session, "remoteHandle", null, new HashMap<>());
        assertEquals(1, instance.readDirectoryEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testReadingFile() throws Exception {
        assertEquals("Unexpected initial value", 0, instance.readingFileEventCount);

        instance.reading(session, "remoteHandle", null, 0, new byte[0], 0, 0);
        assertEquals(1, instance.readingFileEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testReadFile() throws Exception {
        assertEquals("Unexpected initial value", 0, instance.readFileEventCount);

        instance.read(session, "remoteHandle", null, 0, new byte[0], 0, 0, 0, thrown);
        assertEquals(1, instance.readFileEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testWriting() throws Exception {
        assertEquals("Unexpected initial value", 0, instance.writingFileEventCount);

        instance.writing(session, "remoteHandle", null, 0, new byte[0], 0, 0);
        assertEquals(1, instance.writingFileEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testWritten() throws Exception {
        assertEquals("Unexpected initial value", 0, instance.writtenFileEventCount);

        instance.written(session, "remoteHandle", null, 0, new byte[0], 0, 0, thrown);
        assertEquals(1, instance.writtenFileEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testBlocking() throws Exception {
        assertEquals("Unexpected initial value", 0, instance.blockingEventCount);

        instance.blocking(session, "remoteHandle", null, 0,0, 0);
        assertEquals(1, instance.blockingEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testBlocked() throws Exception {
        assertEquals("Unexpected initial value", 0, instance.blockedEventCount);

        instance.blocked(session, "remoteHandle", null, 0,0, 0, thrown);
        assertEquals(1, instance.blockedEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testUnblocking() throws Exception {
        assertEquals("Unexpected initial value", 0, instance.unblockingEventCount);

        instance.unblocking(session, "remoteHandle", null, 0,0);
        assertEquals(1, instance.unblockingEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testUnblocked() throws Exception {
        assertEquals("Unexpected initial value", 0, instance.unblockedEventCount);

        instance.unblocked(session, "remoteHandle", null, 0,0, thrown);
        assertEquals(1, instance.unblockedEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testMoving() throws Exception {
        assertEquals("Unexpected initial value", 0, instance.movingEventCount);

        instance.moving(session, path, null, null);
        assertEquals(1, instance.movingEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testMoved() throws Exception {
        assertEquals("Unexpected initial value", 0, instance.movedEventCount);

        instance.moved(session, path, null, null, thrown);
        assertEquals(1, instance.movedEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testLinking() throws Exception {
        assertEquals("Unexpected initial value", 0, instance.linkingEventCount);

        instance.linking(session, path, null, true);
        assertEquals(1, instance.linkingEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testLinked() throws Exception {
        assertEquals("Unexpected initial value", 0, instance.linkedEventCount);

        instance.linked(session, path, null, true, thrown);
        assertEquals(1, instance.linkedEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testModifyingAttributes() throws Exception {
        assertEquals("Unexpected initial value", 0, instance.modifyingAttributesEventCount);

        instance.modifyingAttributes(session, path, attrs);
        assertEquals(1, instance.modifyingAttributesEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testModifiedAttributes() throws Exception {
        assertEquals("Unexpected initial value", 0, instance.modifiedAttributesEventCount);

        instance.modifiedAttributes(session, path, attrs, thrown);
        assertEquals(1, instance.modifiedAttributesEventCount);
    }
}