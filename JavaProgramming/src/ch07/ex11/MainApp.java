package ch07.ex11;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        GuessCapital game = new GuessCapital();
        Scanner scanner = new Scanner(System.in);
        System.out.println("**** 수도 맞추기 게임을 시작합니다. ****");
        int menuNum;
        runGame : while (true) {
            System.out.print("입력:1, 퀴즈:2, 종료:3>> ");
            menuNum = scanner.nextInt();
            scanner.nextLine();
            switch (menuNum) {
                case 1 :
                    game.push();
                    break;
                case 2 :
                    game.quiz();
                    break;
                case 3 :
                    System.out.println("게임을 종료합니다.");
                    break runGame;
            }
        }
        scanner.close();
    }
}
