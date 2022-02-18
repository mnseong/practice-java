package ch06.ex09;

public class Player {
    private String state;
    boolean isWinner = false;
    
    public Player() {}
    void setState(int n) {
        switch (n) {
            case 1 :
                state = "가위";
                break;
            case 2 :
                state = "바위";
                break;
            case 3 :
                state = "보";
                break;
        }
    }
    String getState() {
        return state;
    }
    void checkWin(Player[] p) {
        String a = p[0].getState(); // User
        String b = p[1].getState(); // Com
        if (a.equals("가위")) {
            switch (b) {
                case "가위" :
                    System.out.println("서로 비겼습니다.");
                    break;
                case "바위" :
                    System.out.println("컴퓨터가 이겼습니다.");
                    break;
                case "보" :
                    System.out.println("철수가 이겼습니다.");
                    break;
            }
        } else if (a.equals("바위")) {
            switch (b) {
                case "가위" :
                    System.out.println("철수가 이겼습니다.");
                    break;
                case "바위" :
                    System.out.println("서로 비겼습니다.");
                    break;
                case "보" :
                    System.out.println("컴퓨터가 이겼습니다.");
                    break;
            }
        } else {
            switch (b) {
                case "가위" :
                    System.out.println("컴퓨터가 이겼습니다.");
                    break;
                case "바위" :
                    System.out.println("철수가 이겼습니다.");
                    break;
                case "보" :
                    System.out.println("서로 비겼습니다.");
                    break;
            }
        }
    }
}
