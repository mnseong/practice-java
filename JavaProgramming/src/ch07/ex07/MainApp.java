package ch07.ex07;

import java.util.*;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Double> hash = new HashMap<String, Double>();
        System.out.println("미래장학금관리시스템입니다.");
        for (int i = 0; i < 5; i++) {
            System.out.print("이름과 학점>> ");
            String name = scanner.next();
            double score = scanner.nextDouble();
            hash.put(name, score);
        }
        System.out.print("장학생 선발 학점 기준 입력>> ");
        double cutline = scanner.nextDouble();
        scanner.nextLine();
        
        Set<String> keys = hash.keySet();
        Iterator<String> it = keys.iterator();
        ArrayList<String> s = new ArrayList<String>();
        
        while (it.hasNext()) {
            String cur = it.next();
            if (hash.get(cur) >= cutline)
                s.add(cur);
        }
        System.out.print("장학생 명단: ");
        for (int i = 0; i < s.size(); i++)
            System.out.print(s.get(i) + " ");
        scanner.close();
    }
}
