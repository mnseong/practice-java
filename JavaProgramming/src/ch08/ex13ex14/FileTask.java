package ch08.ex13ex14;

import java.io.*;
import java.util.*;

public class FileTask {
    File curDir;
    private File[] subFiles;
    
    public FileTask(String dirName) {
        curDir = new File(dirName);
    }
    
    void showSubDir() {
        System.out.printf("\t[%s]", curDir.getPath());
        subFiles = curDir.listFiles(); // directory 내의 파일과 subdir 리스트를 File 배열로 return
        for (File f : subFiles) {
            if (f.isFile())
                System.out.print("file");
            else
                System.out.print("dir");
            System.out.printf("%-15s", "\t\t" + f.length() + "바이트");
            System.out.println("\t\t" + f.getName());
        }
    }
    
    boolean contains(String fname) {
        for (File f : subFiles) {
            if (f.getName().equalsIgnoreCase(fname)) // 대소문자 구별없이 String 비교
                return true;
        }
        return false;
    }
}
