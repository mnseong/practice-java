package ch06.ex11;

import java.util.Scanner;

public class ModifyString {
    public static void main(String[] args) {
        System.out.print(">>");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        
        while (true) {
            System.out.print("명령: ");
            
            String command = scanner.nextLine();
            String[] words = command.split("!");
            
            if (command.equals("그만")) {
                System.out.println("종료합니다.");
                break;
            }
            if (words[0].equals("") || words[1].equals("")) {
                System.out.println("잘못된 명령입니다!");
                continue;
            } else if (!s.contains(words[0])) {
                System.out.println("찾을 수 없습니다!");
                continue;
            }
            
            StringBuffer sb = new StringBuffer(s);
            int start = sb.indexOf(words[0]);
            int end = start + words[0].length();
            sb = sb.replace(start, end, words[1]);
            s = sb.toString();
            System.out.println(s);
        }
        scanner.close();
    }
}
