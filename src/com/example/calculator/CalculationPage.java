package com.example.calculator;

import java.math.BigDecimal;
import java.util.List;

public class CalculationPage extends Page {
    private ArithmeticCalculator calculator = new ArithmeticCalculator();
    private CalculationRecorder recorder = new CalculationRecorder();

    @Override
    public void open() {
        boolean run = true;
        while (run) {
            try{
                System.out.println("공백으로 구분하여 첫 번째 숫자 사칙연산 기호 두 번째 숫자 순으로 입력해 주세요. (exit 입력 시 메인메뉴로 이동)");
                System.out.println("예) 1 + 1");
                String s = sc.next();
                if (s.equals("exit") || s.equals("q")) {
                    break;
                } else {
                    BigDecimal n1 = new BigDecimal(s);
                    char o = sc.next().charAt(0);
                    BigDecimal n2 = new BigDecimal(sc.next());

                    if (calculator.calculate(n1, n2, o)) {
                        System.out.println("계산에 성공 했습니다!");
                    } else {
                        System.out.println("계산에 실패 했습니다!");
                    }
                    System.out.println(recorder.getLastCalculation());
                }
            }catch (NumberFormatException e){
                System.out.println("옳바른 숫자가 입력되지 않았습니다. 계산을 종료 하고 메인으로 이동 합니다.");
                break;
            }
        }
    }
}
