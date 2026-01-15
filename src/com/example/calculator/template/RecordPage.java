package com.example.calculator.template;

import com.example.calculator.CalculationRecorder;

// 저장된 계산 이련에 대한 기능들을 수행한다
// 원래 삭제하는 Page 수정하는 Page 따로 만들려고 했으나 여기서 다 처리하는게 유저도 편리하고 만들기도 깔끔하다고 생각 했다

public class RecordPage extends Page {
    private final CalculationRecorder recorder = new CalculationRecorder();

    RecordPage(){
        name = "계산 기록";
    }

    @Override
    public void open() {
        ViewRecordsPage view = new ViewRecordsPage();
        boolean run = true;
        while (run) {
            view.open();
            System.out.println("공백으로 구분 하여 명령어와 대상 데이터 입력");
            System.out.println("이력 코멘트 달기 : c [키] [코멘트 내용], 데이터 삭제 : d [키], 0. 메인 메뉴로 이동");
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
                run = false;
                break;
            } else {
                System.out.println("입력하신 메뉴를 찾지 못했습니다. 다시 입력해 주세요.");
            }
        }
    }
}
