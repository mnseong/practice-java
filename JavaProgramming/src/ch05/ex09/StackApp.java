package ch05.ex09;

import java.util.Scanner;

public class StackApp {
    public static void main(String[] args) {
        System.out.print("총 스택 저장 공간의 크기 입력 >> ");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine();
        StringStack ss = new StringStack(num);
        
        while (true) {
            System.out.print("문자열 입력 >> ");
            String word = scanner.nextLine();
            if (word.equals("그만")) {
                System.out.print("스택에 저장된 모든 문자열 팝 : ");
                while (ss.length() > 0) {
                    System.out.printf("%s ", ss.pop());
                }
                break;
            } else ss.push(word);
        }
        scanner.close();
    }
}
