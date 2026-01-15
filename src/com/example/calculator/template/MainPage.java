package com.example.calculator.template;

import java.util.Map;
import java.util.TreeMap;

public class MainPage extends Page {
    // Page 클래스의 이점을 만들어주는 라우터
    // 컬렉션에 내가 원하는 메뉴 페이지를 넣어주면 유저에게 보여주는 출력 부터 메뉴 선택까지 한줄 끝낼 수 있다
    // 새로운 페이지를 추가해도 동적으로 생성해준다
    private final Map<String, Page> router = new TreeMap<>();

    public MainPage() {
        // 사용자한테 보여주고 이동 할 수 있는 페이지를 등록한다
        router.put("1", new CalculationPage());
        router.put("2", new RecordPage());
    }

    @Override
    public void open() {
        boolean run = true;
        while (run) {
            System.out.println("메인 메뉴");
            // 이동 할 수 있는 메뉴들은 동적으로 생성하여 보여준다
            router.forEach((k, v) -> System.out.println(k + ". " + v.name));
            System.out.println("0. 종료");
            String in = sc.next();
            if (in.equals("0") || in.equals("exit")) {
                run = false;
                System.exit(0);
            } else {
                try {
                    // if문 없이 맵을 이용해 유저가 선택한 메뉴로 바로 이동 한다
                    router.get(in).open();
                } catch (NullPointerException e) {
                    System.out.println("입력하신 메뉴를 찾지 못했습니다. 다시 입력해 주세요.");
                }
            }
        }
    }
}
