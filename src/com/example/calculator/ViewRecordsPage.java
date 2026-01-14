package com.example.calculator;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ViewRecordsPage extends Page {
    private Map<String, String> filter = new HashMap();
    private CalculationRecorder recorder = new CalculationRecorder();

    public void open() {
        try {
            Map<Integer, Calculation> map = recorder.getAllCalculations();
            if (filter.size() > 0) {
                for (String k : filter.keySet()) {
                    if (k.equals("m") || k.equals("M")) {
                        map = map.entrySet().stream() // 1. 데이터 준비: 스트림 생성
                                .filter(v -> v.getValue().getResult() >= Double.parseDouble(filter.get(k)))    // 2. 중간 연산: 짝수만 필터링// 3. 중간 연산: 10배로 변환
                                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)); // 4. 최종 연산: 리스트로 변환
                    }
                }
            }
            map.forEach((k, v) -> System.out.println("키 : " + k + " | " + v));
            System.out.println("특장 결과 값 이상만 필터 : f m [결과 값]");
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 필터 데이터");
        }
    }

    public void setFilter(String f, String v) {
        this.filter.put(f, v);
    }
}
