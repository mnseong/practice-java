package ch06.ex09;

import java.util.Scanner;

public class MainApp {
    private void run() {
        Scanner scanner = new Scanner(System.in);
        Player[] player = new Player[2];
        player[0] = new Player();
        player[1] = new Player();
        while (true) {
            System.out.print("철수[가위(1), 바위(2), 보(3), 끝내기(4)]>>");
            int menuNum = scanner.nextInt();
            scanner.nextLine();
            
            if (menuNum == 4) {
                break;
            } else {
                int n = (int)(Math.random()*3 + 1);
                player[0].setState(menuNum);
                player[1].setState(n);
                checkWin(player);
            }
        }
    }
    private void checkWin(Player[] p) {
        String a = p[0].getState(); // User
        String b = p[1].getState(); // Com
        System.out.printf("철수(%s) : 컴퓨터(%s)\n", a, b);
        if (a.equals("가위")) {
            switch (b) {
                case "가위" :
                    System.out.println("서로 비겼습니다.");
                    break;
                case "바위" :
                    System.out.println("컴퓨터가 이겼습니다.");
                    break;
                case "보" :
                    System.out.println("철수가 이겼습니다.");
                    break;
            }
        } else if (a.equals("바위")) {
            switch (b) {
                case "가위" :
                    System.out.println("철수가 이겼습니다.");
                    break;
                case "바위" :
                    System.out.println("서로 비겼습니다.");
                    break;
                case "보" :
                    System.out.println("컴퓨터가 이겼습니다.");
                    break;
            }
        } else {
            switch (b) {
                case "가위" :
                    System.out.println("컴퓨터가 이겼습니다.");
                    break;
                case "바위" :
                    System.out.println("철수가 이겼습니다.");
                    break;
                case "보" :
                    System.out.println("서로 비겼습니다.");
                    break;
            }
        }
    }
    public static void main(String[] args) {
        MainApp app = new MainApp();
        app.run();
    }
}
