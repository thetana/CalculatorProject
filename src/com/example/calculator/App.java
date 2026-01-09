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

            if(in.equals("1")){
                // 계산을 여러번 할 때 매번 메인 메뉴 가면 불편하니까 여러번 할 수 있게 while을 해주자
                while (true) {
                    System.out.print("첫 번째 숫자를 입력하세요: ");
                    int n1 = sc.nextInt();
                    System.out.print("두 번째 숫자를 입력하세요: ");
                    int n2 = sc.nextInt();

                    System.out.print("사칙연산 기호를 입력하세요: ");
                    char o = sc.next().charAt(0);

                    boolean isOk = calculator.calculate(n1, n2, o);
                    if (isOk) {
                        System.out.println("계산에 성공 했습니다!");
                    } else {
                        System.out.println("계산에 실패 했습니다!");
                    }
                    System.out.println(calculator.getLastCalculationHistoryToString());

                    System.out.println("더 계산 하시려면 아무거나 입력 하세요. (0 또는 exit 입력 시 메인메뉴로 이동)");
                    String s = sc.next();
                    if(s.equals("exit") || s.equals("0")) {
                        break;
                    }
                }
            }else if(in.equals("2")){

            }else if(in.equals("0") || in.equals("exit")){
                System.exit(0);
            }else {
                System.out.println("입력하신 메뉴를 찾지 못했습니다. 다시 입력해 주세요.");
            }
        }
    }
}