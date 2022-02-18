package ch05.openchallenge;

public class MainGame {
    private static char gameMap[][] = new char[10][20];
    private GameObject[] objects = new GameObject[2];
    
    public MainGame() {
        init();
        objects[0] = new Bear(0, 0, 1);
        objects[1] = new Fish(5, 5, 1);
    }
    
    private void showMap() {
        System.out.println();
    	for(int i = 0; i < 10; i++) {
        	for(int j = 0; j < 20; j++)
            System.out.print(gameMap[i][j]);
            System.out.println();
    	}
	}
    
    private void setObjects() {
        gameMap[objects[1].getX()][objects[1].getY()] = objects[1].getShape();
        gameMap[objects[0].getX()][objects[0].getY()] = objects[0].getShape();
    }
    
    private void init() {
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 20; j++)
                gameMap[i][j] = '-';
    }
    
    public void run() {
        setObjects();
        showMap();
        
        while (true) {
            init();
            objects[0].move();
            objects[1].move();
            
            setObjects();
            
            showMap();
            
            if (objects[0].collide(objects[1])) {
                System.out.println("Bear Wins!!");
                break;
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println("** Bear의 Fish 먹기 게임을 시작합니다. **");
        MainGame game = new MainGame();
        game.run();
    }
}