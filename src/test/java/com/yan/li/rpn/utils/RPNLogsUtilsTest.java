package com.yan.li.rpn.utils;

import com.yan.li.li.rpn.utils.RPNLogsUtils;
import org.junit.Test;
import org.testng.Assert;

/**
 * RPNLogsUtils unit test
 *
 * @author yan.li
 */
public class RPNLogsUtilsTest {

    /**
     * test appendOperLogs
     *
     * @throws Exception
     */
    @Test
    public void testAppendOperLogs() throws Exception {
        StringBuffer operLogs = new StringBuffer();

        RPNLogsUtils.appendOperLogs(operLogs,"1 2");
        RPNLogsUtils.appendOperLogs(operLogs,"3 4");

        Assert.assertEquals("1 2 3 4 ",operLogs.toString());
    }
}
