package com.yan.li.rpn.consts;

import org.junit.Assert;
import org.junit.Test;

/**
 * RPNFunctions unit test
 *
 * @author yan.li
 */
public class RPNFunctionsTest {

    /**
     * test isFunction
     *
     * @throws Exception
     */
    @Test
    public void testIsFunction() throws Exception {
        // True
        Assert.assertTrue(RPNFunctions.isFunction("exit"));
        Assert.assertTrue(RPNFunctions.isFunction("Exit"));
        Assert.assertTrue(RPNFunctions.isFunction("undo"));
        Assert.assertTrue(RPNFunctions.isFunction("Undo"));
        Assert.assertTrue(RPNFunctions.isFunction("Clear"));
        Assert.assertTrue(RPNFunctions.isFunction("Clear"));

        // False
        Assert.assertFalse(RPNFunctions.isFunction("Clear1"));
        Assert.assertFalse(RPNFunctions.isFunction(""));
        Assert.assertFalse(RPNFunctions.isFunction(null));
    }

    /**
     * test isExist
     *
     * @throws Exception
     */
    @Test
    public void testIsExit() throws Exception {
        // True
        Assert.assertTrue(RPNFunctions.isExist("exit"));
        Assert.assertTrue(RPNFunctions.isExist("Exit"));

        // False
        Assert.assertFalse(RPNFunctions.isExist("Clear1"));
        Assert.assertFalse(RPNFunctions.isExist(""));
        Assert.assertFalse(RPNFunctions.isExist(null));
    }

    /**
     * test isUndo
     *
     * @throws Exception
     */
    @Test
    public void testIsUndo() throws Exception {
        // True
        Assert.assertTrue(RPNFunctions.isUndo("undo"));
        Assert.assertTrue(RPNFunctions.isUndo("Undo"));

        // False
        Assert.assertFalse(RPNFunctions.isUndo("Clear1"));
        Assert.assertFalse(RPNFunctions.isUndo(""));
        Assert.assertFalse(RPNFunctions.isUndo(null));
    }

    /**
     * test isClear
     *
     * @throws Exception
     */
    @Test
    public void testIsClear() throws Exception {
        // True
        Assert.assertTrue(RPNFunctions.isClear("clear"));
        Assert.assertTrue(RPNFunctions.isClear("Clear"));

        // False
        Assert.assertFalse(RPNFunctions.isClear("Clear1"));
        Assert.assertFalse(RPNFunctions.isClear(""));
        Assert.assertFalse(RPNFunctions.isClear(null));
    }

}
