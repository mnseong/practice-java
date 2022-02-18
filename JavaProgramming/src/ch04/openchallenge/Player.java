package ch04.openchallenge;

import java.util.Scanner;

class Player {
    String name, nowWord;
    
    public Player(String name) {
        this.name = name;
    }
    
    void getWordFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("%s>>", this.name);
        this.nowWord = scanner.nextLine();
    }
    
    boolean checkSuccess(String prevWord) {
        if (this.nowWord.charAt(0) != prevWord.charAt(prevWord.length() - 1))
            return false;
        return true;
    }
}