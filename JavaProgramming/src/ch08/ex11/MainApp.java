package ch08.ex11;

import java.util.*;

public class MainApp {
    private Vector<String> v = new Vector<String>();
    private String path = "/workspace/practice-java/JavaProgramming/txt/words.txt";
    private Scanner scanner;
    
    public MainApp() {
        scanner = new Scanner(System.in);
    }
    
    private boolean search(String s) {
        Iterator<String> it = v.iterator();
        boolean contain = false;
        while (it.hasNext()) {
            String tmp = it.next();
            if (tmp.contains(s)) {
                System.out.println(tmp);
                contain = true;
            }
        }
        return contain;
    }
    
    private void run() {
        WordReader reader = new WordReader(path);
        v = reader.wordVector;
        System.out.printf("프로젝트 폴더 밑의 %s 파일을 읽었습니다...\n", path);
        scanner = new Scanner(System.in);
        while (true) {
            System.out.print("단어>>");
            String input = scanner.nextLine();
            if (input.equals("그만")) {
                System.out.println("종료합니다...");
                break;
            }
            if (!search(input))
                System.out.println("발견할 수 없음");
        }
    }
    
    public static void main(String[] args) {
        MainApp app = new MainApp();
        app.run();
    }
}
