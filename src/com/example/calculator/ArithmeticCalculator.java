package com.example.calculator;

import java.math.BigDecimal;
import java.util.function.Function;

public class ArithmeticCalculator implements Calculateable<BigDecimal, BigDecimal, Boolean> {
    private final CalculationRecorder recorder = new CalculationRecorder();

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

    // 형변환 가능한지 검증하는 코드인데 이것도 그냥 제네릭 하게 해보자
    // 이전에 아무 숫자나 들어오면 최적의 형으로 변환하여 계산하는 로직을 만들었는데 그때 사용하던 메소드 이다
    // 지금은 안쓰긴 하는데 또 쓸만도 하니 그냥 그대로 두었다
    private <T> boolean canParse(String input, Function<String, T> parser) {
        try {
            parser.apply(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
