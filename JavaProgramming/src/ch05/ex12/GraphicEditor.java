package ch05.ex12;

import java.util.Scanner;

public class GraphicEditor {
    Scanner scanner = new Scanner(System.in);
    
    private Shape head, tail;
    
    public void run() {
        System.out.println("그래픽 에디터 beauty을 실행합니다.");
        int menuNum;
        loop : while (true) {
            System.out.print("삽입(1), 삭제(2), 모두 보기(3), 종료(4)>>");
            menuNum = scanner.nextInt();
            scanner.nextLine();
            switch (menuNum) {
                case 1 :
                    System.out.print("Line(1), Rect(2), Circle(3)>>");
                    int shapeNum = scanner.nextInt();
                    scanner.nextLine();
                    insert(shapeNum);
                    break;
                case 2 :
                    System.out.print("삭제할 도형의 위치>>");
                    int idx = scanner.nextInt();
                    scanner.nextLine();
                    delete(idx);
                    break;
                case 3 :
                    show();
                    break;
                case 4 :
                    System.out.println("beauty을 종료합니다.");
                    break loop;
            }
        }
        scanner.close();
    }
    
    private void insert(int n) {
        Shape obj;
        switch (n) {
            case 1 :
                obj = new Line();
                if (head == null) {
                    head = obj;
                    tail = obj;
                } else {
                    tail.setNext(obj);
                    tail = obj;
                } break;
            case 2 :
                obj = new Rect();
                if (head == null) {
                    head = obj;
                    tail = obj;
                } else {
                    tail.setNext(obj);
                    tail = obj;
                } break;
            case 3 :
                obj = new Circle();
                if (head == null) {
                    head = obj;
                    tail = obj;
                } else {
                    tail.setNext(obj);
                    tail = obj;
                } break;
        }
    }
    public void delete(int n) {
        Shape cur = head;
        Shape prev = head;
        
        try {
            if (cur == null) {
                System.out.println("삭제할 수 없습니다.");
                return;
            }
            if (n < 1) {
                System.out.println("잘못된 값을 입력하셨습니다.");
                return;
            } else if (n == 1) {
                if (head == tail){
                    cur = null;
                } else {
                    head = head.getNext();
                    return;
                }
            } else if (n > 1) {
                if (cur != null) {
                    for (int i = 1; i < n; i++){
                        prev = cur;
                        cur = cur.getNext();
                    }
                }
                if (cur == tail) {
                    tail = prev;
                    tail.setNext(null);
                } else {
                    prev.setNext(cur.getNext());
                }    
            }
        } catch (NullPointerException e) {
            System.out.println("삭제할 수 없습니다.");
        }
    }
    
    private void show() {
        Shape p = head;
        while (p != null) {
            p.draw();
            p = p.getNext();
        }
    }
}