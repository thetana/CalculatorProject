package com.example.calculator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CalculationRecorder {
    private static List<Calculation> calculations = new ArrayList<>();

    // n1, n2 형을 어떤걸로 하는게 좋을까? String, double? 다른 참조형?
    public void addCalculation(BigDecimal n1, BigDecimal n2, char o, BigDecimal result, boolean isOk) {
        calculations.add(new Calculation(n1, n2, o, result, isOk));
    }

    public Calculation getCalculation(int index) {
        return new Calculation(calculations.get(index));
    }
    public Calculation getLastCalculation() {
        return getCalculation(calculations.size() - 1);
    }

    public List<Calculation> getAllCalculations() {
        return List.copyOf(calculations);
    }

    public void setCalculationComment(int index, String comment) {
        calculations.get(index).setComment(comment);
    }
    public void removeCalculation(int index) {
        calculations.remove(index);
    }
}
