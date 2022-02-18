package ch05.ex13ex14;

public interface Shape {
    final double PI = 3.14;
    void draw();
    double getArea();
    default public void redraw() {
        System.out.print("--- 다시 그립니다. ");
        draw();
    }
}

class Circle implements Shape {
    private int radius;
    public Circle(int radius) {
        this.radius = radius;
    }
    @Override
    public void draw() {
        System.out.printf("반지름이 %d인 원입니다.\n", radius);
    }
    @Override
    public double getArea() {
        double ret = PI * radius * radius;
        return ret;
    }
}

class Oval implements Shape {
    private int majorAxis, minorAxis;
    public Oval(int majorAxis, int minorAxis) {
        this.majorAxis = majorAxis;
        this.minorAxis = minorAxis;
    }
    @Override
    public void draw() {
        System.out.printf("%dx%d에 내접하는 타원입니다.\n", majorAxis, minorAxis);
    }
    @Override
    public double getArea() {
        double ret = PI * majorAxis * minorAxis;
        return ret;
    }
}

class Rect implements Shape {
    private int x, y;
    public Rect(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public void draw() {
        System.out.printf("%dx%d크기의 사각형 입니다.\n", x, y);
    }
    @Override
    public double getArea() {
        double ret = x * y;
        return ret;
    }
}