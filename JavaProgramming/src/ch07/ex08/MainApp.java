package ch07.ex08;

import java.util.*;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> hash = new HashMap<String, Integer>();
        System.out.println("** 포인트 관리 프로그램입니다 **");
        while (true) {
            System.out.print("이름과 포인트 입력>> ");
            String name = scanner.next();
            if (name.equals("그만"))
                break;
            int point = scanner.nextInt();
            scanner.nextLine();
            
            if (hash.containsKey(name))
                hash.put(name, hash.get(name) + point);
            else
                hash.put(name, point);
            
            Set<String> keys = hash.keySet();
            Iterator<String> it = keys.iterator();
            
            while (it.hasNext()) {
                String tmpName = it.next();
                int tmpPoint = hash.get(tmpName);
                System.out.printf("(%s, %d)", tmpName, tmpPoint);
            }
            System.out.println();
        }
        scanner.close();
    }
}
