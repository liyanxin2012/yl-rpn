package com.yan.li.rpn.utils;

import com.yan.li.li.rpn.utils.RPNRegexUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * RPNRegexUtils unit test
 *
 * @author yan.li
 */
public class RPNRegexUtilsTest {

    /**
     * test isDigital
     *
     * @throws Exception
     */
    @Test
    public void testIsDigital() throws Exception {
        Assert.assertTrue(RPNRegexUtils.isDigital("2"));
        Assert.assertTrue(RPNRegexUtils.isDigital("2.2"));
        Assert.assertTrue(RPNRegexUtils.isDigital("-2.2"));
        Assert.assertFalse(RPNRegexUtils.isDigital(" "));
        Assert.assertFalse(RPNRegexUtils.isDigital("-A"));
    }
}
