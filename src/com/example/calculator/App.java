package com.example.calculator;

public class App {

    public void start(){
        MainPage page = new MainPage();
        page.open();
    }







//    private static CalculationArchive archives = new CalculationArchive();
//    static Calculateable<Double, Double, Boolean> doubleCalculator = (n1, n2, o) -> {
//        Double result = 0.0;
//        boolean isOk = false;
//        try {
//            OperatorType operatorType = OperatorType.from(o);
//            switch (operatorType) {
//                case PLUS -> result = n1 + n2;
//                case MINUS -> result = n1 - n2;
//                case MULTIPLY -> result = n1 * n2;
//                case DIVIDE -> result = n1 / n2;
//                default -> throw new IllegalArgumentException();
//            }
//            isOk = true;
//        } catch (IllegalArgumentException e) {// 지원하지 않는 연산자 썼을 때
//            isOk = false;
//            System.out.println("연산 할 수 없는 기호 입니다.");
//        } catch (ArithmeticException e) {// 우선 0나누기만 추가 향후 몇가지 예외처리 추가
//            isOk = false;
//            System.out.println("0으로 나눌 수 없습니다.");
//        } catch (Exception e) {
//            System.out.println("예상치 못한 에러 입니다.");
//        }
//        archives.addCalculationHistory(n1.toString(), n1.toString(), o, result.toString(), isOk);
//        return isOk;
//    };
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        Calculator calculator = new Calculator();
//
//        while (true) {
//            System.out.println("메인 메뉴");
//            System.out.println("1. 계산 하기");
//            System.out.println("2. 계산 기록");
//            System.out.println("0. 종료");
//            String in = sc.next();
//
//            if (in.equals("1")) {
//                // 계산을 여러번 할 때 매번 메인 메뉴 가면 불편하니까 여러번 할 수 있게 while을 해주자
//                while (true) {
//                    System.out.println("공백으로 구분하여 첫 번째 숫자 사칙연산 기호 두 번째 숫자 순으로 입력해 주세요. (exit 입력 시 메인메뉴로 이동)");
//                    System.out.println("예) 1 + 1");
//                    String s = sc.next();
//                    if (s.equals("exit") || s.equals("q")) {
//                        break;
//                    } else {
//                        double n1 = Double.parseDouble(s);
//                        char o = sc.next().charAt(0);
//                        double n2 = sc.nextDouble();
//
//                        if (doubleCalculator.calculate(n1, n2, o)) {
//                            System.out.println("계산에 성공 했습니다!");
//                        } else {
//                            System.out.println("계산에 실패 했습니다!");
//                        }
//                        printLastCalculationHistory();
//                    }
//                }
//            } else if (in.equals("2")) {
//                while (true) {
//                    printCalculationHistorys();
//                    System.out.println("1. 이력 코멘트 달기, 2. 데이터 삭제, 0. 메인 메뉴로 이동");
//                    String s = sc.next();
//                    if (s.equals("1")) {
//                        printCalculationHistorys();
//                        System.out.println("공백으로 구분하여 인덱스 코멘트 순으로 입력해 주세요. (exit 입력 시 뒤로가기)");
//                        System.out.println("예) 0 코멘트");
//                        s = sc.next(); // 뒤로가기를 할 수도 있으니
//
//                        if (s.equals("exit") || s.equals("q")) {
//                            break;
//                        } else {
//                            int index = Integer.parseInt(s);
//                            String comment = sc.next();
//                            calculator.putCalculationHistoryComment(index, comment);
//                        }
//                    } else if (in.equals("2")) {
//                        printCalculationHistorys();
//                        System.out.println("삭제 할 인덱스 입력. (exit 입력 시 뒤로가기)");
//                        System.out.println("인덱스는 리스트에 인덱스 이며 유일한 키 값이 아님으로 삭제 후 해당 인덱스가 다시 존재 가능 (값은 정확히 지워짐)");
//                        s = sc.next(); // 뒤로가기를 할 수도 있으니
//                        if (s.equals("exit") || s.equals("q")) {
//                            break;
//                        } else {
//                            int index = Integer.parseInt(s);
//                            calculator.deletCalculationHistory(index);
//                        }
//                    } else if (in.equals("0") || in.equals("exit")) {
//                        break;
//                    } else {
//                        System.out.println("입력하신 메뉴를 찾지 못했습니다. 다시 입력해 주세요.");
//                    }
//                }
//            } else if (in.equals("0") || in.equals("exit")) {
//                System.exit(0);
//            } else {
//                System.out.println("입력하신 메뉴를 찾지 못했습니다. 다시 입력해 주세요.");
//            }
//        }
//    }
//
//    public static void printLastCalculationHistory() {
//        System.out.println(archives.getLastCalculationHistory());
//    }
//    public static void printCalculationHistorys() {
//        // 조회를 위해 수정불가가 걸린 리스트를 받아온다
//        List<CalculationHistory> list = archives.getAllCalculationHistorys();
//        for (int i = list.size() - 1; i >= 0; i--) {
//            System.out.println("인덱스 : " + i + " | " + list.get(i));
//        }
//    }
}