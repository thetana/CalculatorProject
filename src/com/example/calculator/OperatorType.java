package com.example.calculator;

import java.util.function.BiFunction;

public enum OperatorType {
    PLUS ((a,b) -> a + b),
    MINUS ((a,b) -> a - b),
    MULTIPLY ((a,b) -> a * b),
    DIVIDE ((a,b) -> a / b);
    
    private final BiFunction<Integer,Integer,Integer> operation ;

    OperatorType(BiFunction<Integer,Integer,Integer> operation) {
        this.operation = operation;
    }

    public Integer compute(Integer x, Integer y) {
        return operation.apply(x,y);
    }
}
