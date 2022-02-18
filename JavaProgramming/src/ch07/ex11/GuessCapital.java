package ch07.ex11;

import java.util.*;

public class GuessCapital {
    private HashMap<String, String> hash;
    
    public GuessCapital() {
        hash = new HashMap<String, String>();
    }
    void push() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("현재 %d개 나라와 수도가 입력되어 있습니다.\n", hash.size());
        while (true) {
            System.out.printf("나라와 수도 입력%d>> ", hash.size() + 1);
            String country = scanner.next();
            if (country.equals("그만"))
                break;
            
            String capital = scanner.next();
            if (hash.containsKey(country))
                System.out.println(country + "는 이미 있습니다!");
            else
                hash.put(country, capital);
        }
    }
    void quiz() {
        Scanner scanner = new Scanner(System.in);
        Set<String> keys = hash.keySet();
        String[] countries = keys.toArray(new String[0]);
        while (true) {
            int i = (int)(Math.random()*hash.size());
            String cur = countries[i];
            System.out.print(cur + "의 수도는? ");
            String userAns = scanner.nextLine();
            String answer = hash.get(cur);
            if (userAns.equals("그만"))
                break;
            if (userAns.equals(answer))
                System.out.println("정답!!");
            else
                System.out.println("아닙니다!!");
        }
    }
}
