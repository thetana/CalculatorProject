package com.example.calculator;

import java.math.BigDecimal;
import java.util.*;

public class CalculationRecorder {
    //    private static List<Calculation> calculations = new ArrayList<>();
    private static Integer id = 0;
    private final static Map<Integer, Calculation> calculations = new TreeMap();

    // n1, n2 형을 어떤걸로 하는게 좋을까? String, double? 다른 참조형?
    public void addCalculation(BigDecimal n1, BigDecimal n2, char o, BigDecimal result, boolean isOk) {
//        calculations.add(new Calculation(n1, n2, o, result, isOk));
        calculations.put(id, new Calculation(n1, n2, o, result, isOk));
        id++;
    }

    public Calculation getCalculation(Integer key) {
        return new Calculation(calculations.get(key));
    }

    public Calculation getLastCalculation() {
        return getCalculation(calculations.size() - 1);
    }

    public Map<Integer, Calculation> getAllCalculations() {
        return Map.copyOf(calculations);
    }

    public void setCalculationComment(Integer key, String comment) {
        calculations.get(key).setComment(comment);
    }

    public void removeCalculation(Integer key) {
        calculations.remove(key);
    }
}
