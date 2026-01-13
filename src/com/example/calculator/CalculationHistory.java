package com.example.calculator;

import java.time.LocalDateTime;

// Calculator 클래스 안에서만 쓰고 싶어서 이너 클래스로 잠깐 들어갔다 다시 개별 클래스로 만듬
// 이유는 CalculatorArchives 도입으로 편의상 이너 클래스 보다는 개별 클래스로 동작 하는게 낫다고봄
// (메인에서는 CalculatorArchives에 직접 적근하지 않기 때문에 굳이 이너 클래스로 관리 하지 않아도 개발자의 실수로부터 데이터를 보호 할 수 있다)

class CalculationHistory {
    private String num1;
    private String num2;
    private char operator;
    private String result;
    private boolean isOk;
    private String comment = "";
    private LocalDateTime createdDt  = LocalDateTime.now();
    private LocalDateTime updatedDt; // 지금 안쓰지만 언젠가 쓸 수도 있으니 저장 해둔다 (영구저장이 아니라 미리 해도 의미는 없는데 영구저장을 염두해두고 일단 저장 한다)

    // 안헷갈리게 this도 명시하고 파라메타도 다른 이름으로 한다
    CalculationHistory(String n1, String n2, char o, String r, boolean ok, LocalDateTime dt) {
        this.num1 = n1;
        this.num2 = n2;
        this.operator = o;
        this.result = r;
        this.isOk = ok;
        this.createdDt = dt;
    }

    // 어차피 현재시간 넣을거면 그냥 생성자에서 만들게 DateTime 안넣는 버전 생성자
    CalculationHistory(String n1, String n2, char o, String r, boolean ok) {
        this.num1 = n1;
        this.num2 = n2;
        this.operator = o;
        this.result = r;
        this.isOk = ok;
    }

    // 조회 상황에서 복사본을 만들어서 사용하게 하기 위한 생성자
    CalculationHistory(CalculationHistory other) {
        this.num1 = other.num1;
        this.num2 = other.num2;
        this.operator = other.operator;
        this.result = other.result;
        this.isOk = other.isOk;
        this.createdDt = other.createdDt;
    }

    void setComment(String c){
        this.comment = c;
        this.updatedDt = LocalDateTime.now();
    }

    void setAll(String n1, String n2, char o, String r, boolean ok){
        this.num1 = n1;
        this.num2 = n2;
        this.operator = o;
        this.result = r;
        this.isOk = ok;
    }

    // 그냥 익숙하니까 toString 이라고 이름 지었는데 오버라이드 되어서 print에 오브젝트 넣으면 알아서 실행됨
    // print에 그냥 오브젝트 넣으면 toString()이 실행 되는 것도 신기한데 toString을 오버라이드 하는 것도 개신기함
    @Override
    public String toString() {
        if (isOk) {
            return "계산 결과 : " + num1 + " " + operator + " " + num2 + " = " + result + " | 노트 : " + comment + " | 계산 일시 : " + createdDt;
        } else {
            return "계산 결과 : " + num1 + " " + operator + " " + num2 + " = 계산 실패 | 노트 : " + comment + " | 계산 일시 : " + createdDt;
        }
    }
}