package com.example.calculator;

import java.math.BigDecimal;
import java.util.*;

public class CalculationRecorder {
    // 맵에서 사용 할 키이다 데이터베이스 기본키 1씩 증가하듯 증가시킨다
    private static Integer id = 0;
    private final static Map<Integer, Calculation> calculations = new TreeMap();

    // n1, n2 형을 어떤걸로 하는게 좋을까? String, double? 다른 참조형?
    public void addCalculation(BigDecimal n1, BigDecimal n2, char o, BigDecimal result, boolean isOk) {
        calculations.put(id, new Calculation(n1, n2, o, result, isOk));
        id++;
    }

    // 계산 이력 하나 가져오기 카피본을 보냄
    public Calculation getCalculation(Integer key) {
        return new Calculation(calculations.get(key));
    }

    // 마지막 계산 이력만 가져오기
    public Calculation getLastCalculation() {
        return getCalculation(calculations.size() - 1);
    }

    // 전체 계산 이력 가져오기 카피본을 보냄
    public Map<Integer, Calculation> getAllCalculations() {
        return Map.copyOf(calculations);
    }

    // 계산 이력에 코멘트를 수정 한다
    public void setCalculationComment(Integer key, String comment) {
        calculations.get(key).setComment(comment);
    }

    // 계산 이력을 지운다
    public void removeCalculation(Integer key) {
        calculations.remove(key);
    }
}
