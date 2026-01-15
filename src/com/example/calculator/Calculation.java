package com.example.calculator;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Calculation {
    private BigDecimal num1;
    private BigDecimal num2;
    private char operator;
    private BigDecimal result;
    private boolean isOk;
    private String comment = "";
    private LocalDateTime createdDt = LocalDateTime.now();
    private LocalDateTime updatedDt; // 지금 안쓰지만 언젠가 쓸 수도 있으니 저장 해둔다 (영구저장이 아니라 미리 해도 의미는 없는데 영구저장을 염두해두고 일단 저장 한다)

    // 안헷갈리게 this도 명시하고 파라메타도 다른 이름으로 한다
    Calculation(BigDecimal n1, BigDecimal n2, char o, BigDecimal r, boolean ok, LocalDateTime dt) {
        this.num1 = n1;
        this.num2 = n2;
        this.operator = o;
        this.result = r;
        this.isOk = ok;
        this.createdDt = dt;
    }

    // 어차피 현재시간 넣을거면 그냥 생성자에서 만들게 DateTime 안넣는 버전 생성자
    Calculation(BigDecimal n1, BigDecimal n2, char o, BigDecimal r, boolean ok) {
        this.num1 = n1;
        this.num2 = n2;
        this.operator = o;
        this.result = r;
        this.isOk = ok;
    }

    // 조회 상황에서 복사본을 만들어서 사용하게 하기 위한 생성자
    Calculation(Calculation other) {
        this.num1 = other.num1;
        this.num2 = other.num2;
        this.operator = other.operator;
        this.result = other.result;
        this.isOk = other.isOk;
        this.createdDt = other.createdDt;
    }

    // 코멘트만 수정한다
    public void setComment(String c) {
        this.comment = c;
        this.updatedDt = LocalDateTime.now();
    }

    // 필요 할 수 있어서 만들어 놨던거 데이터 한번에 다 수정하기
    public void setAll(BigDecimal n1, BigDecimal n2, char o, BigDecimal r, boolean ok) {
        this.num1 = n1;
        this.num2 = n2;
        this.operator = o;
        this.result = r;
        this.isOk = ok;
        this.updatedDt = LocalDateTime.now();
    }

    // 계산 결과를 편의상 그냥 double로 했는데 계산에 정확도가 떨어질 수 있지 않나 생각이 들긴 한다
    public double getResult() {
        return this.result.doubleValue();
    }

    // 그냥 익숙하니까 toString 이라고 이름 지었는데 오버라이드 되어서 print에 오브젝트 넣으면 알아서 실행됨
    // print에 그냥 오브젝트 넣으면 toString()이 실행 되는 것도 신기한데 toString을 오버라이드 하는 것도 개신기함
    @Override
    public String toString() {
        if (isOk) {
            return "계산 결과 : " + num1 + " " + operator + " " + num2 + " = " + result + " | 코멘트 : " + comment + " | 계산 일시 : " + createdDt;
        } else {
            return "계산 결과 : " + num1 + " " + operator + " " + num2 + " = 계산 실패 | 코멘트 : " + comment + " | 계산 일시 : " + createdDt;
        }
    }
}
