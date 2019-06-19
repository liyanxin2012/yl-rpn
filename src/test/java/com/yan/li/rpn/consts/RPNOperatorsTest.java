package com.yan.li.rpn.consts;

import com.yan.li.li.rpn.consts.RPNOperators;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * RPNOperators unit test
 *
 * @author yan.li
 */
public class RPNOperatorsTest {

    /**
     * test isOperator
     *
     * @throws Exception
     */
    @Test
    public void testIsOperator() throws Exception {
        // True
        Assert.assertTrue(RPNOperators.isOperator("+"));
        Assert.assertTrue(RPNOperators.isOperator("-"));
        Assert.assertTrue(RPNOperators.isOperator("*"));
        Assert.assertTrue(RPNOperators.isOperator("/"));
        Assert.assertTrue(RPNOperators.isOperator("sqrt"));
        Assert.assertTrue(RPNOperators.isOperator("Sqrt"));

        // False
        Assert.assertFalse(RPNOperators.isOperator("Clear1"));
        Assert.assertFalse(RPNOperators.isOperator(""));
        Assert.assertFalse(RPNOperators.isOperator(null));
    }

    /**
     * test isMeetOperator
     *
     * @throws Exception
     */
    @Test
    public void testIsMeetOperator() throws Exception {
        Stack<BigDecimal> digitalStack = new Stack<BigDecimal>();
        digitalStack.push(new BigDecimal("1"));
        digitalStack.push(new BigDecimal("2"));

        // True
        Assert.assertTrue(RPNOperators.isMeetOperator(digitalStack, "+"));
        Assert.assertTrue(RPNOperators.isMeetOperator(digitalStack, "-"));
        Assert.assertTrue(RPNOperators.isMeetOperator(digitalStack, "*"));
        Assert.assertTrue(RPNOperators.isMeetOperator(digitalStack, "/"));
        Assert.assertTrue(RPNOperators.isMeetOperator(digitalStack,"sqrt"));

        digitalStack.clear();
        digitalStack.push(new BigDecimal("-1"));

        // False
        Assert.assertFalse(RPNOperators.isMeetOperator(digitalStack, "sqrt")); // This digital can't be negative
        Assert.assertFalse(RPNOperators.isMeetOperator(digitalStack, "1")); // The operator is invalid
        Assert.assertFalse(RPNOperators.isMeetOperator(digitalStack, "+")); // This operation must have two digital


        digitalStack.push(new BigDecimal("0"));
        Assert.assertFalse(RPNOperators.isMeetOperator(digitalStack, "/")); // The dividend can't be zero
    }
}
