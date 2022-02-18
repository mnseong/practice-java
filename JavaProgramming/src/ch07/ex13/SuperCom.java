package ch07.ex13;

import java.util.*;

public class SuperCom {
    private HashMap<String, Integer> hash = new HashMap<String, Integer>();
    private Vector<Instruction> readyQueue = new Vector<Instruction>();
    private Scanner scanner = new Scanner(System.in);
    
    void createProcess() {
        while (true) {
            System.out.print(">> ");
            String process = scanner.nextLine();
            if (process.toUpperCase().equals("GO"))
                break;
            readyQueue.add(new Instruction(process));
        }
    }
    
    int convertInt(String s) {
        int n;
        try {
            n = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            Integer a = hash.get(s);
            if (a == null) {
                hash.put(s, 0);
                n = 0;
            } else {
                n = a;
            }
        }
        return n;
    }
    
    void init() {
        readyQueue.removeAllElements();
        hash.clear();
    }
    
    void mov(Instruction instruction) {
        String s1 = instruction.getOperand(0);
        String s2 = instruction.getOperand(1);
        int n = convertInt(s2);
        hash.put(s1, n);
    }
    
    void add(Instruction instruction) {
        String s1 = instruction.getOperand(0);
        String s2 = instruction.getOperand(1);
        int n = convertInt(s1);
        int m = convertInt(s2);
        hash.put(s1, n + m);
    }
    
    void sub(Instruction instruction) {
        String s1 = instruction.getOperand(0);
        String s2 = instruction.getOperand(1);
        int n = convertInt(s1);
        int m = convertInt(s2);
        hash.put(s1, n - m);
    }
    
    int jn(Instruction instruction) {
        String s1 = instruction.getOperand(0);
        String s2 = instruction.getOperand(1);
        int n = convertInt(s1);
        int m = convertInt(s2);
        if (n != 0)
            return m;
        else
            return -1;
    }
    
    void prt(Instruction instruction) {
        String s = instruction.getOperand(0);
        int n = convertInt(s);
        printVar(instruction);
        System.out.printf("출력할 결과는 %d. 프로그램 실행 끝\n", n);
    }
    
    void printVar(Instruction instruction) {
        System.out.println(instruction);
        Set<String> keys = hash.keySet();
        Iterator<String> it = keys.iterator();
        while (it.hasNext()) {
            String var = it.next();
            int n = hash.get(var);
            System.out.printf("%s:%d\t", var, n);
        }
        System.out.println();
    }
    
    void exe() {
        int pc = 0; // program counter
        while (true) {
            Instruction instruction = readyQueue.get(pc);
            pc++;
            switch (instruction.getCom()) {
                case "MOV" :
                    mov(instruction);
                    break;
                case "ADD" :
                    add(instruction);
                    break;
                case "SUB" :
                    sub(instruction);
                    break;
                case "JN0" :
                    int next = jn(instruction);
                    if (next == -1)
                        break;
                    else {
                        pc = next;
                        break;
                    }
                case "PRT" :
                    prt(instruction);
                    return;
            }
        }
    }
    
    void run() {
        System.out.println("수퍼컴이 작동합니다. 프로그램을 입력해주세요. GO를 입력하면 작동합니다.");
        while (true) {
            createProcess();
            exe();
            init();
        }
    }
    
    public static void main(String[] args){
        SuperCom com = new SuperCom();
        com.run();
    }
}
