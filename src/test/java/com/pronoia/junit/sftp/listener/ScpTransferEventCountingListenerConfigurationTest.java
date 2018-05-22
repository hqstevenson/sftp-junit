package com.pronoia.junit.sftp.listener;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests for the ScpTransferEventCountingListener configuration methods.
 */
public class ScpTransferEventCountingListenerConfigurationTest {

    ScpTransferEventCountingListener instance;

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
    public void testGetStartFileEventCount() throws Exception {
        assertEquals("Unexpected initial value", 0, instance.getStartFileEventCount());

        instance.startFileEventCount = 9999;
        assertEquals(instance.startFileEventCount, instance.getStartFileEventCount());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetStartFileEventCount() throws Exception {
        int expected = 9999;
        assertNotEquals(expected, instance.startFileEventCount);

        instance.setStartFileEventCount(expected);
        assertEquals(expected, instance.startFileEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testClearStartFileEventCount() throws Exception {
        instance.startFileEventCount = 9999;

        instance.clearStartFileEventCount();
        assertEquals(0, instance.startFileEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testGetEndFileEventCount() throws Exception {
        assertEquals("Unexpected initial value", 0, instance.getEndFileEventCount());

        instance.endFileEventCount = 9999;
        assertEquals(instance.endFileEventCount, instance.getEndFileEventCount());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetEndFileEventCount() throws Exception {
        int expected = 9999;
        assertNotEquals(expected, instance.endFileEventCount);

        instance.setEndFileEventCount(expected);
        assertEquals(expected, instance.endFileEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testClearEndFileEventCount() throws Exception {
        instance.endFileEventCount = 9999;

        instance.clearEndFileEventCount();
        assertEquals(0, instance.endFileEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testGetStartFolderEventCount() throws Exception {
        assertEquals("Unexpected initial value", 0, instance.getStartFolderEventCount());

        instance.startFolderEventCount = 9999;
        assertEquals(instance.startFolderEventCount, instance.getStartFolderEventCount());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetStartFolderEventCount() throws Exception {
        int expected = 9999;
        assertNotEquals(expected, instance.startFolderEventCount);

        instance.setStartFolderEventCount(expected);
        assertEquals(expected, instance.startFolderEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testClearStartFolderEventCount() throws Exception {
        instance.startFolderEventCount = 9999;

        instance.clearStartFolderEventCount();
        assertEquals(0, instance.startFolderEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testGetEndFolderEventCount() throws Exception {
        assertEquals("Unexpected initial value", 0, instance.getEndFolderEventCount());

        instance.endFolderEventCount = 9999;
        assertEquals(instance.endFolderEventCount, instance.getEndFolderEventCount());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetEndFolderEventCount() throws Exception {
        int expected = 9999;
        assertNotEquals(expected, instance.endFolderEventCount);

        instance.setEndFolderEventCount(expected);
        assertEquals(expected, instance.endFolderEventCount);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testClearEndFolderEventCount() throws Exception {
        instance.endFolderEventCount = 9999;

        instance.clearEndFolderEventCount();
        assertEquals(0, instance.endFolderEventCount);
    }
}