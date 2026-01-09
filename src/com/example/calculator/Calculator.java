package com.example.calculator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private List<CalculationHistory> calculationHistorys = new ArrayList<CalculationHistory>();

    public int calculate(int n1, int n2, char o) {
        int result = 0;
        try {
            // 향 후에 x, X, %, ×, ÷ 등의 문자도 수용 할 수 있게 고려. 아마 if로 해주는게 나을 수 있음
            switch (o) {
                case '+':
                    result = n1 + n2;
                    addCalculationHistory(n1, n2, o, result);
                    break;
                case '-':
                    result = n1 - n2;
                    addCalculationHistory(n1, n2, o, result);
                    break;
                case '*':
                    result = n1 * n2;
                    addCalculationHistory(n1, n2, o, result);
                    break;
                case '/':
                    result = n1 / n2;
                    addCalculationHistory(n1, n2, o, result);
                    break;
                default:
                    System.out.println("연산 할 수 없는 기호 입니다.");
            }
        } catch (ArithmeticException e) {
            // 우선 0나누기만 추가 향후 몇가지 예외처리 추가
            System.out.println("0으로 나눌 수 없습니다.");
        } catch (Exception e) {
            System.out.println("예상치 못한 에러 입니다.");
        }
        return result;
    }


    private void addCalculationHistory(int n1, int n2, char o, int result) {
        calculationHistorys.add(new CalculationHistory(n1, n2, o, result));
    }

}
