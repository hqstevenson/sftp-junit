package com.pronoia.junit.sftp.listener;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.apache.sshd.server.session.ServerSession;

import org.junit.Before;
import org.junit.Test;

import org.slf4j.event.Level;

/**
 * Tests for the  class.
 */
public class SftpEventLoggingListenerTest {

    SftpEventLoggingListener instance;

    Level expected;

    ServerSession session = mock(ServerSession.class);
    Path path = Paths.get("target/dummy");
    Map<String, Object> attrs = new HashMap<>();
    Throwable thrown = null;

    @Before
    public void setUp() throws Exception {
        instance = spy(new SftpEventLoggingListener());

        expected = Level.ERROR;
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testInitialized() throws Exception {
        instance.setSessionLevel(expected);
        instance.initialized(session, 1234);
        verify(instance).doLog(eq(expected), any(String.class), any(ServerSession.class), any());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testDestroying() throws Exception {
        instance.setSessionLevel(expected);
        instance.destroying(session);
        verify(instance).doLog(eq(expected), any(String.class), any(ServerSession.class));
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testCreating() throws Exception {
        instance.setCreateLevel(expected);
        instance.creating(session, path, attrs);
        verify(instance).doLog(eq(expected), any(String.class), any(ServerSession.class), any(), any());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testCreated() throws Exception {
        instance.setCreateLevel(expected);
        instance.created(session, path, attrs, thrown);
        verify(instance).doLog(eq(expected), any(String.class), any(ServerSession.class), any(), any());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testRemoving() throws Exception {
        instance.setCreateLevel(expected);
        instance.removing(session, path);
        verify(instance).doLog(eq(expected), any(String.class), any(ServerSession.class), any());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testRemoved() throws Exception {
        instance.setCreateLevel(expected);
        instance.removed(session, path, thrown);
        verify(instance).doLog(eq(expected), any(String.class), any(ServerSession.class), any(), any());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testOpening() throws Exception {
        instance.setOpenLevel(expected);
        instance.opening(session, null, null);
        verify(instance).doLog(eq(expected), any(String.class), any(ServerSession.class), any(), any());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testOpen() throws Exception {
        instance.setOpenLevel(expected);
        instance.open(session, null, null);
        verify(instance).doLog(eq(expected), any(String.class), any(ServerSession.class), any(), any());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testClose() throws Exception {
        instance.setOpenLevel(expected);
        instance.close(session, null, null);
        verify(instance).doLog(eq(expected), any(String.class), any(ServerSession.class), any(), any());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testReadDirectory() throws Exception {
        instance.setReadLevel(expected);
        instance.read(session, null, null, null);
        verify(instance).doLog(eq(expected), any(String.class), any(ServerSession.class), any(), any(), any());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testReading() throws Exception {
        instance.setReadLevel(expected);
        instance.reading(session, null, null,0, null, 0, 0);
        verify(instance).doLog(eq(expected), any(String.class), any(ServerSession.class), any(), any(), any(), any(), any(), any());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testRead() throws Exception {
        instance.setReadLevel(expected);
        instance.read(session, null, null, 0, null, 0, 0,0 , thrown);
        verify(instance).doLog(eq(expected), any(String.class), any(ServerSession.class), any(), any(), any(), any(), any(), any(), any(), any());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testWriting() throws Exception {
        instance.setWriteLevel(expected);
        instance.writing(session, null, null,0, null, 0, 0);
        verify(instance).doLog(eq(expected), any(String.class), any(ServerSession.class), any(), any(), any(), any(), any(), any());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testWritten() throws Exception {
        instance.setWriteLevel(expected);
        instance.written(session, null, null,0, null, 0, 0, thrown);
        verify(instance).doLog(eq(expected), any(String.class), any(ServerSession.class), any(), any(), any(), any(), any(), any(), any());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testBlocking() throws Exception {
        instance.setBlockLevel(expected);
        instance.blocking(session, null, null, 0, 0, 0);
        verify(instance).doLog(eq(expected), any(String.class), any(ServerSession.class), any(), any(), any(), any(), any());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testBlocked() throws Exception {
        instance.setBlockLevel(expected);
        instance.blocked(session, null, null, 0, 0, 0, thrown);
        verify(instance).doLog(eq(expected), any(String.class), any(ServerSession.class), any(), any(), any(), any(), any(), any());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testUnblocking() throws Exception {
        instance.setBlockLevel(expected);
        instance.unblocking(session, null, null, 0, 0);
        verify(instance).doLog(eq(expected), any(String.class), any(ServerSession.class), any(), any(), any(), any());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testUnblocked() throws Exception {
        instance.setBlockLevel(expected);
        instance.unblocked(session, null, null, 0, 0, thrown);
        verify(instance).doLog(eq(expected), any(String.class), any(ServerSession.class), any(), any(), any(), any(), any());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testMoving() throws Exception {
        instance.setMoveLevel(expected);
        instance.moving(session, null, null, null);
        verify(instance).doLog(eq(expected), any(String.class), any(ServerSession.class), any(), any(), any());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testMoved() throws Exception {
        instance.setMoveLevel(expected);
        instance.moved(session, null, null, null, thrown);
        verify(instance).doLog(eq(expected), any(String.class), any(ServerSession.class), any(), any(), any(), any());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testLinking() throws Exception {
        instance.setLinkLevel(expected);
        instance.linking(session, null, null, true);
        verify(instance).doLog(eq(expected), any(String.class), any(ServerSession.class), any(), any(), any());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testLinked() throws Exception {
        instance.setLinkLevel(expected);
        instance.linked(session, null, null, true, thrown);
        verify(instance).doLog(eq(expected), any(String.class), any(ServerSession.class), any(), any(), any(), any());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testModifyingAttributes() throws Exception {
        instance.setModifyAttributesLevel(expected);
        instance.modifyingAttributes(session, null, null);
        verify(instance).doLog(eq(expected), any(String.class), any(ServerSession.class), any(), any());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testModifiedAttributes() throws Exception {
        instance.setModifyAttributesLevel(expected);
        instance.modifiedAttributes(session, null, null, thrown);
        verify(instance).doLog(eq(expected), any(String.class), any(ServerSession.class), any(), any(), any());
    }
}