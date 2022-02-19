package ch08.ex13ex14;

import java.io.*;
import java.util.*;

public class MainApp {
    private Scanner scanner;
    
    void run() {
        FileTask task = new FileTask("c:\\");
        File dir = task.curDir;
        scanner = new Scanner(System.in);
        System.out.println("***** 파일 탐색기입니다. *****");
        task.showSubDir();
        StringTokenizer st;
        
        while (true) {
            System.out.print(">>");
            st = new StringTokenizer(scanner.nextLine().trim(), " ");
            String command = st.nextToken();
            if (command.equals("그만")) break;
            if (command.equals("..")) {
                String s = dir.getParent();
                if (s == null) continue; // 최상위 directory일 경우
                else {
                    dir = new File(task.curDir.getParent());
                    task.showSubDir();
                }
            } else if (command.equals("rename")){
                try {
                    String now = st.nextToken();
                    String change = st.nextToken();
                    
                    File f = new File(dir.getPath() + "\\" + now);
                    if (!f.exists())
                        System.out.println("존재 하지 않는 파일입니다.");
                    else {
                        f.renameTo(new File(dir.getPath() + "\\" + change));
                    }
                    task.showSubDir();
                } catch(NoSuchElementException e) {
                    System.out.println("두 개의 파일명이 주어지지 않았습니다!");
                }
            } else if (command.equals("mkdir")) {
                String name = st.nextToken();
                File f = new File(dir.getPath() + "\\" + name);
                if (!f.exists()) {
                    f.mkdir();
                    System.out.println(name + " 디렉터리를 생성하였습니다.");
                }
                task.showSubDir();
            } else {
                if (task.contains(command)) {
                    if (new File(dir, command).isDirectory()) {
                        task.curDir = new File(dir, command);
                        task.showSubDir();
                    } else
                        System.out.println("\t디렉터리가 아닙니다..!");
                }
            }
        }
        scanner.close();
    }
    
    public static void main(String[] args) {
        MainApp app = new MainApp();
        app.run();
    }
}