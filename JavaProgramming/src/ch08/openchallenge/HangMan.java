package ch08.openchallenge;

import java.util.*;
import java.io.*;

public class HangMan {
    private String answer;
    private StringBuffer blankWord;
    private Scanner scanner;
    
    public HangMan() {
        scanner = new Scanner(System.in); // 생성자에서 객체 생성
    }
    
    private void makeBlank() {
        blankWord = new StringBuffer(answer);
        Random r = new Random();
        for (int i = 0; i < 2; i++) {
            int idx = r.nextInt(answer.length());
            char c = answer.charAt(idx);
            for (int j = 0; j < answer.length(); j++) {
                if (blankWord.charAt(j) == c)
                    blankWord.setCharAt(i, '-');
            }
        }
    }
    
    void run() {
        System.out.println("지금부터 행맨 게임을 시작합니다.");
        Words words = new Words("/workspace/practice-java/JavaProgramming/txt/words.txt");
        while (true) {
            answer = words.getWord();
            if (answer == null) break;
            makeBlank();
            char key;
            int failcnt = 0;
            loop : while (true) {
                if (failcnt == 5) {
                    System.out.println("5번 실패 하였습니다.");
                    break;
                }
                System.out.println(blankWord);
                System.out.print(">>");
                String text = scanner.next();
                key = text.charAt(0);
                boolean check = false;
                boolean complete = false;
                for (int i = 0; i < answer.length(); i++) {
                    if (blankWord.charAt(i) == '-' && answer.charAt(i) == key) {
                        blankWord.setCharAt(i, key);
                        check = true;
                    }
                }
                if (!check)
                    failcnt++;
                for (int i = 0; i < answer.length(); i++) {
                    if (blankWord.charAt(i) == '-')
                        continue loop;
                }
                complete = true;
                break;
            }
            System.out.println(answer);
            System.out.print("Next(y/n)?");
            String s = scanner.next();
            if (s.equals("n")) break;
        }
    }
}
