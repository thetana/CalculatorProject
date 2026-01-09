package com.example.calculator;

// 원래 계산과 계산된 데이터의 저장까지 담당하고 있었으나 저장은 CalculatorArchives가 담당하도록 변경됨
// 우선 계산과 CalculatorArchives에 요청 보내는 것 그리고 요청 결과 출력까지 담당 할 생각이다

public class Calculator {
    CalculationArchive archives = new CalculationArchive();

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
        archives.addCalculationHistory(n1, n2, o, result, isOk);
        return isOk;
    }

    public String getLastCalculationHistoryToString() {
        return archives.getLastCalculationHistory().toString();
    }


//    public String getCalculationHistorys() {
//        calculationHistorys.
//
//
//        return getLastCalculationHistory().toString();
//    }
//
//    public String getCalculationHistorys() {
//        return getLastCalculationHistory().toString();
//    }




}


