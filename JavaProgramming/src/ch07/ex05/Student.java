package ch07.ex05;

class Student {
    private String name, major;
    private int num;
    private double avgScore;
    
    public Student(String name, String major, int num, double avgScore) {
        this.name = name; this.major = major; this.num = num; this.avgScore = avgScore;
    }
    String getName() { return name; }
    String getMajor() { return major; }
    int getNum() { return num; }
    double getScore() { return avgScore; }
    void showInfo() {
        System.out.println(name + ", " + major + ", " + num + ", " + avgScore);
    }
}
