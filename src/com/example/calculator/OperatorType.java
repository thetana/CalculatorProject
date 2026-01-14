package com.example.calculator;

import java.math.BigDecimal;
import java.util.function.BiFunction;

public enum OperatorType {
    PLUS((a, b) -> a.add(b)),
    MINUS((a, b) -> a.subtract(b)),
    MULTIPLY((a, b) -> a.multiply(b)),
    DIVIDE((a, b) -> a.divide(b));

    private final BiFunction<BigDecimal, BigDecimal, BigDecimal> operation;

    OperatorType(BiFunction<BigDecimal, BigDecimal, BigDecimal> operation) {
        this.operation = operation;
    }

    public BigDecimal cal(BigDecimal x, BigDecimal y) {
        return operation.apply(x, y);
    }
}