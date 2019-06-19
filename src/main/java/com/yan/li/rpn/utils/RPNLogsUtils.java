package com.yan.li.rpn.utils;


/**
 * Reverse polish notation logs utils
 *
 * @author yan.li
 */
public final class RPNLogsUtils {
    /**
     * Separator - Space
     */
    public static final String SPACE = " ";

    /**
     * append operation log
     *
     * @param operLogs
     * @param line
     */
    public static void appendOperLogs(StringBuffer operLogs, String line) {
        operLogs.append(line).append(SPACE);
    }

    private RPNLogsUtils() {

    }
}
