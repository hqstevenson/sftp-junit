package com.pronoia.junit.sftp.listener;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.event.Level;

/**
 * Tests for the  class.
 */
public class ScpTransferEventLoggingListenerConfigurationTest {

    ScpTransferEventLoggingListener instance;

    @Before
    public void setUp() throws Exception {
        instance = new ScpTransferEventLoggingListener();
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testConstructors() throws Exception {
        assertEquals(Level.INFO, instance.defaultLevel);
        assertNull("Unexpected initial value", instance.startFileEventLevel);
        assertNull("Unexpected initial value", instance.startFileEventLevel);
        assertNull("Unexpected initial value", instance.endFileEventLevel);
        assertNull("Unexpected initial value", instance.startFolderEventLevel);
        assertNull("Unexpected initial value", instance.endFolderEventLevel);

        Level expected = Level.TRACE;

        instance = new ScpTransferEventLoggingListener(expected.toInt());
        assertEquals(expected, instance.defaultLevel);
        assertNull(instance.startFileEventLevel);
        assertNull(instance.startFileEventLevel);
        assertNull(instance.endFileEventLevel);
        assertNull(instance.startFolderEventLevel);
        assertNull(instance.endFolderEventLevel);

        instance = new ScpTransferEventLoggingListener(expected.toString());
        assertEquals(expected, instance.defaultLevel);
        assertNull(instance.startFileEventLevel);
        assertNull(instance.startFileEventLevel);
        assertNull(instance.endFileEventLevel);
        assertNull(instance.startFolderEventLevel);
        assertNull(instance.endFolderEventLevel);

        instance = new ScpTransferEventLoggingListener(expected);
        assertEquals(expected, instance.defaultLevel);
        assertNull(instance.startFileEventLevel);
        assertNull(instance.startFileEventLevel);
        assertNull(instance.endFileEventLevel);
        assertNull(instance.startFolderEventLevel);
        assertNull(instance.endFolderEventLevel);

    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testGetStartFileEventLevel() throws Exception {
        assertNull("Unexpected initial value", instance.startFileEventLevel);

        Level expected = Level.TRACE;
        instance.startFileEventLevel = expected;
        assertEquals(expected, instance.getStartFileEventLevel());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetStartFileEventLevelWithInt() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.startFileEventLevel);

        instance.setStartFileEventLevel(expected.toInt());

        assertEquals(expected, instance.startFileEventLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetStartFileEventLevelWithString() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.startFileEventLevel);

        instance.setStartFileEventLevel(expected.toString());

        assertEquals(expected, instance.startFileEventLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetStartFileEventLevel() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.startFileEventLevel);

        instance.setStartFileEventLevel(expected);

        assertEquals(expected, instance.startFileEventLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testGetEndFileEventLevel() throws Exception {
        assertNull("Unexpected initial value", instance.endFileEventLevel);

        Level expected = Level.TRACE;
        instance.endFileEventLevel = expected;
        assertEquals(expected, instance.getEndFileEventLevel());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetEndFileEventLevelWithInt() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.endFileEventLevel);

        instance.setEndFileEventLevel(expected.toInt());

        assertEquals(expected, instance.endFileEventLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetEndFileEventLevelWithString() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.endFileEventLevel);

        instance.setEndFileEventLevel(expected.toString());

        assertEquals(expected, instance.endFileEventLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetEndFileEventLevel() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.endFileEventLevel);

        instance.setEndFileEventLevel(expected);

        assertEquals(expected, instance.endFileEventLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testGetStartFolderEventLevel() throws Exception {
        assertNull("Unexpected initial value", instance.startFolderEventLevel);

        Level expected = Level.TRACE;
        instance.startFolderEventLevel = expected;
        assertEquals(expected, instance.getStartFolderEventLevel());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetStartFolderEventLevelWithInt() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.startFolderEventLevel);

        instance.setStartFolderEventLevel(expected.toInt());

        assertEquals(expected, instance.startFolderEventLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetStartFolderEventLevelWithString() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.startFolderEventLevel);

        instance.setStartFolderEventLevel(expected.toString());

        assertEquals(expected, instance.startFolderEventLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetStartFolderEventLevel() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.startFolderEventLevel);

        instance.setStartFolderEventLevel(expected);

        assertEquals(expected, instance.startFolderEventLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testGetEndFolderEventLevel() throws Exception {
        assertNull("Unexpected initial value", instance.endFolderEventLevel);

        Level expected = Level.TRACE;
        instance.endFolderEventLevel = expected;
        assertEquals(expected, instance.getEndFolderEventLevel());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetEndFolderEventLevelWithInt() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.endFolderEventLevel);

        instance.setEndFolderEventLevel(expected.toInt());

        assertEquals(expected, instance.endFolderEventLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetEndFolderEventLevelWithString() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.endFolderEventLevel);

        instance.setEndFolderEventLevel(expected.toString());

        assertEquals(expected, instance.endFolderEventLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetEndFolderEventLevel() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.endFolderEventLevel);

        instance.setEndFolderEventLevel(expected);

        assertEquals(expected, instance.endFolderEventLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testDefaultLevelWithInt() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.defaultLevel);

        assertSame(instance, instance.defaultLevel(expected.toInt()));
        assertEquals(expected, instance.defaultLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testDefaultLevelWithString() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.defaultLevel);

        assertSame(instance, instance.defaultLevel(expected.toString()));
        assertEquals(expected, instance.defaultLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testDefaultLevel() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.defaultLevel);

        assertSame(instance, instance.defaultLevel(expected));
        assertEquals(expected, instance.defaultLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testStartFileEventLevelWithInt() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.startFileEventLevel);

        assertSame(instance, instance.startFileEventLevel(expected.toInt()));
        assertEquals(expected, instance.startFileEventLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testStartFileEventLevelWithString() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.startFileEventLevel);

        assertSame(instance, instance.startFileEventLevel(expected.toString()));
        assertEquals(expected, instance.startFileEventLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testStartFileEventLevel() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.startFileEventLevel);

        assertSame(instance, instance.startFileEventLevel(expected));
        assertEquals(expected, instance.startFileEventLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testEndFileEventLevelWithInt() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.endFileEventLevel);

        assertSame(instance, instance.endFileEventLevel(expected.toInt()));
        assertEquals(expected, instance.endFileEventLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testEndFileEventLevelWithString() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.endFileEventLevel);

        assertSame(instance, instance.endFileEventLevel(expected.toString()));
        assertEquals(expected, instance.endFileEventLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testEndFileEventLevel() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.endFileEventLevel);

        assertSame(instance, instance.endFileEventLevel(expected));
        assertEquals(expected, instance.endFileEventLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testStartFolderEventLevelWithInt() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.startFolderEventLevel);

        assertSame(instance, instance.startFolderEventLevel(expected.toInt()));
        assertEquals(expected, instance.startFolderEventLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testStartFolderEventLevelWithString() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.startFolderEventLevel);

        assertSame(instance, instance.startFolderEventLevel(expected.toString()));
        assertEquals(expected, instance.startFolderEventLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testStartFolderEventLevel() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.startFolderEventLevel);

        assertSame(instance, instance.startFolderEventLevel(expected));
        assertEquals(expected, instance.startFolderEventLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testEndFolderEventLevelWithInt() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.endFolderEventLevel);

        assertSame(instance, instance.endFolderEventLevel(expected.toInt()));
        assertEquals(expected, instance.endFolderEventLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testEndFolderEventLevelWithString() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.endFolderEventLevel);

        assertSame(instance, instance.endFolderEventLevel(expected.toString()));
        assertEquals(expected, instance.endFolderEventLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testEndFolderEventLevel() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.endFolderEventLevel);

        assertSame(instance, instance.endFolderEventLevel(expected));
        assertEquals(expected, instance.endFolderEventLevel);
    }
}