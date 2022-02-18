package ch03;

import java.util.Scanner;

public class RockScissorsPaper {
    public static void main(String[] args) {
        System.out.println("컴퓨터와 가위 바위 보 게임을 합니다.");
        Scanner scanner = new Scanner(System.in);
        String str[] = {"가위", "바위", "보"};
        while (true) {
            int n = (int)(Math.random()*3);
            System.out.print("가위 바위 보!>>");
            String s = scanner.next();
            
            if (s.equals("그만")) {
                System.out.println("게임을 종료합니다...");
                break;
            }
            
            if (s.equals(str[n])) {
                System.out.println("사용자 = " + s + ", 컴퓨터 = " + str[n] + ", 비겼습니다.");
            } else if (str[n].equals("가위")) {
                if (s.equals("바위")) {
                    System.out.println("사용자 = " + s + ", 컴퓨터 = " + str[n] + ", 사용자가 이겼습니다.");
                } else {
                    System.out.println("사용자 = " + s + ", 컴퓨터 = " + str[n] + ", 사용자가 졌습니다.");
                }
            } else if (str[n].equals("바위")) {
                if (s.equals("보")) {
                    System.out.println("사용자 = " + s + ", 컴퓨터 = " + str[n] + ", 사용자가 이겼습니다.");
                } else {
                    System.out.println("사용자 = " + s + ", 컴퓨터 = " + str[n] + ", 사용자가 졌습니다.");
                }
            } else if (str[n].equals("보")) {
                if (s.equals("가위")) {
                    System.out.println("사용자 = " + s + ", 컴퓨터 = " + str[n] + ", 사용자가 이겼습니다.");
                } else {
                    System.out.println("사용자 = " + s + ", 컴퓨터 = " + str[n] + ", 사용자가 졌습니다.");
                }
            }
        }
        scanner.close();
    }
}