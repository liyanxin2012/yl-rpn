package com.yan.li.li.rpn.utils;


import java.util.regex.Pattern;

/**
 * Reverse polish notation regex utils
 *
 * @author yan.li
 */
public final class RPNRegexUtils {

    /**
     * digital pattern
     */
    private final static Pattern DIGITAL_PATTERN = Pattern.compile("^(-?\\d+)(\\.\\d+)?$");

    /**
     * Determines if the digital is valid
     *
     * @param digital
     * @return
     */
    public static boolean isDigital(String digital) {
        return DIGITAL_PATTERN.matcher(digital.trim()).matches();
    }

    private RPNRegexUtils() {

    }
}
