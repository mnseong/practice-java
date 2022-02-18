package ch06.openchallenge;

import java.util.Scanner;

public class MainApp {
    private String readString() {
        StringBuffer sb = new StringBuffer();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String line = scanner.nextLine();
            if (line.equals(";")) break;
            sb.append(line);
        }
        scanner.close();
        return sb.toString();
    }
    private void run() {
        System.out.println("영문 텍스트를 입력하고 세미콜론을 입력하세요.");
        String text = readString();
        Histogram h = new Histogram(text);
        h.show();
    }
    
    public static void main(String[] args) {
        MainApp app = new MainApp();
        app.run();
    }
}
