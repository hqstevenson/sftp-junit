package com.pronoia.junit.sftp.listener;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.slf4j.Logger;
import org.slf4j.event.Level;

/**
 * Tests for the  class.
 */
public class EventLoggingListenerSupportTest {

    EventLoggingListenerSupport instance;

    @Before
    public void setUp() throws Exception {
        instance = new EventLoggingListenerSupport();
        instance.log = mock(Logger.class);
    }

    @After
    public void tearDown() throws Exception {
        verifyNoMoreInteractions(instance.log);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testDoLogAtErrorLevelWithInt() throws Exception {
        instance.doLog(Level.ERROR.toInt(), "test", "blah", "blah");
        verify(instance.log, times(1)).error("test", new Object[]{"blah", "blah"});
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testDoLogAtWarningLevelWithInt() throws Exception {
        instance.doLog(Level.WARN.toInt(), "test", "blah", "blah");
        verify(instance.log, times(1)).warn("test", new Object[]{"blah", "blah"});
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testDoLogAtInfoLevelWithInt() throws Exception {
        instance.doLog(Level.INFO.toInt(), "test", "blah", "blah");
        verify(instance.log, times(1)).info("test", new Object[]{"blah", "blah"});
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testDoLogAtDebugLevelWithInt() throws Exception {
        instance.doLog(Level.DEBUG.toInt(), "test", "blah", "blah");
        verify(instance.log, times(1)).debug("test", new Object[]{"blah", "blah"});
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testDoLogAtTraceLevelWithInt() throws Exception {
        instance.doLog(Level.TRACE.toInt(), "test", "blah", "blah");
        verify(instance.log, times(1)).trace("test", new Object[]{"blah", "blah"});
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testDoLogAtErrorLevelWithString() throws Exception {
        instance.doLog(Level.ERROR.toString(), "test", "blah", "blah");
        verify(instance.log, times(1)).error("test", new Object[]{"blah", "blah"});
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testDoLogAtWarningLevelWithString() throws Exception {
        instance.doLog(Level.WARN.toString(), "test", "blah", "blah");
        verify(instance.log, times(1)).warn("test", new Object[]{"blah", "blah"});
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testDoLogAtInfoLevelWithString() throws Exception {
        instance.doLog(Level.INFO.toString(), "test", "blah", "blah");
        verify(instance.log, times(1)).info("test", new Object[]{"blah", "blah"});
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testDoLogAtDebugLevelWithString() throws Exception {
        instance.doLog(Level.DEBUG.toString(), "test", "blah", "blah");
        verify(instance.log, times(1)).debug("test", new Object[]{"blah", "blah"});
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testDoLogAtTraceLevelWithString() throws Exception {
        instance.doLog(Level.TRACE.toString(), "test", "blah", "blah");
        verify(instance.log, times(1)).trace("test", new Object[]{"blah", "blah"});
    }
    
    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testDoLogAtErrorLevel() throws Exception {
        instance.doLog(Level.ERROR, "test", "blah", "blah");
        verify(instance.log, times(1)).error("test", new Object[]{"blah", "blah"});
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testDoLogAtWarningLevel() throws Exception {
        instance.doLog(Level.WARN, "test", "blah", "blah");
        verify(instance.log, times(1)).warn("test", new Object[]{"blah", "blah"});
    }
    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testDoLogAtInfoLevel() throws Exception {
        instance.doLog(Level.INFO, "test", "blah", "blah");
        verify(instance.log, times(1)).info("test", new Object[]{"blah", "blah"});
    }
    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testDoLogAtDebugLevel() throws Exception {
        instance.doLog(Level.DEBUG, "test", "blah", "blah");
        verify(instance.log, times(1)).debug("test", new Object[]{"blah", "blah"});
    }
    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testDoLogAtTraceLevel() throws Exception {
        instance.doLog(Level.TRACE, "test", "blah", "blah");
        verify(instance.log, times(1)).trace("test", new Object[]{"blah", "blah"});
    }

}