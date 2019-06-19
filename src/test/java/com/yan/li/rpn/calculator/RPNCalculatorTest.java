package com.yan.li.rpn.calculator;

import org.junit.Test;

/**
 * RPNCalculator unit test
 *
 * @author yan.li
 */
public class RPNCalculatorTest {

    /**
     * test calculate example 1
     *
     * <pre>
     * Example 1
     * 52
     * stack: 5 2
     *
     * @throws Exception
     */
    @Test
    public void testCalculateExample1() throws Exception {
        new RPNCalculator().calculate("5 2");
    }

    /**
     * test calculate example 2
     *
     * <pre>
     * Example 2
     * 2 sqrt
     * stack: 1.4142135623 clear 9 sqrt
     * stack: 3
     *
     * @throws Exception
     */
    @Test
    public void testCalculateExample2() throws Exception {
        RPNCalculator calculator = new RPNCalculator();

        // 2 qart
        calculator.calculate("2 sqrt");

        // clear 9 sqrt
        calculator.calculate("clear 9 sqrt");
    }

    /**
     * test calculate example 3
     *
     * <pre>
     * Example 3
     * 5 2 -
     * stack: 3
     * 3 -
     * stack: 0
     * clear
     * stack:
     *
     * @throws Exception
     */
    @Test
    public void testCalculateExample3() throws Exception {
        RPNCalculator calculator = new RPNCalculator();

        // 5 2 -
        calculator.calculate("5 2 -");

        // 3 -
        calculator.calculate("3 -");

        // clear
        calculator.calculate("clear");
    }

    /**
     * test calculate example 4
     *
     * <pre>
     * Example 4
     * 5 4 3 2
     * stack: 5 4 3 2
     * undo undo *
     * stack: 20
     * 5 *
     * stack: 100
     * undo
     * stack: 20 5
     *
     * @throws Exception
     */
    @Test
    public void testCalculateExample4() throws Exception {
        RPNCalculator calculator = new RPNCalculator();

        // 5 4 3 2
        calculator.calculate("5 4 3 2");

        // undo undo *
        calculator.calculate("undo undo *");

        // 5 *
        calculator.calculate("5 *");

        // undo
        calculator.calculate("undo");
    }

    /**
     * test calculate example 5
     *
     * <pre>
     * Example 5
     * 7 12 2 /
     * stack: 7 6
     * *
     * stack: 42
     * 4 /
     * stack: 10.5
     *
     * @throws Exception
     */
    @Test
    public void testCalculateExample5() throws Exception {
        RPNCalculator calculator = new RPNCalculator();

        // 7 12 2 /
        calculator.calculate("7 12 2 /");

        // *
        calculator.calculate("*");

        // 4 /
        calculator.calculate("4 /");
    }

    /**
     * test calculate example 6
     *
     * <pre>
     * Example 6
     * 1 2 3 4 5
     * stack: 1 2 3 4 5
     * *
     * stack: 1 2 3 20
     * clear 3 4 -
     * stack: - 1
     *
     * @throws Exception
     */
    @Test
    public void testCalculateExample6() throws Exception {
        RPNCalculator calculator = new RPNCalculator();

        // 1 2 3 4 5
        calculator.calculate("1 2 3 4 5");

        // *
        calculator.calculate("*");

        // clear 3 4 -
        calculator.calculate("clear 3 4 -");
    }

    /**
     * test calculate example 7
     *
     * <pre>
     * Example 7
     * 1 2 3 4 5
     * stack: 1 2 3 4 5
     * * * * *
     * stack: 120
     *
     * @throws Exception
     */
    @Test
    public void testCalculateExample7() throws Exception {
        RPNCalculator calculator = new RPNCalculator();

        // 1 2 3 4 5
        calculator.calculate("1 2 3 4 5");

        // * * * *
        calculator.calculate("* * * *");
    }

    /**
     * test calculate example 8
     *
     * <pre>
     * Example 8
     * 12 3* 5+ * * 6 5
     * operator * (position: 15): insucient parameters stack: 11
     * (the 6 and 5 were not pushed on to the stack due to the previous error)
     *
     * @throws Exception
     */
    @Test
    public void testCalculateExample8() throws Exception {
        RPNCalculator calculator = new RPNCalculator();

        // 1 2 3 4 5
        calculator.calculate("1 2 3 * 5 + * * 6 5");
    }
}
