package com.yan.li.rpn.utils;

import org.junit.Assert;
import org.junit.Test;

/**
 * RPNParserUtils unit test
 *
 * @author yan.li
 */
public class RPNParserUtilsTest {

    /**
     * test parseInputParams
     *
     * @throws Exception
     */
    @Test
    public void testParseInputParams() throws Exception {
        Assert.assertEquals("[RPNElementNode{expression='1 2 3', position=0, value='1'}, RPNElementNode{expression='1 2 3', position=2, value='2'}, RPNElementNode{expression='1 2 3', position=4, value='3'}]", RPNParserUtils.parseInputParams("1 2 3").toString());
        Assert.assertEquals("[RPNElementNode{expression='1 2  3', position=0, value='1'}, RPNElementNode{expression='1 2  3', position=2, value='2'}, RPNElementNode{expression='1 2  3', position=4, value=''}, RPNElementNode{expression='1 2  3', position=5, value='3'}]",RPNParserUtils.parseInputParams("1 2  3").toString());
    }
}
