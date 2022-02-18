package ch07.ex13;

import java.util.StringTokenizer;

public class Instruction {
    private String process;
    private String command;
    private String[] operand = new String[2];
    
    public Instruction(String process) {
        this.process = process;
        process = process.toUpperCase();
        StringTokenizer tmp = new StringTokenizer(process);
        command = tmp.nextToken();
        operand[0] = tmp.nextToken();
        operand[1] = tmp.nextToken();
    }
    
    String getCom() {
        return command;
    }
    
    String getOperand(int i) {
        if (i < 0 || i > 2)
            return null;
        return operand[i];
    }
    
    public String toString() {
        return "[" + process + "]";
    }
}
