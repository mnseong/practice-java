package ch07.ex05;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class MainApp {
    private ArrayList<Student> sList = new ArrayList<Student>();
    
    void search(String name) {
        Iterator<Student> it = sList.iterator();
        while (it.hasNext()) {
            Student std = it.next();
            if (std.getName().equals(name)) {
                std.showInfo();
                break;
            }
        }
    }
    
    void showList() {
        Iterator<Student> it = sList.iterator();
        while (it.hasNext()) {
            Student cur = it.next();
            System.out.println("이름: " + cur.getName());
            System.out.println("학과: " + cur.getMajor());
            System.out.println("학번: " + cur.getNum());
            System.out.println("학점평균: " + cur.getScore());
            System.out.println("********************************");
        }
    }
    
    void run() {
        System.out.println("학생 이름, 학과, 학번, 학점평균 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            System.out.print(">> ");
            String s = scanner.nextLine();
            String[] sa = s.split(", ");
            Student tmp = new Student(sa[0], sa[1], Integer.parseInt(sa[2]), Double.parseDouble(sa[3]));
            sList.add(tmp);
        }
        System.out.println("********************************");
        showList();
        
        while (true) {
            System.out.print("학생 이름 >> ");
            String name = scanner.nextLine();
            if (name.equals("그만"))
                break;
            search(name);
        }
    }
    
    public static void main(String[] args) {
        MainApp app = new MainApp();
        app.run();
    }
}
