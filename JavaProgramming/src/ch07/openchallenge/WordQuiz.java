package ch07.openchallenge;

import java.util.Scanner;
import java.util.Vector;

public class WordQuiz {
    private Vector<Word> v = new Vector<Word>();
    
    // 단어의 개수를 임의로 조정할 수 있도록 하는 메서드
    void settingWords() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("문제 은행을 만들 단어 수를 정하시오>> ");
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.print("영단어: ");
            String eng = scanner.nextLine();
            System.out.print("뜻: ");
            String kor = scanner.nextLine();
            v.add(new Word(eng, kor));
        }
        System.out.printf("현재 %d개의 단어가 들어 있습니다.\n", n);
        System.out.println("-1을 입력하면 종료합니다.");
    }
    
    boolean unitProcess(Word answer) {
        Scanner scanner = new Scanner(System.in);
        Vector<Word> wList = new Vector<Word>();
        int[] isUsed = new int[v.size()];
        
        while (wList.size() < 4) {
            int idx = (int)(Math.random() * v.size());
            if (v.get(idx) != answer && isUsed[idx] != -1) {
                wList.add(v.get(idx));
                isUsed[idx] = -1;
            }
        }

        int idx = (int)(Math.random() * 4);
        wList.add(idx, answer);
        
        System.out.println(answer.getEng() + "?");
        for (int i = 0; i < 4; i++)
            System.out.printf("(%d)%s ", i+1, wList.get(i).getKor());
        System.out.print(":>");
        int n = scanner.nextInt();
        scanner.nextLine();
        
        if (n == -1) {
            System.out.println("\"명품영어\"를 종료합니다...");
            return true;
        }
        if (answer.getKor().equals(wList.get(n-1).getKor()))
            System.out.println("Excellent!!");
        else
            System.out.println("No. !!");
        return false;
    }
    
    void run() {
        System.out.println("\"명품영어\"의 단어 테스트를 시작합니다.");
        settingWords();
        while (true) {
            int idx = (int)(Math.random() * v.size());
            Word answer = v.get(idx);
            boolean stop = unitProcess(answer);
            if (stop)
                break;
        }
    }
    
    public static void main(String[] args) {
        WordQuiz wq = new WordQuiz();
        wq.run();
    }
}
