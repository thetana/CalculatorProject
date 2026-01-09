package com.example.calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator();

        while (true) {
            System.out.println("메인 메뉴");
            System.out.println("1. 계산 하기");
            System.out.println("2. 계산 기록");
            System.out.println("0. 종료");
            String in = sc.next();

            if (in.equals("1")) {
                // 계산을 여러번 할 때 매번 메인 메뉴 가면 불편하니까 여러번 할 수 있게 while을 해주자
                while (true) {
                    System.out.println("공백으로 구분하여 첫 번째 숫자 사칙연산 기호 두 번째 숫자 순으로 입력해 주세요. (exit 입력 시 메인메뉴로 이동)");
                    System.out.println("예) 1 + 1");
                    String s = sc.next();
                    if (s.equals("exit") || s.equals("q")) {
                        break;
                    } else {
                        int n1 = Integer.parseInt(s);
                        char o = sc.next().charAt(0);
                        int n2 = sc.nextInt();
                        boolean isOk = calculator.calculate(n1, n2, o);
                        if (isOk) {
                            System.out.println("계산에 성공 했습니다!");
                        } else {
                            System.out.println("계산에 실패 했습니다!");
                        }
                        calculator.printLastCalculationHistory();
                    }
                }
            } else if (in.equals("2")) {
                while (true) {
                    calculator.printLastCalculationHistorys();
                    System.out.println("1. 이력 코멘트 달기, 2. 데이터 삭제, 0. 메인 메뉴로 이동");
                    String s = sc.next();
                    if (s.equals("1")) {
                        System.out.println("공백으로 구분하여 인덱스 코멘트 순으로 입력해 주세요. (exit 입력 시 뒤로가기)");
                        System.out.println("예) 0 코멘트");
                        s = sc.next();
                        if (s.equals("exit") || s.equals("q")) {
                            break;
                        } else {
                            int index = Integer.parseInt(s);
                            String comment = sc.next();
                            calculator.putCalculationHistoryComment(index, comment);
                        }
                    } else if (in.equals("2")) {
                    } else if (in.equals("0") || in.equals("exit")) {
                        break;
                    } else {
                        System.out.println("입력하신 메뉴를 찾지 못했습니다. 다시 입력해 주세요.");
                    }
                    int n = sc.nextInt();
                }
            } else if (in.equals("0") || in.equals("exit")) {
                System.exit(0);
            } else {
                System.out.println("입력하신 메뉴를 찾지 못했습니다. 다시 입력해 주세요.");
            }
        }
    }
}