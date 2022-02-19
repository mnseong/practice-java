package ch08.ex12;

import java.io.*;
import java.util.*;

public class MainApp {
    private Scanner scanner;
    private FileReader reader;
    private Vector<String> strVector;
    
    public MainApp() {
        scanner = new Scanner(System.in);
        strVector = new Vector<String>();
    }
    
    void run() {
        System.out.println("전체 경로명이 아닌 파일 이름만 입력하는 경우, 파일은 프로젝트 폴더에 있어야 합니다.");
        System.out.print("대상 파일명 입력>>");
        String fname = scanner.next();
        try {
            Scanner fileScanner = new Scanner(new FileReader(fname));
            while (fileScanner.hasNext()) {
                String str = fileScanner.nextLine();
                strVector.add(str);
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("cannot found!!");
            System.exit(0);
        }
        
        while (true) {
            System.out.print("검색할 단어나 문장>> ");
            String s = scanner.next();
            boolean find = false;
            if (s.equals("그만"))
                break;
            for (int i = 0; i < strVector.size(); i++) {
                String tmp = strVector.get(i);
                if (tmp.indexOf(s) != -1) {
                    find = true;
                    System.out.printf("%d:\t%s\n", i, tmp);
                }
            }
            if (!find)
                System.out.println("발견할 수 없음.");
        }
        System.out.println("프로그램을 종료합니다.");
        scanner.close();
    }
    
    public static void main(String[] args) {
        MainApp app = new MainApp();
        app.run();
    }
}
