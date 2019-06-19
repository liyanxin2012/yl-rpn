package com.yan.li.rpn.utils;


import com.yan.li.rpn.domain.RPNElementNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Reverse polish notation parser utils
 *
 * @author yan.li
 */
public final class RPNParserUtils {

    /**
     * Separator - Space
     */
    public static final String SPACE = " ";

    /**
     * Parse input params
     *
     * @param inputParams
     * @return
     */
    public static List<RPNElementNode> parseInputParams(String inputParams) {
        if (inputParams == null || inputParams.trim() == "") {
            return null;
        }

        List<RPNElementNode> nodeList = new ArrayList<RPNElementNode>();
        String[] params = inputParams.trim().split(SPACE);
        int position = 0;
        for (String param : params) {
            RPNElementNode node = new RPNElementNode();
            node.setValue(param);
            node.setPosition(position);
            node.setExpression(inputParams);

            nodeList.add(node);

            position += param.length() + SPACE.length();
        }

        return nodeList;
    }

    private RPNParserUtils() {

    }
}
