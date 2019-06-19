package com.yan.li.rpn.calculator;

import com.yan.li.rpn.consts.RPNFunctions;
import com.yan.li.rpn.consts.RPNOperators;
import com.yan.li.rpn.domain.RPNElementNode;
import com.yan.li.rpn.utils.RPNLogsUtils;
import com.yan.li.rpn.utils.RPNParserUtils;
import com.yan.li.rpn.utils.RPNRegexUtils;
import com.yan.li.rpn.utils.RPNUtils;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.Stack;

/**
 * Inverse polish expression calculator
 *
 * @author yan.li
 */
public class RPNCalculator {

    /**
     * The history operation logs
     */
    private StringBuffer historyOperationLogs = new StringBuffer();

    /**
     * Digital stack
     */
    private volatile Stack<BigDecimal> digitalStack = new Stack<BigDecimal>();

    /**
     * History digital stack
     */
    private volatile Stack<Stack<BigDecimal>> historyDigitalStack = new Stack<Stack<BigDecimal>>();

    /**
     * Inverse polish expression calculation
     *
     * @param rpnInputParams
     * @return
     */
    public void calculate(String rpnInputParams) {
        // Record operation log
        RPNLogsUtils.appendOperLogs(historyOperationLogs, rpnInputParams);

        // Parse rpn input params
        for (RPNElementNode node : RPNParserUtils.parseInputParams(rpnInputParams)) {
            // If param is function
            if (RPNFunctions.isFunction(node.getValue())) {
                // Undo function
                if (RPNFunctions.isUndo(node.getValue())) {
                    Stack<BigDecimal> lastDigitalStack = historyDigitalStack.pop();
                    if (lastDigitalStack != null) {
                        digitalStack = lastDigitalStack;
                    } else {
                        System.out.println(String.format("Ignore the operator,operator=%s", node.getValue()));

                    }
                }

                // Clear function
                if (RPNFunctions.isClear(node.getValue())) {
                    digitalStack.clear();
                }

                continue;
            }

            // Record the history digital stack
            historyDigitalStack.push((Stack<BigDecimal>) digitalStack.clone());

            // Store digital to the digital stack
            if (RPNRegexUtils.isDigital(node.getValue())) {
                digitalStack.push(RPNUtils.strToBig(node.getValue()));
                continue;
            }

            // Check the digital stack
            if (RPNOperators.isMeetOperator(digitalStack, node.getValue()) == false) {
                System.out.println(String.format("operator %s (position: %s): insufficient parameters", node.getValue(), node.getPosition()));
                break;
            }

            // Start calculate
            BigDecimal calcResult = BigDecimal.ZERO;
            BigDecimal firstDigital = digitalStack.pop();
            switch (node.getValue().trim()) {
                case RPNOperators.OPER_SQRT:
                    calcResult = RPNUtils.sqrt(firstDigital);
                    break;
                case RPNOperators.OPER_ADD:
                    calcResult = digitalStack.pop().add(firstDigital);
                    break;
                case RPNOperators.OPER_SUBTRACT:
                    calcResult = digitalStack.pop().subtract(firstDigital);
                    break;
                case RPNOperators.OPER_MULTIPLY:
                    calcResult = digitalStack.pop().multiply(firstDigital);
                    break;
                case RPNOperators.OPER_DIVIDE:
                    calcResult = digitalStack.pop().divide(firstDigital);
                    break;
            }

            // Push the calculate result to digital stack
            digitalStack.push(RPNUtils.formatCalcBig(calcResult));
        }

        System.out.println("stack:" + RPNUtils.printDigitalStack(digitalStack));
        // System.out.println("History operation log:" + historyOperationLogs.toString());
        // System.out.println("History digital stack:" + historyDigitalStack.toString());
    }

    /**
     * The calculator has a stack that can contain real numbers.
     * • The calculator waits for user input and expects to receive strings containing whitespace separated lists of numbers and operators.
     * • Numbers are pushed on to the stack. Operators operate on numbers that are on the stack. • Available operators are +, -, *, /, sqrt, undo, clear.
     * • Operators pop their parameters off the stack, and push their results back onto the stack.
     * • The ‘clear’ operator removes all items from the stack.
     * • The ‘undo’ operator undoes the previous operation. “undo undo” will undo the previo us two operations. • sqrt performs a square root on the top item from the stack.
     * • The ‘+’, ‘-’, ‘*’, ‘/’ operators perform addition, subtraction, multiplication and division respectively on the top two items from the stack.
     * • After processing an input string, the calculator displays the current contents of the stack as a space-separated list.
     * • Numbers should be stored on the stack to at least 15 decimal places of precision, but displayed to 10 decimal places (or less if it causes no loss of precision).
     * • All numbers should be formatted as plain decimal strings (ie. no engineering formatting).
     * • If an operator cannot find a sufficient number of parameters on the stack, a warning is displayed:operator <operator> (position: <pos>): insufficient parameters
     * • After displaying the warning, all further processing of the string terminates and the current state of the stack is displayed.
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        RPNCalculator rpn = new RPNCalculator();

        System.out.println("Please input rpn params:");
        while (true) {
            String inputParams = s.nextLine();
            // Exit
            if (RPNFunctions.isExist(inputParams)) {
                break;
            }

            // Validate input params
            if (RPNUtils.isValidInputParams(inputParams)) {
                rpn.calculate(inputParams);
            } else {
                System.out.println(String.format("Ignore invalid input params,inputParams=%s", inputParams));
            }
        }

        System.out.println("Exit the application!");
    }

}
