package com.example.calculator;

import java.time.LocalDateTime;

public class CalculationHistory {
    private int num1;
    private int num2;
    private char operator;
    private int result;
    private LocalDateTime dateTime;


    // 안헷갈리게 this도 명시하고 파라메타도 다른 이름으로 한다
    CalculationHistory(int n1, int n2, char o, int r, LocalDateTime dt){
        this.num1 = n1;
        this.num2 = n2;
        this.operator = o;
        this.result = r;
        this.dateTime = dt;
    }
    // 어차피 현재시간 넣을거면 그냥 생성자에서 만들게 DateTime 안넣는 버전 생성자
    CalculationHistory(int n1, int n2, char o, int r){
        this.num1 = n1;
        this.num2 = n2;
        this.operator = o;
        this.result = r;
        this.dateTime = LocalDateTime.now();
    }
}
