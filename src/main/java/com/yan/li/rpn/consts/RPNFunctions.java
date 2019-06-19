package com.yan.li.rpn.consts;

import java.util.ArrayList;
import java.util.List;

/**
 * Reverse polish notation function const class
 *
 * @author yan.li
 */
public final class RPNFunctions {

    /**
     * Function - exit
     */
    public static final String EXIT = "exit";

    /**
     * Function - undo
     */
    public static final String UNDO = "undo";

    /**
     * Function - clear
     */
    public static final String CLEAR = "clear";

    /**
     * Full functions
     */
    private static final List<String> FUNCTIONS = new ArrayList<String>();

    static {
        // functions
        FUNCTIONS.add(UNDO);
        FUNCTIONS.add(CLEAR);
        FUNCTIONS.add(EXIT);
    }

    /**
     * Determines if the function is valid
     *
     * @param function
     * @return
     */
    public static boolean isFunction(String function) {
        return function == null ? false : FUNCTIONS.contains(function.trim().toLowerCase());
    }

    /**
     * Determines if the function is exit
     *
     * @param function
     * @return
     */
    public static boolean isExist(String function) {
        return function == null ? false : EXIT.equalsIgnoreCase(function);
    }

    /**
     * Determines if the function is undo
     *
     * @param function
     * @return
     */
    public static boolean isUndo(String function) {
        return function == null ? false : UNDO.equalsIgnoreCase(function);
    }

    /**
     * Determines if the function is clear
     *
     * @param function
     * @return
     */
    public static boolean isClear(String function) {
        return function == null ? false : CLEAR.equalsIgnoreCase(function);
    }

    private RPNFunctions() {

    }
}
