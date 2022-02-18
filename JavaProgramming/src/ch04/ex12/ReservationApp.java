package ch04.ex12;

import java.util.Scanner;

public class ReservationApp {
    
    public static void main(String[] args) {
        System.out.println("명품콘서트홀 예약 시스템입니다.");
        
        Seat[][] seatTable = new Seat[3][10];
        for (int i = 0; i < 10; i++) {
            seatTable[0][i] = new Seat('S', i+1);
            seatTable[1][i] = new Seat('A', i+1);
            seatTable[2][i] = new Seat('B', i+1);
        }
        
        int menuNum;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            do {
                System.out.print("예약: 1, 조회: 2, 취소: 3, 끝내기: 4>>");
                menuNum = scanner.nextInt();
                scanner.nextLine();
                if (menuNum > 4)
                    System.out.println("메뉴 번호를 확인하시고 다시 입력해주세요!");
            } while (menuNum > 4);
            
            if (menuNum == 4)
                break;
            
            if (menuNum == 1) {
                Menu.reservation(seatTable);
            } else if (menuNum == 2) {
                Menu.inquiry(seatTable);
            } else if (menuNum == 3) {
                Menu.cancel(seatTable);
            }
        }
        scanner.close();
    }
}