package com.example.calculator;

// 기록 저장을 담당하는 클래스. Calculator가 너무 많은 책임을 담당 할 수 있다는 최원빈 튜터님의 피드백과
// JSON과 파일 IO를 활용한 영구저장을 구현 하고 싶다는 나의 야망이 반영 되어 만들게된 클래스
// 심플하게 기록 데이터 CRUD를 담당 한다

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CalculationArchive {
    private List<CalculationHistory> calculationHistorys = new ArrayList<>();

    public void addCalculationHistory(int n1, int n2, char o, int result, boolean isOk) {
        calculationHistorys.add(new CalculationHistory(n1, n2, o, result, isOk));
    }

    public CalculationHistory getCalculationHistory(int index) {
        return new CalculationHistory(calculationHistorys.get(index));
    }

    public CalculationHistory getLastCalculationHistory() {
        return getCalculationHistory(calculationHistorys.size() - 1);
    }

    public List<CalculationHistory> getAllCalculationHistorys() {
        return List.copyOf(calculationHistorys);
    }

    public void setCalculationHistoryComment(int index, String comment) {
        calculationHistorys.get(index).setComment(comment);
    }
}
