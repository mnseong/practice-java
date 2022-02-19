package ch08.openchallenge;

import java.util.*;
import java.io.*;

public class Words {
    private Vector<String> wordVector = new Vector<String>();
    
    public Words(String fname) {
        try {
            Scanner scanner = new Scanner(new FileReader(fname));
            while (scanner.hasNext()) {
                String word = scanner.nextLine();
                wordVector.add(word);
            }
            scanner.close();
        } catch (FileNotFoundException e) { // 예외처리 신경쓰기...
            System.out.println("cannot found!!");
            System.exit(0);
        }
    }
    
    String getWord() {
        int idx = (int)(Math.random() * wordVector.size());
        return wordVector.get(idx);
    }
}
