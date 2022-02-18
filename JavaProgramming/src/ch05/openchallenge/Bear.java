package ch05.openchallenge;

import java.util.Scanner;

class Bear extends GameObject {
    
    public Bear(int startX, int startY, int distance) {
        super(startX, startY, distance);
    }
    
    @Override
    public void move() {
        System.out.print("왼쪽(a), 아래(s), 위(d), 오른쪽(f) >> ");
        Scanner scanner = new Scanner(System.in);
        char direction = scanner.nextLine().charAt(0);
        switch (direction) {
            case 'a' :
                if (y > 0)
                    y -= distance;
                break;
            case 's' :
                if (x < 9)
                    x += distance;
                break;
            case 'd' :
                if (x > 0)
                    x -= distance;
                break;
            case 'f' :
                if (y < 19)
                    y += distance;
                break;
            default :
                System.out.println("Error!");
        }
    }
    @Override
    public char getShape() {
        return 'B';
    }
}
