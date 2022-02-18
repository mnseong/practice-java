package ch07.ex10;

import java.util.*;

public class GraphicEditor {
    void run() {
        Scanner scanner = new Scanner(System.in);
        Vector<Shape> v = new Vector<Shape>();
        
        System.out.println("그래픽 에디터 beauty을 실행합니다.");
        loop : while (true) {
            System.out.print("삽입(1), 삭제(2), 모두 보기(3), 종료(4)>>");
            int menuNum = scanner.nextInt();
            scanner.nextLine();
            switch (menuNum) {
                case 1 :
                    System.out.print("Line(1), Rect(2), Circle(3)>>");
                    int shapeNum = scanner.nextInt();
                    scanner.nextLine();
                    Shape tmp;
                    switch (shapeNum) {
                        case 1 :
                            tmp = new Line();
                            v.add(tmp);
                            break;
                        case 2 :
                            tmp = new Rect();
                            v.add(tmp);
                            break;
                        case 3 :
                            tmp = new Circle();
                            v.add(tmp);
                            break;
                    }
                    break;
                case 2 :
                    System.out.print("삭제할 도형의 위치>>");
                    int idx = scanner.nextInt();
                    scanner.nextLine();
                    try {
                        v.remove(idx);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("삭제할 수 없습니다.");
                    }
                    break;
                case 3 :
                    Iterator<Shape> it = v.iterator();
                    while (it.hasNext()) {
                        Shape s = it.next();
                        s.draw();
                    }
                    break;
                case 4 :
                    System.out.println("beauty을 종료합니다.");
                    scanner.close();
                    break loop;
            }
        }
    }
    
    public static void main(String[] args) {
        GraphicEditor ge = new GraphicEditor();
        ge.run();
    }
}
