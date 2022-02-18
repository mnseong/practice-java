package ch06.ex10ex12;

public class Person {
    private String name;
    private int[] number = new int[3];
    public Person(String name) {
        this.name = name;
    }
    String getName() {
        return name;
    }
    void setNum() {
        // for (int n : number) Java의 "advanced for문" 에서는 collection의 수정이 불가능
        //     n = (int)(Math.random()*3 + 1);
        for (int i = 0; i < number.length; i++)
            number[i] = (int)(Math.random()*3 + 1);
    }
    void showNum() {
        System.out.print("        ");
        for (int n : number)
            System.out.printf("%d ", n);
        System.out.print("  ");
    }
    boolean isWinner() {
        if (number[0] == number[1] && number[1] == number[2])
            return true;
        else return false;
    }
}
