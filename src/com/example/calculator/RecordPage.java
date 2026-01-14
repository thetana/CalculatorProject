package com.example.calculator;

import javax.print.DocFlavor;
import java.math.BigDecimal;
import java.util.Map;

public class RecordPage extends Page {
    private ArithmeticCalculator calculator = new ArithmeticCalculator();
    private CalculationRecorder recorder = new CalculationRecorder();

    @Override
    public void open() {
        ViewRecordsPage view = new ViewRecordsPage();
        while (true) {
            view.open();
            System.out.println("공백으로 구분 하여 명령어와 대상 데이터 입력");
            System.out.println("이력 코멘트 달기 : c [인덱스] [코멘트 내용], 데이터 삭제 : d [인덱스], 0. 메인 메뉴로 이동");
            String s = sc.next();
            if (s.equals("c") || s.equals("C")) {
                int key = sc.nextInt();
                String comment = sc.next();
                recorder.setCalculationComment(key, comment);
            } else if (s.equals("d") || s.equals("D")) {
                int key = sc.nextInt();
                recorder.removeCalculation(key);
            } else if (s.equals("f") || s.equals("F")) {
                String f = sc.next();
                String v = sc.next();
                view.setFilter(f, v);
            } else if (s.equals("0") || s.equals("exit")) {
                break;
            } else {
                System.out.println("입력하신 메뉴를 찾지 못했습니다. 다시 입력해 주세요.");
            }
        }
    }
}
