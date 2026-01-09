package com.example.calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int n1 = sc.nextInt();
            System.out.print("두 번째 숫자를 입력하세요: ");
            int n2 = sc.nextInt();

            System.out.print("사칙연산 기호를 입력하세요: ");
            char c = sc.next().charAt(0);
            int result = 0;
            try {
                // 향 후에 x, X, %, ×, ÷ 등의 문자도 수용 할 수 있게 고려. 아마 if로 해주는게 나을 수 있음
                switch (c) {
                    case '+':
                        result = n1 + n2;
                        break;
                    case '-':
                        result = n1 - n2;
                        break;
                    case '*':
                        result = n1 * n2;
                        break;
                    case '/':
                        result = n1 / n2;
                        break;
                    default:
                        System.out.println("연산 할 수 없는 기호 입니다.");
                }
                System.out.println("결과: " + result);
                System.out.println("더 계산 하시려면 아무거나 입력 하세요. (exit 입력 시 종료)");
                if (sc.next().equals("exit")) {
                    System.exit(0);
                }
            } catch (ArithmeticException e) {
                // 우선 0나누기만 추가 향후 몇가지 예외처리 추가
                System.out.println("0으로 나눌 수 없습니다.");
            } catch (Exception e) {
                System.out.println("예상치 못한 에러 입니다.");
            }
        }
    }
}