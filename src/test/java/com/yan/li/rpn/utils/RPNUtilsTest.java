package com.yan.li.rpn.utils;

import com.yan.li.li.rpn.utils.RPNUtils;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * RPNUtils unit test
 *
 * @author yan.li
 */
public class RPNUtilsTest {

    /**
     * test strToBig
     *
     * @throws Exception
     */
    @Test
    public void testStrToBig() throws Exception {
        // Equal
        Assert.assertEquals(new BigDecimal("2"), RPNUtils.strToBig("2"));
        Assert.assertEquals(new BigDecimal("2"), RPNUtils.strToBig("2.00"));
        Assert.assertEquals(new BigDecimal("0.123456789012346"), RPNUtils.strToBig("0.123456789012345678"));

        // Not equal
        Assert.assertNotEquals(new BigDecimal("0.123456789012345678"), RPNUtils.strToBig("0.123456789012345678"));
    }

    /**
     * test strToBig
     *
     * @throws Exception
     */
    @Test
    public void testSqrt() throws Exception {
        // Equal
        Assert.assertEquals(new BigDecimal("2"), RPNUtils.sqrt(new BigDecimal("4")));
        Assert.assertEquals(new BigDecimal("1.414213562373095"), RPNUtils.sqrt(new BigDecimal("2")));
    }

    /**
     * test isValidInputParams
     *
     * @throws Exception
     */
    @Test
    public void testIsValidInputParams() throws Exception {
        // True
        Assert.assertTrue(RPNUtils.isValidInputParams("1 2 3 * undo clear"));

        // False
        Assert.assertFalse(RPNUtils.isValidInputParams("clears"));
    }

    /**
     * test formatCalcBig
     *
     * @throws Exception
     */
    @Test
    public void testFormatCalcBig() throws Exception {
        System.out.println(RPNUtils.formatCalcBig(new BigDecimal("21")));
    }

}
