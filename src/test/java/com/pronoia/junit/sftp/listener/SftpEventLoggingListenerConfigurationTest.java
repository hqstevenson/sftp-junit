package com.pronoia.junit.sftp.listener;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.event.Level;

/**
 * Tests for the  class.
 */
public class SftpEventLoggingListenerConfigurationTest {

    SftpEventLoggingListener instance;

    @Before
    public void setUp() throws Exception {
        instance = new SftpEventLoggingListener();
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testConstructors() throws Exception {
        assertEquals(Level.INFO, instance.defaultLevel);
        assertNull("Unexpected initial value", instance.sessionLevel);
        assertNull("Unexpected initial value", instance.createLevel);
        assertNull("Unexpected initial value", instance.openLevel);
        assertNull("Unexpected initial value", instance.readLevel);
        assertNull("Unexpected initial value", instance.writeLevel);
        assertNull("Unexpected initial value", instance.blockLevel);
        assertNull("Unexpected initial value", instance.moveLevel);
        assertNull("Unexpected initial value", instance.linkLevel);
        assertNull("Unexpected initial value", instance.modifyAttributesLevel);

        Level expected = Level.TRACE;

        instance = new SftpEventLoggingListener(expected.toInt());
        assertEquals(expected, instance.defaultLevel);
        assertNull(instance.sessionLevel);
        assertNull(instance.createLevel);
        assertNull(instance.openLevel);
        assertNull(instance.readLevel);
        assertNull(instance.writeLevel);
        assertNull(instance.blockLevel);
        assertNull(instance.moveLevel);
        assertNull(instance.linkLevel);
        assertNull(instance.modifyAttributesLevel);

        instance = new SftpEventLoggingListener(expected.toString());
        assertEquals(expected, instance.defaultLevel);
        assertNull(instance.sessionLevel);
        assertNull(instance.createLevel);
        assertNull(instance.openLevel);
        assertNull(instance.readLevel);
        assertNull(instance.writeLevel);
        assertNull(instance.blockLevel);
        assertNull(instance.moveLevel);
        assertNull(instance.linkLevel);
        assertNull(instance.modifyAttributesLevel);

        instance = new SftpEventLoggingListener(expected);
        assertEquals(expected, instance.defaultLevel);
        assertNull(instance.sessionLevel);
        assertNull(instance.createLevel);
        assertNull(instance.openLevel);
        assertNull(instance.readLevel);
        assertNull(instance.writeLevel);
        assertNull(instance.blockLevel);
        assertNull(instance.moveLevel);
        assertNull(instance.linkLevel);
        assertNull(instance.modifyAttributesLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testGetSessionLeve() throws Exception {
        assertNull("Unexpected initial value", instance.getSessionLevel());

        Level expected = Level.TRACE;
        instance.sessionLevel = expected;
        assertEquals(expected, instance.getSessionLevel());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetSessionLevelWithInt() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.sessionLevel);

        instance.setSessionLevel(expected.toInt());

        assertEquals(expected, instance.sessionLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetSessionLevelWithString() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.sessionLevel);

        instance.setSessionLevel(expected.toString());

        assertEquals(expected, instance.sessionLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetSessionLevel() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.sessionLevel);

        instance.setSessionLevel(expected);

        assertEquals(expected, instance.sessionLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testGetCreateLeve() throws Exception {
        assertNull("Unexpected initial value", instance.getCreateLevel());

        Level expected = Level.TRACE;
        instance.createLevel = expected;
        assertEquals(expected, instance.getCreateLevel());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetCreateLevelWithInt() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.createLevel);

        instance.setCreateLevel(expected.toInt());

        assertEquals(expected, instance.createLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetCreateLevelWithString() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.createLevel);

        instance.setCreateLevel(expected.toString());

        assertEquals(expected, instance.createLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetCreateLevel() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.createLevel);

        instance.setCreateLevel(expected);

        assertEquals(expected, instance.createLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testGetOpenLevel() throws Exception {
        assertNull("Unexpected initial value", instance.getOpenLevel());

        Level expected = Level.TRACE;
        instance.openLevel = expected;
        assertEquals(expected, instance.getOpenLevel());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetOpenLevelWithInt() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.openLevel);

        instance.setOpenLevel(expected.toInt());

        assertEquals(expected, instance.openLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetOpenLevelWithString() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.openLevel);

        instance.setOpenLevel(expected.toString());

        assertEquals(expected, instance.openLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetOpenLevel() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.openLevel);

        instance.setOpenLevel(expected);

        assertEquals(expected, instance.openLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testGetReadLevel() throws Exception {
        assertNull("Unexpected initial value", instance.getReadLevel());

        Level expected = Level.TRACE;
        instance.readLevel = expected;
        assertEquals(expected, instance.getReadLevel());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetReadLevelWithInt() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.readLevel);

        instance.setReadLevel(expected.toInt());

        assertEquals(expected, instance.readLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetReadLevelWithString() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.readLevel);

        instance.setReadLevel(expected.toString());

        assertEquals(expected, instance.readLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetReadLevel() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.readLevel);

        instance.setReadLevel(expected);

        assertEquals(expected, instance.readLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testGetWriteLevel() throws Exception {
        assertNull("Unexpected initial value", instance.getWriteLevel());

        Level expected = Level.TRACE;
        instance.writeLevel = expected;
        assertEquals(expected, instance.getWriteLevel());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetWriteLevelWithInt() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.writeLevel);

        instance.setWriteLevel(expected.toInt());

        assertEquals(expected, instance.writeLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetWriteLevelWithString() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.writeLevel);

        instance.setWriteLevel(expected.toString());

        assertEquals(expected, instance.writeLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetWriteLevel() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.writeLevel);

        instance.setWriteLevel(expected);

        assertEquals(expected, instance.writeLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testGetBlockLevel() throws Exception {
        assertNull("Unexpected initial value", instance.getBlockLevel());

        Level expected = Level.TRACE;
        instance.blockLevel = expected;
        assertEquals(expected, instance.getBlockLevel());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetBlockLevelWithInt() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.blockLevel);

        instance.setBlockLevel(expected.toInt());

        assertEquals(expected, instance.blockLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetBlockLevelWithString() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.blockLevel);

        instance.setBlockLevel(expected.toString());

        assertEquals(expected, instance.blockLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetBlockLevel() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.blockLevel);

        instance.setBlockLevel(expected);

        assertEquals(expected, instance.blockLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testGetMoveLevel() throws Exception {
        assertNull("Unexpected initial value", instance.getMoveLevel());

        Level expected = Level.TRACE;
        instance.moveLevel = expected;
        assertEquals(expected, instance.getMoveLevel());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetMoveLevelWithInt() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.moveLevel);

        instance.setMoveLevel(expected.toInt());

        assertEquals(expected, instance.moveLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetMoveLevelWithString() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.moveLevel);

        instance.setMoveLevel(expected.toString());

        assertEquals(expected, instance.moveLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetMoveLevel() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.moveLevel);

        instance.setMoveLevel(expected);

        assertEquals(expected, instance.moveLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testGetLinkLevel() throws Exception {
        assertNull("Unexpected initial value", instance.getLinkLevel());

        Level expected = Level.TRACE;
        instance.linkLevel = expected;
        assertEquals(expected, instance.getLinkLevel());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetLinkLevelWithInt() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.linkLevel);

        instance.setLinkLevel(expected.toInt());

        assertEquals(expected, instance.linkLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetLinkLevelWithString() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.linkLevel);

        instance.setLinkLevel(expected.toString());

        assertEquals(expected, instance.linkLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetLinkLevel() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.linkLevel);

        instance.setLinkLevel(expected);

        assertEquals(expected, instance.linkLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testGetModifyAttributesLevel() throws Exception {
        assertNull("Unexpected initial value", instance.getModifyAttributesLevel());

        Level expected = Level.TRACE;
        instance.modifyAttributesLevel = expected;
        assertEquals(expected, instance.getModifyAttributesLevel());
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetModifyAttributesLevelWithInt() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.modifyAttributesLevel);

        instance.setModifyAttributesLevel(expected.toInt());

        assertEquals(expected, instance.modifyAttributesLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetModifyAttributesLevelWithString() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.modifyAttributesLevel);

        instance.setModifyAttributesLevel(expected.toString());

        assertEquals(expected, instance.modifyAttributesLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSetModifyAttributesLevel() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.modifyAttributesLevel);

        instance.setModifyAttributesLevel(expected);

        assertEquals(expected, instance.modifyAttributesLevel);
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
    public void testSessionLevelWithInt() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.sessionLevel);

        assertSame(instance, instance.sessionLevel(expected.toInt()));
        assertEquals(expected, instance.sessionLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSessionLevelWithString() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.sessionLevel);

        assertSame(instance, instance.sessionLevel(expected.toString()));
        assertEquals(expected, instance.sessionLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testSessionLevel() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.sessionLevel);

        assertSame(instance, instance.sessionLevel(expected));
        assertEquals(expected, instance.sessionLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testCreateLevelWithInt() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.createLevel);

        assertSame(instance, instance.createLevel(expected.toInt()));
        assertEquals(expected, instance.createLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testCreateLevelWithString() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.createLevel);

        assertSame(instance, instance.createLevel(expected.toString()));
        assertEquals(expected, instance.createLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testCreateLevel() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.createLevel);

        assertSame(instance, instance.createLevel(expected));
        assertEquals(expected, instance.createLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testOpenLevelWithInt() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.openLevel);

        assertSame(instance, instance.openLevel(expected.toInt()));
        assertEquals(expected, instance.openLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testOpenLevelWithString() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.openLevel);

        assertSame(instance, instance.openLevel(expected.toString()));
        assertEquals(expected, instance.openLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testOpenLevel() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.openLevel);

        assertSame(instance, instance.openLevel(expected));
        assertEquals(expected, instance.openLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testReadLevelWithInt() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.readLevel);

        assertSame(instance, instance.readLevel(expected.toInt()));
        assertEquals(expected, instance.readLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testReadLevelWithString() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.readLevel);

        assertSame(instance, instance.readLevel(expected.toString()));
        assertEquals(expected, instance.readLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testReadLevel() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.readLevel);

        assertSame(instance, instance.readLevel(expected));
        assertEquals(expected, instance.readLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testWriteLevelWithInt() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.writeLevel);

        assertSame(instance, instance.writeLevel(expected.toInt()));
        assertEquals(expected, instance.writeLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testWriteLevelWithString() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.writeLevel);

        assertSame(instance, instance.writeLevel(expected.toString()));
        assertEquals(expected, instance.writeLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testWriteLevel() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.writeLevel);

        assertSame(instance, instance.writeLevel(expected));
        assertEquals(expected, instance.writeLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testBlockLevelWithInt() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.blockLevel);

        assertSame(instance, instance.blockLevel(expected.toInt()));
        assertEquals(expected, instance.blockLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testBlockLevelWithString() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.blockLevel);

        assertSame(instance, instance.blockLevel(expected.toString()));
        assertEquals(expected, instance.blockLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testBlockLevel() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.blockLevel);

        assertSame(instance, instance.blockLevel(expected));
        assertEquals(expected, instance.blockLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testMoveLevelWithInt() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.moveLevel);

        assertSame(instance, instance.moveLevel(expected.toInt()));
        assertEquals(expected, instance.moveLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testMoveLevelWithString() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.moveLevel);

        assertSame(instance, instance.moveLevel(expected.toString()));
        assertEquals(expected, instance.moveLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testMoveLevel() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.moveLevel);

        assertSame(instance, instance.moveLevel(expected));
        assertEquals(expected, instance.moveLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testLinkLevelWithInt() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.linkLevel);

        assertSame(instance, instance.linkLevel(expected.toInt()));
        assertEquals(expected, instance.linkLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testLinkLevelWithString() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.linkLevel);

        assertSame(instance, instance.linkLevel(expected.toString()));
        assertEquals(expected, instance.linkLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testLinkLevel() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.linkLevel);

        assertSame(instance, instance.linkLevel(expected));
        assertEquals(expected, instance.linkLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testModifyAttributesLevelWithInt() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.modifyAttributesLevel);

        assertSame(instance, instance.modifyAttributesLevel(expected.toInt()));
        assertEquals(expected, instance.modifyAttributesLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testModifyAttributesLevelWithString() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.modifyAttributesLevel);

        assertSame(instance, instance.modifyAttributesLevel(expected.toString()));
        assertEquals(expected, instance.modifyAttributesLevel);
    }

    /**
     * Description of test.
     *
     * @throws Exception in the event of a test error.
     */
    @Test
    public void testModifyAttributesLevel() throws Exception {
        Level expected = Level.TRACE;

        assertNotEquals("Initial value cannot be the same as the expected value used for the test", expected, instance.modifyAttributesLevel);

        assertSame(instance, instance.modifyAttributesLevel(expected));
        assertEquals(expected, instance.modifyAttributesLevel);
    }
}