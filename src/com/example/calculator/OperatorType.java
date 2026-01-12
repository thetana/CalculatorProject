package com.example.calculator;

public enum OperatorType {
    PLUS('+') {
        public int apply(int n1, int n2) {
            return n1 + n2;
        }
    }, MINUS('-') {
        public int apply(int n1, int n2) {
            return n1 - n2;
        }
    }, MULTIPLY('*') {
        public int apply(int n1, int n2) {
            return n1 * n2;
        }
    }, DIVIDE('/') {
        public int apply(int n1, int n2) {
            return n1 / n2;
        }
    };

    private final char symbol;

    OperatorType(char symbol) {
        this.symbol = symbol;
    }

    public abstract int apply(int n1, int n2);

    public static OperatorType from(char input) {
        return switch (input) {
            case '+' -> PLUS;
            case '-' -> MINUS;
            case '*' -> MULTIPLY;
            case '/' -> DIVIDE;
            default  -> throw new IllegalArgumentException("지원하지 않는 연산자: " + input);
        };
    }

}
