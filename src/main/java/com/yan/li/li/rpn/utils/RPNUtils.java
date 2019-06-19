package com.yan.li.li.rpn.utils;


import com.yan.li.li.rpn.consts.RPNFunctions;
import com.yan.li.li.rpn.consts.RPNOperators;
import com.yan.li.li.rpn.domain.RPNElementNode;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * Reverse polish notation utils
 *
 * @author yan.li
 */
public final class RPNUtils {

    /**
     * default calculate precision
     */
    public static final Integer CLAC_PRECISION = 15;

    /**
     * default show precision
     */
    public static final Integer SHOW_PRECISION = 10;

    /**
     * String converts to bigdecimal
     *
     * @param val
     * @return
     */
    public static BigDecimal strToBig(String val) {
        return formatCalcBig(new BigDecimal(val.trim()));
    }

    /**
     * sqrt the amt
     *
     * @param amt
     * @return
     */
    public static BigDecimal sqrt(BigDecimal amt) {
        return formatCalcBig(new BigDecimal(Math.sqrt(amt.doubleValue())));
    }

    /**
     * format the bigDecimal
     *
     * @param amt
     * @return
     */
    public static BigDecimal formatCalcBig(BigDecimal amt) {
        return amt.setScale(CLAC_PRECISION, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
    }

    /**
     * format the bigDecimal
     *
     * @param amt
     * @return
     */
    public static BigDecimal formatShowBig(BigDecimal amt) {
        return amt.setScale(SHOW_PRECISION, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
    }

    /**
     * Determines if the param is valid
     *
     * @param param
     * @return
     */
    private static boolean isValidParam(String param) {
        return RPNRegexUtils.isDigital(param) || RPNOperators.isOperator(param) || RPNFunctions.isFunction(param);
    }

    /**
     * Determines if the input params is valid
     *
     * @param inputParams
     * @return
     */
    public static boolean isValidInputParams(String inputParams) {
        if (inputParams == null || inputParams.trim() == "") {
            return false;
        }

        for (RPNElementNode node : RPNParserUtils.parseInputParams(inputParams)) {
            if (isValidParam(node.getValue()) == false) {
                return false;
            }
        }

        return true;
    }

    /**
     * Print digital stack
     *
     * @param digitalStack
     * @return
     */
    public static String printDigitalStack(Stack<BigDecimal> digitalStack) {
        if (digitalStack.empty()) {
            return "";
        }

        StringBuffer sb = new StringBuffer();
        for (BigDecimal element : digitalStack) {
            sb.append(formatShowBig(element).toPlainString());
            sb.append(" ");
        }

        return sb.toString().trim();
    }

    private RPNUtils() {

    }
}
