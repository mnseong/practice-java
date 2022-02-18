package ch06.ex10ex12;

import java.util.Scanner;

public class GamblingGame {
    
    public GamblingGame() {}
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("갬블링 게임에 참여할 선수 숫자>>");
        int n = scanner.nextInt();
        scanner.nextLine();
        Person[] player = new Person[n];
        for (int i = 0; i < n; i++) {
            System.out.printf("%d번째 선수 이름>>", i + 1);
            String name = scanner.nextLine();
            player[i] = new Person(name);
        }
        
        loop : while (true) {
            for (Person p : player) {
                System.out.printf("[%s]:", p.getName());
                scanner.nextLine();
                p.setNum();
                p.showNum();
                if (p.isWinner()) {
                    System.out.println(p.getName() + "님이 이겼습니다!");
                    break loop;
                } else
                    System.out.println("아쉽군요!");
            }
        }
        scanner.close();
    }
}
