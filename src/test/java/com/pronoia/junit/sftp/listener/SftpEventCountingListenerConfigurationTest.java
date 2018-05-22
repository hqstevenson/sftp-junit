package com.pronoia.junit.sftp.listener;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Tests for the  class.
 */
public class SftpEventCountingListenerConfigurationTest {

    SftpEventCountingListener instance;

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
    public void testGetInitializedEventCount() throws Exception {
        assertEquals("Unexpected initial value", 0, instance.getInitializedEventCount());

        instance.initializedEventCount = 9999;
        assertEquals(instance.initializedEventCount, instance.getInitializedEventCount());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetInitializedEventCount() throws Exception {
        int expected = 9999;
        assertNotEquals(expected, instance.initializedEventCount);

        instance.setInitializedEventCount(expected);
        assertEquals(expected, instance.initializedEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testClearInitializedEventCount() throws Exception {
        instance.initializedEventCount = 9999;

        instance.clearInitializedEventCount();
        assertEquals(0, instance.initializedEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testGetDestroyingEventCount() throws Exception {
        assertEquals("Unexpected initial value", 0, instance.getDestroyingEventCount());

        instance.destroyingEventCount = 9999;
        assertEquals(instance.destroyingEventCount, instance.getDestroyingEventCount());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetDestroyingEventCount() throws Exception {
        int expected = 9999;
        assertNotEquals(expected, instance.destroyingEventCount);

        instance.setDestroyingEventCount(expected);
        assertEquals(expected, instance.destroyingEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testClearDestroyingEventCount() throws Exception {
        instance.destroyingEventCount = 9999;

        instance.clearDestroyingEventCount();
        assertEquals(0, instance.initializedEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testGetCreatingEventCount() throws Exception {
        assertEquals("Unexpected initial value", 0, instance.getCreatingEventCount());

        instance.creatingEventCount = 9999;
        assertEquals(instance.creatingEventCount, instance.getCreatingEventCount());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetCreatingEventCount() throws Exception {
        int expected = 9999;
        assertNotEquals(expected, instance.creatingEventCount);

        instance.setCreatingEventCount(expected);
        assertEquals(expected, instance.creatingEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testClearCreatingEventCount() throws Exception {
        instance.creatingEventCount = 9999;

        instance.clearCreatingEventCount();
        assertEquals(0, instance.creatingEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testGetCreatedEventCount() throws Exception {
        assertEquals("Unexpected initial value", 0, instance.getCreatedEventCount());

        instance.createdEventCount = 9999;
        assertEquals(instance.createdEventCount, instance.getCreatedEventCount());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetCreatedEventCount() throws Exception {
        int expected = 9999;
        assertNotEquals(expected, instance.createdEventCount);

        instance.setCreatedEventCount(expected);
        assertEquals(expected, instance.createdEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testClearCreatedEventCount() throws Exception {
        instance.createdEventCount = 9999;

        instance.clearCreatedEventCount();
        assertEquals(0, instance.createdEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testGetRemovingEventCount() throws Exception {
        assertEquals("Unexpected initial value", 0, instance.getRemovingEventCount());

        instance.removingEventCount = 9999;
        assertEquals(instance.removingEventCount, instance.getRemovingEventCount());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetRemovingEventCount() throws Exception {
        int expected = 9999;
        assertNotEquals(expected, instance.removingEventCount);

        instance.setRemovingEventCount(expected);
        assertEquals(expected, instance.removingEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testClearRemovingEventCount() throws Exception {
        instance.removingEventCount = 9999;

        instance.clearRemovingEventCount();
        assertEquals(0, instance.removingEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testGetRemovedEventCount() throws Exception {
        assertEquals("Unexpected initial value", 0, instance.getRemovedEventCount());

        instance.removedEventCount = 9999;
        assertEquals(instance.removedEventCount, instance.getRemovedEventCount());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetRemovedEventCount() throws Exception {
        int expected = 9999;
        assertNotEquals(expected, instance.removedEventCount);

        instance.setRemovedEventCount(expected);
        assertEquals(expected, instance.removedEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testClearRemovedEventCount() throws Exception {
        instance.removedEventCount = 9999;

        instance.clearRemovedEventCount();
        assertEquals(0, instance.removedEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testGetOpeningEventCount() throws Exception {
        assertEquals("Unexpected initial value", 0, instance.getOpeningEventCount());

        instance.openingEventCount = 9999;
        assertEquals(instance.openingEventCount, instance.getOpeningEventCount());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetOpeningEventCount() throws Exception {
        int expected = 9999;
        assertNotEquals(expected, instance.openingEventCount);

        instance.setOpeningEventCount(expected);
        assertEquals(expected, instance.openingEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testClearOpeningEventCount() throws Exception {
        instance.openingEventCount = 9999;

        instance.clearOpeningEventCount();
        assertEquals(0, instance.openingEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testGetOpenEventCount() throws Exception {
        assertEquals("Unexpected initial value", 0, instance.getOpenEventCount());

        instance.openEventCount = 9999;
        assertEquals(instance.openEventCount, instance.getOpenEventCount());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetOpenEventCount() throws Exception {
        int expected = 9999;
        assertNotEquals(expected, instance.openEventCount);

        instance.setOpenEventCount(expected);
        assertEquals(expected, instance.openEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testClearOpenEventCount() throws Exception {
        instance.openEventCount = 9999;

        instance.clearOpenEventCount();
        assertEquals(0, instance.openEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testGetCloseEventCount() throws Exception {
        assertEquals("Unexpected initial value", 0, instance.getCloseEventCount());

        instance.closeEventCount = 9999;
        assertEquals(instance.closeEventCount, instance.getCloseEventCount());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetCloseEventCount() throws Exception {
        int expected = 9999;
        assertNotEquals(expected, instance.closeEventCount);

        instance.setCloseEventCount(expected);
        assertEquals(expected, instance.closeEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testClearCloseEventCount() throws Exception {
        instance.closeEventCount = 9999;

        instance.clearCloseEventCount();
        assertEquals(0, instance.closeEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testGetReadDirectoryEventCount() throws Exception {
        assertEquals("Unexpected initial value", 0, instance.getReadDirectoryEventCount());

        instance.readDirectoryEventCount = 9999;
        assertEquals(instance.readDirectoryEventCount, instance.getReadDirectoryEventCount());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetReadDirectoryEventCount() throws Exception {
        int expected = 9999;
        assertNotEquals(expected, instance.readDirectoryEventCount);

        instance.setReadDirectoryEventCount(expected);
        assertEquals(expected, instance.readDirectoryEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testClearReadDirectoryEventCount() throws Exception {
        instance.readDirectoryEventCount = 9999;

        instance.clearReadDirectoryEventCount();
        assertEquals(0, instance.readDirectoryEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testGetReadingFileEventCount() throws Exception {
        assertEquals("Unexpected initial value", 0, instance.getReadingFileEventCount());

        instance.readingFileEventCount = 9999;
        assertEquals(instance.readingFileEventCount, instance.getReadingFileEventCount());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetReadingFileEventCount() throws Exception {
        int expected = 9999;
        assertNotEquals(expected, instance.readingFileEventCount);

        instance.setReadingFileEventCount(expected);
        assertEquals(expected, instance.readingFileEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testClearReadingFileEventCount() throws Exception {
        instance.readingFileEventCount = 9999;

        instance.clearReadingFileEventCount();
        assertEquals(0, instance.readingFileEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testGetReadFileEventCount() throws Exception {
        assertEquals("Unexpected initial value", 0, instance.getReadFileEventCount());

        instance.readFileEventCount = 9999;
        assertEquals(instance.readFileEventCount, instance.getReadFileEventCount());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetReadFileEventCount() throws Exception {
        int expected = 9999;
        assertNotEquals(expected, instance.readFileEventCount);

        instance.setReadFileEventCount(expected);
        assertEquals(expected, instance.readFileEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testClearReadFileEventCount() throws Exception {
        instance.readFileEventCount = 9999;

        instance.clearReadFileEventCount();
        assertEquals(0, instance.readFileEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testGetWritingFileEventCount() throws Exception {
        assertEquals("Unexpected initial value", 0, instance.getWritingFileEventCount());

        instance.writingFileEventCount = 9999;
        assertEquals(instance.writingFileEventCount, instance.getWritingFileEventCount());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetWritingFileEventCount() throws Exception {
        int expected = 9999;
        assertNotEquals(expected, instance.writingFileEventCount);

        instance.setWritingFileEventCount(expected);
        assertEquals(expected, instance.writingFileEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testClearWritingFileEventCount() throws Exception {
        instance.writingFileEventCount = 9999;

        instance.clearWritingFileEventCount();
        assertEquals(0, instance.writingFileEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testGetWrittenFileEventCount() throws Exception {
        assertEquals("Unexpected initial value", 0, instance.getWrittenFileEventCount());

        instance.writtenFileEventCount = 9999;
        assertEquals(instance.writtenFileEventCount, instance.getWrittenFileEventCount());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetWrittenFileEventCount() throws Exception {
        int expected = 9999;
        assertNotEquals(expected, instance.writtenFileEventCount);

        instance.setWrittenFileEventCount(expected);
        assertEquals(expected, instance.writtenFileEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testClearWrittenFileEventCount() throws Exception {
        instance.writtenFileEventCount = 9999;

        instance.clearWrittenFileEventCount();
        assertEquals(0, instance.writtenFileEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testGetBlockingEventCount() throws Exception {
        assertEquals("Unexpected initial value", 0, instance.getBlockingEventCount());

        instance.blockingEventCount = 9999;
        assertEquals(instance.blockingEventCount, instance.getBlockingEventCount());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetBlockingEventCount() throws Exception {
        int expected = 9999;
        assertNotEquals(expected, instance.blockingEventCount);

        instance.setBlockingEventCount(expected);
        assertEquals(expected, instance.blockingEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testClearBlockingEventCount() throws Exception {
        instance.blockingEventCount = 9999;

        instance.clearBlockingEventCount();
        assertEquals(0, instance.blockingEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testGetBlockedEventCount() throws Exception {
        assertEquals("Unexpected initial value", 0, instance.getBlockedEventCount());

        instance.blockedEventCount = 9999;
        assertEquals(instance.blockedEventCount, instance.getBlockedEventCount());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetBlockedEventCount() throws Exception {
        int expected = 9999;
        assertNotEquals(expected, instance.blockedEventCount);

        instance.setBlockedEventCount(expected);
        assertEquals(expected, instance.blockedEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testClearBlockedEventCount() throws Exception {
        instance.blockedEventCount = 9999;

        instance.clearBlockedEventCount();
        assertEquals(0, instance.blockedEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testGetUnblockingEventCount() throws Exception {
        assertEquals("Unexpected initial value", 0, instance.getUnblockingEventCount());

        instance.unblockingEventCount = 9999;
        assertEquals(instance.unblockingEventCount, instance.getUnblockingEventCount());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetUnblockingEventCount() throws Exception {
        int expected = 9999;
        assertNotEquals(expected, instance.unblockingEventCount);

        instance.setUnblockingEventCount(expected);
        assertEquals(expected, instance.unblockingEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testClearUnblockingEventCount() throws Exception {
        instance.unblockingEventCount = 9999;

        instance.clearUnblockingEventCount();
        assertEquals(0, instance.unblockingEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testGetUnblockedEventCount() throws Exception {
        assertEquals("Unexpected initial value", 0, instance.getUnblockedEventCount());

        instance.unblockedEventCount = 9999;
        assertEquals(instance.unblockedEventCount, instance.getUnblockedEventCount());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetUnblockedEventCount() throws Exception {
        int expected = 9999;
        assertNotEquals(expected, instance.unblockedEventCount);

        instance.setUnblockedEventCount(expected);
        assertEquals(expected, instance.unblockedEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testClearUnblockedEventCount() throws Exception {
        instance.unblockedEventCount = 9999;

        instance.clearUnblockedEventCount();
        assertEquals(0, instance.unblockedEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testGetMovingEventCount() throws Exception {
        assertEquals("Unexpected initial value", 0, instance.getMovingEventCount());

        instance.movingEventCount = 9999;
        assertEquals(instance.movingEventCount, instance.getMovingEventCount());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetMovingEventCount() throws Exception {
        int expected = 9999;
        assertNotEquals(expected, instance.movingEventCount);

        instance.setMovingEventCount(expected);
        assertEquals(expected, instance.movingEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testClearMovingEventCount() throws Exception {
        instance.movingEventCount = 9999;

        instance.clearMovingEventCount();
        assertEquals(0, instance.movingEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testGetMovedEventCount() throws Exception {
        assertEquals("Unexpected initial value", 0, instance.getMovedEventCount());

        instance.movedEventCount = 9999;
        assertEquals(instance.movedEventCount, instance.getMovedEventCount());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetMovedEventCount() throws Exception {
        int expected = 9999;
        assertNotEquals(expected, instance.movedEventCount);

        instance.setMovedEventCount(expected);
        assertEquals(expected, instance.movedEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testClearMovedEventCount() throws Exception {
        instance.movedEventCount = 9999;

        instance.clearMovedEventCount();
        assertEquals(0, instance.movedEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testGetLinkingEventCount() throws Exception {
        assertEquals("Unexpected initial value", 0, instance.getLinkingEventCount());

        instance.linkingEventCount = 9999;
        assertEquals(instance.linkingEventCount, instance.getLinkingEventCount());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetLinkingEventCount() throws Exception {
        int expected = 9999;
        assertNotEquals(expected, instance.linkingEventCount);

        instance.setLinkingEventCount(expected);
        assertEquals(expected, instance.linkingEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testClearLinkingEventCount() throws Exception {
        instance.linkingEventCount = 9999;

        instance.clearLinkingEventCount();
        assertEquals(0, instance.linkingEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testGetLinkedEventCount() throws Exception {
        assertEquals("Unexpected initial value", 0, instance.getLinkedEventCount());

        instance.linkedEventCount = 9999;
        assertEquals(instance.linkedEventCount, instance.getLinkedEventCount());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetLinkedEventCount() throws Exception {
        int expected = 9999;
        assertNotEquals(expected, instance.linkedEventCount);

        instance.setLinkedEventCount(expected);
        assertEquals(expected, instance.linkedEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testClearLinkedEventCount() throws Exception {
        instance.linkedEventCount = 9999;

        instance.clearLinkedEventCount();
        assertEquals(0, instance.linkedEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testGetModifyingAttributesEventCount() throws Exception {
        assertEquals("Unexpected initial value", 0, instance.getModifyingAttributesEventCount());

        instance.modifyingAttributesEventCount = 9999;
        assertEquals(instance.modifyingAttributesEventCount, instance.getModifyingAttributesEventCount());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetModifyingAttributesEventCount() throws Exception {
        int expected = 9999;
        assertNotEquals(expected, instance.modifyingAttributesEventCount);

        instance.setModifyingAttributesEventCount(expected);
        assertEquals(expected, instance.modifyingAttributesEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testClearModifyingAttributesEventCount() throws Exception {
        instance.modifyingAttributesEventCount = 9999;

        instance.clearModifyingAttributesEventCount();
        assertEquals(0, instance.modifyingAttributesEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testGetModifiedAttributesEventCount() throws Exception {
        assertEquals("Unexpected initial value", 0, instance.getModifiedAttributesEventCount());

        instance.modifiedAttributesEventCount = 9999;
        assertEquals(instance.modifiedAttributesEventCount, instance.getModifiedAttributesEventCount());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetModifiedAttributesEventCount() throws Exception {
        int expected = 9999;
        assertNotEquals(expected, instance.modifiedAttributesEventCount);

        instance.setModifiedAttributesEventCount(expected);
        assertEquals(expected, instance.modifiedAttributesEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testClearModifiedAttributesEventCount() throws Exception {
        instance.modifiedAttributesEventCount = 9999;

        instance.clearModifiedAttributesEventCount();
        assertEquals(0, instance.modifiedAttributesEventCount);
    }
}