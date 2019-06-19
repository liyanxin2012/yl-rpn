package com.yan.li.li.rpn.consts;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Reverse polish notation operators const class
 *
 * @author yan.li
 */
public final class RPNOperators {

    /**
     * Operator - add
     */
    public static final String OPER_ADD = "+";

    /**
     * Operator - subtract
     */
    public static final String OPER_SUBTRACT = "-";

    /**
     * Operator - multiply
     */
    public static final String OPER_MULTIPLY = "*";

    /**
     * Operator - divide
     */
    public static final String OPER_DIVIDE = "/";

    /**
     * Operator - sqrt
     */
    public static final String OPER_SQRT = "sqrt";

    /**
     * Operator mapping digital number
     */
    private static final Map<String, Integer> OPERATOR_2_DIGITAL_NUMBERS = new HashMap<String, Integer>();

    static {
        // OPERATOR_2_DIGITAL_NUMBERS
        OPERATOR_2_DIGITAL_NUMBERS.put(OPER_ADD, 2);
        OPERATOR_2_DIGITAL_NUMBERS.put(OPER_SUBTRACT, 2);
        OPERATOR_2_DIGITAL_NUMBERS.put(OPER_MULTIPLY, 2);
        OPERATOR_2_DIGITAL_NUMBERS.put(OPER_DIVIDE, 2);
        OPERATOR_2_DIGITAL_NUMBERS.put(OPER_SQRT, 1);
    }

    /**
     * Convert operator
     *
     * @param operator
     * @return
     */
    private static String convertOperator(String operator) {
        return operator == null ? null : operator.trim().toLowerCase();
    }

    /**
     * Get digital number
     *
     * @param operator
     * @return
     */
    private static Integer getDigitalNumber(String operator) {
        return OPERATOR_2_DIGITAL_NUMBERS.get(convertOperator(operator));
    }

    /**
     * Determines if the operator is valid
     *
     * @param operator
     * @return
     */
    public static boolean isOperator(String operator) {
        return operator == null ? false : OPERATOR_2_DIGITAL_NUMBERS.containsKey(convertOperator(operator));
    }

    /**
     * Determine whether the number of digital meets the operation needs
     *
     * @param digitalStack
     * @param operator
     * @return
     */
    public static boolean isMeetOperator(Stack<BigDecimal> digitalStack, String operator) {
        // Check operator valid
        if (isOperator(operator) == false) {
            return false;
        }

        // Check digital number
        if (getDigitalNumber(operator) > digitalStack.size()) {
            return false;
        }

        // Check sqrt digital
        if (OPER_SQRT.equals(convertOperator(operator)) && digitalStack.peek().compareTo(BigDecimal.ZERO) < 0) {
            return false;
        }

        // Check divide digital
        if (OPER_DIVIDE.equals(convertOperator(operator)) && digitalStack.peek().compareTo(BigDecimal.ZERO) == 0) {
            return false;
        }

        return true;
    }


    private RPNOperators() {

    }
}
