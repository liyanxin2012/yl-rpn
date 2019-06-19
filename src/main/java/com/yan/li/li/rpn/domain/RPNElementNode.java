package com.yan.li.li.rpn.domain;

import java.io.Serializable;

/**
 * Reverse polish notation element node
 *
 * @author yan.li
 */
public class RPNElementNode implements Serializable {

    /**
     * expression
     */
    private String expression;

    /**
     * positon
     */
    private Integer position;

    /**
     * value
     */
    private String value;

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "RPNElementNode{" +
                "expression='" + expression + '\'' +
                ", position=" + position +
                ", value='" + value + '\'' +
                '}';
    }
}
