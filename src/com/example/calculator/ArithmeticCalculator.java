package com.example.calculator;

import java.math.BigDecimal;
import java.util.function.Function;

public class ArithmeticCalculator implements Calculateable<BigDecimal, BigDecimal, Boolean> {
    private CalculationRecorder recorder = new CalculationRecorder();

    @Override
    public Boolean calculate(BigDecimal n1, BigDecimal n2, char o) {
        boolean isOk = false;
        BigDecimal result = null;
        try {
            switch (o) {
                case '+' -> result = OperatorType.PLUS.cal(n1, n2);
                case '-' -> result = OperatorType.MINUS.cal(n1, n2);
                case '*' -> result = OperatorType.MULTIPLY.cal(n1, n2);
                case '/' -> result = OperatorType.DIVIDE.cal(n1, n2);
                default -> throw new IllegalArgumentException();
            }
            System.out.println(result);
            isOk = true;
        } catch (IllegalArgumentException e) {// 지원하지 않는 연산자 썼을 때
            isOk = false;
            System.out.println("연산 할 수 없는 기호 입니다.");
        } catch (ArithmeticException e) {
            isOk = false;
            System.out.println("0으로 나눌 수 없습니다.");
        } catch (Exception e) {
            System.out.println("예상치 못한 에러 입니다.");
        }

        recorder.addCalculation(n1, n2, o, result, isOk);
        return isOk;
    }


    // 제네릭 한 값을 받아와서 적절한 형으로 변형하여 계산하고 더블로 반환한다
//    public double plus(T n1, T n2) {
//        double result = 0.0;
//        // 입력 값이 int가 적합한지 long이 적합한지 판단하기는 하지만 사실 결과 값에서
//        if (canParse(n1.toString(), Integer::parseInt) && canParse(n2.toString(), Integer::parseInt)) {
//            result = Integer.parseInt(n1.toString()) + Integer.parseInt(n2.toString());
//        } else if (canParse(n1.toString(), Long::parseLong) && canParse(n2.toString(), Long::parseLong)) {
//            result = Long.parseLong(n1.toString()) + Long.parseLong(n2.toString());
//        } else if (canParse(n1.toString(), Double::parseDouble) && canParse(n2.toString(), Double::parseDouble)) {
//            result = Double.parseDouble(n1.toString()) + Double.parseDouble(n2.toString());
//        } else {
//            throw new IllegalArgumentException();
//        }
//        return result;
//    }


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
