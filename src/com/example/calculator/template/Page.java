package com.example.calculator.template;

import java.util.Scanner;

// 콘솔의 입출력 즉 CLI 상의 입력과 출력을 담당하는 클래스들을 Page라는 명칭으로 만들어 낼 생각인데
// 그 Page들을 정의 하는 추상된 클래스 이다
// 원래 설계는 출력만 가능한 페이지(View)와 입력과 출력을 모두 담당하는 페이지를 분리해서 만들려고 했지만
// 구현부 로직이 좀 복잡해지고 너무 오버 엔지니어링이라는 생각이 들어서 출력만을 하더라도 Page로 판단 하기로 했다
// 사실 Page 상위 클래스로 Comtext라는 안드로이드 Context와 유사한 역할을 하는 클래스를 둘까 했지만
// 필요한 공용 자원을 쉽게 참조하고 관리 할 수 있다는 장점이 있는 반면 모든 Page에서 불필요한 기능들까지 사용 가능해진다는 단점이 있어 포기했다
// (이부분도 오버 엔지니어링이라는 생각이 들었다)

public abstract class Page {
    protected String name; // 메뉴 출력에서 사용 할 이름
    protected final Scanner sc = new Scanner(System.in);
    public void open() {
    }
}
