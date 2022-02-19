package ch08.ex11;

import java.util.*;
import java.io.*;

public class WordReader {
    public Vector<String> wordVector = new Vector<String>();
    
    public WordReader(String fname) {
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
}
