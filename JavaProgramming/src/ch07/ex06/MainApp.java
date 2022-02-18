package ch07.ex06;

import java.util.*;

public class MainApp {
    private HashMap<String, Location> hash = new HashMap<String, Location>();
    Set<String> keys = hash.keySet();
    
    boolean search(String cityName) {
        if (hash.get(cityName) == null)
            return false;
        Location l = hash.get(cityName);
        l.showInfo();
        return true;
    }
    
    void showHash() {
        Iterator<String> it = keys.iterator();
        while (it.hasNext()) {
            String cn = it.next();
            Location l = hash.get(cn);
            l.showInfo();
        }
    }
    
    void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("도시, 경도, 위도를 입력하세요.");
        for (int i = 0; i < 4; i++) {
            System.out.print(">> ");
            String info = scanner.nextLine();
            String[] infoArray = info.split(", ");
            Location l = new Location(infoArray[0], Integer.parseInt(infoArray[1]), Integer.parseInt(infoArray[2]));
            hash.put(infoArray[0], l);
        }
        System.out.println("---------------------------");
        showHash();
        System.out.println("---------------------------");
        while (true) {
            System.out.print("도시 이름>> ");
            String input = scanner.nextLine();
            if (input.equals("그만"))
                break;
            if (!search(input))
                System.out.println(input + "는(은) 없습니다.");
        }
    }
    
    public static void main(String[] args) {
        MainApp app = new MainApp();
        app.run();
    }
}
