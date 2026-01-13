package com.example.calculator;

import java.util.function.BiFunction;
import java.util.function.DoubleBinaryOperator;

public enum OperatorType {
    PLUS ('+') ,
    MINUS ('-') ,
    MULTIPLY ('*') ,
    DIVIDE ('/');
//    MINUS ((a,b) -> a - b),
//    MULTIPLY ((a,b) -> a * b),
//    DIVIDE ((a,b) -> a / b);

    private BiFunction<Integer,Integer,Integer> operation ;

    private char symbol ;

    OperatorType(char symbol) {
        this.symbol = symbol;
    }

    public static OperatorType from(char c) {
        for (OperatorType type : values()) {
            if (type.symbol == c) {
                return type;
            }
        }
        throw new IllegalArgumentException("지원하지 않는 문자: " + c);
    }
}