package com.example.calculator;

import java.util.Objects;
import java.util.function.Function;

public abstract class ArithmeticCalculator<T> {


    public abstract void test (T n1, T n2);

    public boolean calculate(T n1, T n2, char o) {
        boolean isOk = false;
        int result = 0;
        double result2 = 0;

        try {
            OperatorType operatorType = OperatorType.from(o);
//            switch (operatorType) {
//                case PLUS -> result2 = test.plus(n1, n2);
//                case MINUS -> result2 = test.minus(n1, n2);
//                case MULTIPLY -> result2 = test.multiply(n1, n2);
//                case DIVIDE -> result2 = test.divide(n1, n2);
//                default -> throw new IllegalArgumentException();
//            }
            System.out.println(result2);
            isOk = true;
        } catch (IllegalArgumentException e) {// 지원하지 않는 연산자 썼을 때
            isOk = false;
            System.out.println("연산 할 수 없는 기호 입니다.");
        } catch (ArithmeticException e) {// 우선 0나누기만 추가 향후 몇가지 예외처리 추가
            isOk = false;
            System.out.println("0으로 나눌 수 없습니다.");
        } catch (Exception e) {
            System.out.println("예상치 못한 에러 입니다.");
        }


//        archives.addCalculationHistory(Integer.parseInt(n1), Integer.parseInt(n2), o, result, isOk);
        return isOk;
    }


    // 제네릭 한 값을 받아와서 적절한 형으로 변형하여 계산하고 더블로 반환한다
    public double plus(T n1, T n2) {
        double result = 0.0;
        // 입력 값이 int가 적합한지 long이 적합한지 판단하기는 하지만 사실 결과 값에서
        if (canParse(n1.toString(), Integer::parseInt) && canParse(n2.toString(), Integer::parseInt)) {
            result = Integer.parseInt(n1.toString()) + Integer.parseInt(n2.toString());
        } else if (canParse(n1.toString(), Long::parseLong) && canParse(n2.toString(), Long::parseLong)) {
            result = Long.parseLong(n1.toString()) + Long.parseLong(n2.toString());
        } else if (canParse(n1.toString(), Double::parseDouble) && canParse(n2.toString(), Double::parseDouble)) {
            result = Double.parseDouble(n1.toString()) + Double.parseDouble(n2.toString());
        } else {
            throw new IllegalArgumentException();
        }
        return result;
    }

    public double minus(T n1, T n2) {
        double result = 0.0;
        // 입력 값이 int가 적합한지 long이 적합한지 판단하기는 하지만 사실 결과 값에서
        if (canParse(n1.toString(), Integer::parseInt) && canParse(n2.toString(), Integer::parseInt)) {
            result = Integer.parseInt(n1.toString()) - Integer.parseInt(n2.toString());
        } else if (canParse(n1.toString(), Long::parseLong) && canParse(n2.toString(), Long::parseLong)) {
            result = Long.parseLong(n1.toString()) - Long.parseLong(n2.toString());
        } else if (canParse(n1.toString(), Double::parseDouble) && canParse(n2.toString(), Double::parseDouble)) {
            result = Double.parseDouble(n1.toString()) - Double.parseDouble(n2.toString());
        } else {
            throw new IllegalArgumentException();
        }
        return result;
    }

    public double multiply(T n1, T n2) {
        double result = 0.0;
        // 입력 값이 int가 적합한지 long이 적합한지 판단하기는 하지만 사실 결과 값에서
        if (canParse(n1.toString(), Integer::parseInt) && canParse(n2.toString(), Integer::parseInt)) {
            result = Integer.parseInt(n1.toString()) * Integer.parseInt(n2.toString());
        } else if (canParse(n1.toString(), Long::parseLong) && canParse(n2.toString(), Long::parseLong)) {
            result = Long.parseLong(n1.toString()) * Long.parseLong(n2.toString());
        } else if (canParse(n1.toString(), Double::parseDouble) && canParse(n2.toString(), Double::parseDouble)) {
            result = Double.parseDouble(n1.toString()) * Double.parseDouble(n2.toString());
        } else {
            throw new IllegalArgumentException();
        }
        return result;
    }

    public double divide(T n1, T n2) {
        double result = 0.0;
        // 입력 값이 int가 적합한지 long이 적합한지 판단하기는 하지만 사실 결과 값에서
        if (canParse(n1.toString(), Integer::parseInt) && canParse(n2.toString(), Integer::parseInt)) {
            result = Integer.parseInt(n1.toString()) / Integer.parseInt(n2.toString());
        } else if (canParse(n1.toString(), Long::parseLong) && canParse(n2.toString(), Long::parseLong)) {
            result = Long.parseLong(n1.toString()) / Long.parseLong(n2.toString());
        } else if (canParse(n1.toString(), Double::parseDouble) && canParse(n2.toString(), Double::parseDouble)) {
            result = Double.parseDouble(n1.toString()) / Double.parseDouble(n2.toString());
        } else {
            throw new IllegalArgumentException();
        }
        return result;
    }

    // 형변환 가능한지 검증하는 코드인데 이것도 그냥 제네릭 하게 해보자
    private <T> boolean canParse(String input, Function<String, T> parser) {
        try {
            parser.apply(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
