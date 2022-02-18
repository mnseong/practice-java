package ch04.openchallenge;

import java.util.Scanner;

public class WordGameApp {
    static void run() {
        System.out.println("끝말잇기 게임을 시작합니다...");
        System.out.print("게임에 참가하는 인원은 몇명입니까>>");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine(); // nextInt 를 사용하고 남은 개행 입력값을 제거해주기 위해 사용.
        Player playerList[] = new Player[num];
        for (int i = 0; i < num; i++){
            System.out.print("참가자의 이름을 입력하세요>>");
            playerList[i] = new Player(scanner.nextLine());
        }
        String prevWord = "아버지";
        System.out.println("시작하는 단어는 아버지입니다");
        loop : while (true) {
            for (int i = 0; i < num; i++) {
                playerList[i].getWordFromUser();
                if (!playerList[i].checkSuccess(prevWord)) {
                    System.out.printf("%s이 졌습니다.", playerList[i].name);
                    break loop;
                }
                prevWord = playerList[i].nowWord;
            }
        }
        scanner.close();
    }
    
    public static void main(String[] args) {
        run();
    }
}