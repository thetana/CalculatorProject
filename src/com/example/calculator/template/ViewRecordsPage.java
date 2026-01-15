package com.example.calculator.template;

import com.example.calculator.Calculation;
import com.example.calculator.CalculationRecorder;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

// 조회만 수행하는 페이지를 View라고 정의한다
// 여러 곳에서 사용 될 수 있는 조회 데이터를 보통 출력 한다

public class ViewRecordsPage extends Page {
    // 여러개의 필터를 적용 할 수 있게 하기 위해 필터를 맵으로 저장 했다
    private final Map<String, String> filter = new HashMap();
    private final CalculationRecorder recorder = new CalculationRecorder();

    public void open() {
        try {
            Map<Integer, Calculation> map = recorder.getAllCalculations();
            if (filter.size() > 0) {
                for (String k : filter.keySet()) {
                    // 이 Page에서 사용 가능한 필터링은 이곳에서 로직을 추가한다 if else로 추가하면 중복적용을 못하기 때문에 if로 추가해야 한다
                    if (k.equals("m") || k.equals("M")) {
                        map = map.entrySet().stream() // 스트림 생성
                                .filter(v -> v.getValue().getResult() >= Double.parseDouble(filter.get(k))) // 유저 입력 값 이상만
                                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)); // 맵으로 변환
                    }
                }
            }
            map.forEach((k, v) -> System.out.println("키 : " + k + " | " + v));
            System.out.println("특장 결과 값 이상만 필터 : f m [결과 값]");
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 필터 데이터");
        }
    }

    // 필터를 셋팅하는 메소드
    public void setFilter(String f, String v) {
        this.filter.put(f, v);
    }
}
