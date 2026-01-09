package com.example.calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator();


        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int n1 = sc.nextInt();
            System.out.print("두 번째 숫자를 입력하세요: ");
            int n2 = sc.nextInt();

            System.out.print("사칙연산 기호를 입력하세요: ");
            char o = sc.next().charAt(0);

            int result = calculator.calculate(n1, n2, o);
            System.out.println("결과: " + result);
            System.out.println("더 계산 하시려면 아무거나 입력 하세요. (exit 입력 시 종료)");

            if (sc.next().equals("exit")) {
                System.exit(0);
            }
        }
    }
}