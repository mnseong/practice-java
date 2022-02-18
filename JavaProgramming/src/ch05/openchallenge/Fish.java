package ch05.openchallenge;

class Fish extends GameObject {
    
    public Fish(int startX, int startY, int distance) {
        super(startX, startY, distance);
    }
    
    @Override
    public void move() {
        int a = (int)(Math.random()*5);
        if (a >= 0 && a <=1) {
            int b = (int)(Math.random()*4);
            switch (b) {
                case 0 :
                    if (y > 0)
                        y -= distance;
                    break;
                case 1 :
                    if (x < 9)
                        x += distance;
                    break;
                case 2 :
                    if (x > 0)
                        x -= distance;
                    break;
                case 3 :
                    if (y < 19)
                        y += distance;
                    break;
            }
        }
    }
    @Override
    public char getShape() {
        return '@';
    }
}