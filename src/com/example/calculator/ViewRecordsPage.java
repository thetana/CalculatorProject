package com.example.calculator;

import java.util.List;
import java.util.Map;

public class ViewRecordsPage extends Page {
    private Map<String, Object> filter = null;
    private CalculationRecorder recorder = new CalculationRecorder();

    public void open() {
        try {
            if (filter != null) {
                if (true) {

                } else { // 필터가 있는데 해석이 안되는 필터가 들어옴
                    throw new IllegalArgumentException();
                }
            } else { // 일종의 디폴트 값이다
                List<Calculation> list = recorder.getAllCalculations();
                for (int i = list.size() - 1; i >= 0; i--) {
                    System.out.println("인덱스 : " + i + " | " + list.get(i));
                }
                System.out.println("필터 사용법: ");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 필터 데이터");
        }
    }

    public void setFilter(Map<String, Object> f) {
        this.filter = f;
    }
}
