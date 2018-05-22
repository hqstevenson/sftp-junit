package com.pronoia.junit.sftp.listener;

import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;


import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.event.Level;

/**
 * Tests for the EventLoggingListenerSupport configuration methods.
 */
public class EventLoggingListenerSupportConfigurationTest {

    EventLoggingListenerSupport instance;

    @Before
    public void setUp() throws Exception {
        instance = new EventLoggingListenerSupport();
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testConstructors() throws Exception {
        assertEquals("Unexpected initial Value", Level.INFO, instance.defaultLevel);

        Level expected = Level.DEBUG;

        instance = new EventLoggingListenerSupport(expected.toInt());
        assertEquals(expected, instance.defaultLevel);

        instance = new EventLoggingListenerSupport(expected.toString());
        assertEquals(expected, instance.defaultLevel);

        instance = new EventLoggingListenerSupport(expected);
        assertEquals(expected, instance.defaultLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testGetDefaultLevel() throws Exception {
        assertEquals("Unexpected initial Value", Level.INFO, instance.defaultLevel);

        Level expected = Level.TRACE;
        instance.defaultLevel = expected;
        assertEquals(expected, instance.getDefaultLevel());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetDefaultLevelWithInt() throws Exception {
        Level expected = Level.TRACE;
        assertNotEquals("Unexpected initial default level", expected, instance.defaultLevel);

        instance.setDefaultLevel(expected.toInt());

        assertEquals(expected, instance.defaultLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetDefaultLevelWithString() throws Exception {
        Level expected = Level.TRACE;
        assertNotEquals("Unexpected initial default level", expected, instance.defaultLevel);

        instance.setDefaultLevel(expected.toString());

        assertEquals(expected, instance.defaultLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetDefaultLevel() throws Exception {
        Level expected = Level.TRACE;
        assertNotEquals("Unexpected initial default level", expected, instance.defaultLevel);

        instance.setDefaultLevel(expected);

        assertEquals(expected, instance.defaultLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testToLevelWithInt() throws Exception {
        for (Level level : Level.values()) {
            assertEquals(level, EventLoggingListenerSupport.toLevel(level.toInt()));
        }

        int invalidLevel = 9999;
        try {
            EventLoggingListenerSupport.toLevel(invalidLevel);
            fail("Should throw an exception for an invalid int value");
        } catch (IllegalArgumentException expectedEx) {
            assertThat(expectedEx.getMessage(), startsWith("Supplied int '" + invalidLevel +"' is not in the list of recognized values: "));
        }
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testToLevelWithString() throws Exception {
        Map<String, Level> supportedValues = new HashMap<>();
        supportedValues.put("ERROR", Level.ERROR);
        supportedValues.put( "ERR", Level.ERROR);
        supportedValues.put( "Error", Level.ERROR);
        supportedValues.put( "error", Level.ERROR);
        supportedValues.put( "Err", Level.ERROR);
        supportedValues.put( "err", Level.ERROR);

        supportedValues.put( "WARNING", Level.WARN);
        supportedValues.put( "WARN", Level.WARN);
        supportedValues.put( "Warning", Level.WARN);
        supportedValues.put( "Warn", Level.WARN);
        supportedValues.put( "warning", Level.WARN);
        supportedValues.put( "warn", Level.WARN);

        supportedValues.put( "INFORMATIONAL", Level.INFO);
        supportedValues.put( "INFORMATION", Level.INFO);
        supportedValues.put( "INFO", Level.INFO);
        supportedValues.put( "Informational", Level.INFO);
        supportedValues.put( "Information", Level.INFO);
        supportedValues.put( "Info", Level.INFO);
        supportedValues.put( "informational", Level.INFO);
        supportedValues.put( "information", Level.INFO);
        supportedValues.put( "info", Level.INFO);

        supportedValues.put( "DEBUGGING", Level.DEBUG);
        supportedValues.put( "DEBUG", Level.DEBUG);
        supportedValues.put( "DBG", Level.DEBUG);
        supportedValues.put( "Debugging", Level.DEBUG);
        supportedValues.put( "Debug", Level.DEBUG);
        supportedValues.put( "debugging", Level.DEBUG);
        supportedValues.put( "debug", Level.DEBUG);

        supportedValues.put( "TRACE", Level.TRACE);
        supportedValues.put( "TRC", Level.TRACE);
        supportedValues.put( "trace", Level.TRACE);

        for (Map.Entry<String, Level> entry : supportedValues.entrySet()) {
            assertEquals(entry.getValue(), EventLoggingListenerSupport.toLevel(entry.getKey()));
        }

        String invalidLevel = "FOO";
        try {
            EventLoggingListenerSupport.toLevel(invalidLevel);
            fail("Should throw an exception for an invalid String value");
        } catch (IllegalArgumentException expectedEx) {
            assertThat(expectedEx.getMessage(), startsWith("Supplied String '" + invalidLevel +"' is not in the list of recognized values: "));
        }
    }
}