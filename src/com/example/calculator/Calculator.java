package com.example.calculator;

// 원래 계산과 계산된 데이터의 저장까지 담당하고 있었으나 저장은 CalculatorArchives가 담당하도록 변경됨
// 우선 계산과 CalculatorArchives에 요청 보내는 것 그리고 요청 결과 출력까지 담당 할 생각이다

import java.util.List;

public class Calculator {
    private CalculationArchive archives = new CalculationArchive();

    public boolean calculate(int n1, int n2, char o) {
        ArithmeticCalculator test = new ArithmeticCalculator<>();
        boolean isOk = false;
        int result = 0;
        try {
            OperatorType op = OperatorType.from(o);
            result = op.apply(n1, n2);
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
        archives.addCalculationHistory(n1, n2, o, result, isOk);
        return isOk;
    }

    public void printLastCalculationHistory() {
        System.out.println(archives.getLastCalculationHistory());
    }

    public void printLastCalculationHistorys() {
        // 조회를 위해 수정불가가 걸린 리스트를 받아온다
        List<CalculationHistory> list = archives.getAllCalculationHistorys();
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.println("인덱스 : " + i + " | " + list.get(i));
        }
    }

    public void putCalculationHistoryComment(int index, String comment) {
        archives.setCalculationHistoryComment(index, comment);
    }

    public void deletCalculationHistory(int index) {
        archives.removeCalculationHistory(index);
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


