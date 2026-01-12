package com.example.calculator;

import java.util.function.Function;

public class ArithmeticCalculator<T> {
    Class<?> numberClass;

    public void plus(T n1, T n2) {
    }
    public void minus(T n1, T n2) {
    }
    public void multiply(T n1, T n2) {
    }
    public void divide(T n1, T n2) {
    }

    public void setNumber(T n1, T n2) {
        new ArithmeticCalculator().getClass();
        numberClass = n1.getClass();
        double result;
        // 입력 값이 int가 적합한지 long이 적합한지 판단하기는 하지만 사실 결과 값에서
        if (canParse(n1.toString(), Integer::parseInt) && canParse(n2.toString(), Integer::parseInt)) {
            numberClass = Integer.class;
        } else if (canParse(n1.toString(), Long::parseLong) && canParse(n2.toString(), Long::parseLong)) {
            numberClass = Long.class;
        } else if (canParse(n1.toString(), Double::parseDouble) && canParse(n2.toString(), Double::parseDouble)) {
            numberClass = Double.class;
        }
    }

    public Class<?> getNumberClass() {
        return numberClass;
    }

    public <T> boolean canParse(String input, Function<String, T> parser) {
        try {
            parser.apply(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
