package com.example.calculator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private List<CalculationHistory> calculationHistorys = new ArrayList<CalculationHistory>();

    public boolean calculate(int n1, int n2, char o) {
        boolean isOk = false;
        int result = 0;
        try {
            // 향 후에 x, X, %, ×, ÷ 등의 문자도 수용 할 수 있게 고려. 아마 if로 해주는게 나을 수 있음
            switch (o) {
                case '+':
                    result = n1 + n2;
                    isOk = true;
                    break;
                case '-':
                    result = n1 - n2;
                    isOk = true;
                    break;
                case '*':
                    result = n1 * n2;
                    isOk = true;
                    break;
                case '/':
                    result = n1 / n2;
                    isOk = true;
                    break;
                default:
                    System.out.println("연산 할 수 없는 기호 입니다.");
                    isOk = false;
            }
        } catch (ArithmeticException e) {// 우선 0나누기만 추가 향후 몇가지 예외처리 추가
            isOk = false;
            System.out.println("0으로 나눌 수 없습니다.");
        } catch (Exception e) {
            System.out.println("예상치 못한 에러 입니다.");
        }
        addCalculationHistory(n1, n2, o, result, isOk);
        return isOk;
    }

    private void addCalculationHistory(int n1, int n2, char o, int result, boolean isOk) {
        calculationHistorys.add(new CalculationHistory(n1, n2, o, result, isOk));
    }

    public CalculationHistory getCalculationHistory(int index) {
        return calculationHistorys.get(index);
    }

    public CalculationHistory getLastCalculationHistory() {
        return getCalculationHistory(calculationHistorys.size() - 1);
    }

    public String getLastCalculationHistoryToString() {
        return getLastCalculationHistory().toString();
    }


    // Calculator 클래스 안에서만 쓰고 싶어서 인어 클래스로 만들었다
    // 사실 처음엔 그냥 public하게 만들었는데 무분별하게 데이터를 수정하지 못하게 (정해진 기능 안에서만 수정 될 수 있게) 하고 싶어서 막았다
    private class CalculationHistory {
        private int num1;
        private int num2;
        private char operator;
        private int result;
        private boolean isOk;
        private LocalDateTime dateTime;


        // 안헷갈리게 this도 명시하고 파라메타도 다른 이름으로 한다
        CalculationHistory(int n1, int n2, char o, int r, boolean ok, LocalDateTime dt) {
            this.num1 = n1;
            this.num2 = n2;
            this.operator = o;
            this.result = r;
            this.isOk = ok;
            this.dateTime = dt;
        }

        // 어차피 현재시간 넣을거면 그냥 생성자에서 만들게 DateTime 안넣는 버전 생성자
        CalculationHistory(int n1, int n2, char o, int r, boolean ok) {
            this.num1 = n1;
            this.num2 = n2;
            this.operator = o;
            this.result = r;
            this.isOk = ok;
            this.dateTime = LocalDateTime.now();
        }

        public String toString() {
            if (isOk) {
                return "계산 결과 : " + num1 + " " + operator + " " + num2 + " = " + result + " | 계산 일시 : " + dateTime;
            } else {
                return "계산 결과 : " + num1 + " " + operator + " " + num2 + " = 계산 실패 | 계산 일시 : " + dateTime;
            }
        }
    }
}


