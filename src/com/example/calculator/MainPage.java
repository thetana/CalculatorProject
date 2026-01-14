package com.example.calculator;

public class MainPage extends Page {
    @Override
    public void open() {
        boolean run = true;
        while (run) {
            System.out.println("메인 메뉴");
            System.out.println("1. 계산 하기");
            System.out.println("2. 계산 기록");
            System.out.println("0. 종료");
            String in = sc.next();
            if (in.equals("1")) {
                CalculationPage page = new CalculationPage();
                page.open();
            } else if (in.equals("2")) {
                RecordPage page = new RecordPage();
                page.open();
            } else if (in.equals("0") || in.equals("exit")) {
                System.exit(0);
            } else {
                System.out.println("입력하신 메뉴를 찾지 못했습니다. 다시 입력해 주세요.");
            }
        }
    }
}
