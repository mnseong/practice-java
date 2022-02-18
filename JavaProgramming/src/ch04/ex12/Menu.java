package ch04.ex12;

import java.util.Scanner;

class Menu {
    static void reservation(Seat[][] array) {
        Scanner scanner = new Scanner(System.in);
        
        int selectSeat;
        do {
            System.out.print("좌석구분 S(1), A(2), B(3)>>");
            selectSeat= scanner.nextInt();
            scanner.nextLine();
            if (selectSeat > 3)
                System.out.println("좌석 타입을 확인하시고 다시 입력해주세요!");
        } while(selectSeat > 3);
        
        System.out.printf("%c>>", array[selectSeat-1][0].getSeatType());
        for (int i = 0; i < array[0].length; i++ )
            System.out.printf(" %s", array[selectSeat-1][i].getName());
        System.out.println();
        
        System.out.print("이름>>");
        String tmpName = scanner.nextLine();
        
        int tmpNum;
        do {
            System.out.print("번호>>");
            tmpNum = scanner.nextInt();
            scanner.nextLine();
            if (tmpNum > 10)
                System.out.println("1~10까지의 좌석 번호를 입력해주세요!");
        } while(tmpNum > 10);
        array[selectSeat-1][tmpNum-1].setName(tmpName);
    }
    
    static void inquiry(Seat[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%c>>", array[i][0].getSeatType());
            for (int j = 0; j < array[i].length; j++ )
                System.out.printf(" %s", array[i][j].getName());
            System.out.println();
        }
        System.out.println("<<<조회를 완료하였습니다.>>>");
    }
    
    static void cancel(Seat[][] array) {
        Scanner scanner = new Scanner(System.in);
        int selectSeat;
        do {
            System.out.print("좌석구분 S(1), A(2), B(3)>>");
            selectSeat= scanner.nextInt();
            scanner.nextLine();
            if (selectSeat > 3)
                System.out.println("좌석 타입을 확인하시고 다시 입력해주세요!");
        } while(selectSeat > 3);
        
        System.out.printf("%c>>", array[selectSeat-1][0].getSeatType());
        for (int i = 0; i < array[0].length; i++ )
            System.out.printf(" %s", array[selectSeat-1][i].getName());
        System.out.println();
        
        loop : while (true) {
            System.out.print("이름>>");
            String tmpName = scanner.nextLine();
            
            boolean wrongName = true;
            for (int i = 0; i < array[0].length; i++ ) {
                if (array[selectSeat-1][i].getName().equals(tmpName)) {
                    array[selectSeat-1][i].setName("---");
                    wrongName = false;
                    break loop;
                }
            }
            if (wrongName)
                System.out.println("입력된 이름으로 예약된 자리가 없습니다. 다시 입력해주세요!");
        }
    }
}