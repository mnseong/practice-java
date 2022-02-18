package ch03;

import java.util.Scanner;
import java.util.Random;

public class UpDown {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char restart = 'n';
        do {
            // System.out.print("정답 숫자를 입력하시오: ");
            // int ans = s.nextInt();
            Random r = new Random();
            int ans = r.nextInt(100);
            System.out.println("수를 결정하였습니다. 맞추어 보세요");
            System.out.println("0-99");
            int cnt = 1;
            int max = 99, min = 1;
            while (true) {
                System.out.print(cnt + ">>");
                int num = scanner.nextInt();

                if (num > ans) {
                    max = Math.min(max,num);
                    System.out.println("더 낮게");
                    System.out.println(min + "-" + max);
                } else if (num < ans) {
                    min = Math.max(min, num);
                    System.out.println("더 높게");
                    System.out.println(min + "-" + max);
                } else {
                    System.out.println("맞았습니다.");
                    break;
                }
                cnt++;
            }
            System.out.print("다시 하시겠습니까(y/n)>>");
            restart = scanner.next().charAt(0);
        } while (restart == 'y');
        scanner.close();
    }
}