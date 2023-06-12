package Package1;
import java.util.Scanner;
public class BeanstalkGame extends Game {
    private final int[][] maze;
    private int manX;
    private int manY;

    private boolean[][] bean;
    private boolean [][] shovel;
    private boolean [][] fertilizer;
    private boolean [][] hydration;
    private boolean [][] goal;


    public BeanstalkGame(int width, int height) {
        super(width, height);
        maze = new int[height][width];          // labirenti oluşturma
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                // ilk ve son satırı duvarla doldur
                // ilk ve son sütunu da duvarla doldur
                if (i == 0 || i == height - 1 || j == 0 || j == width - 1) {
                    maze[i][j] = 1;
                } else {
                    maze[i][j] = 0;
                }
            }
        }

        manX = 4;
        manY = 4;// adamın başlangıç pozisyonu

        bean = new boolean[height][width];
        bean[2][6] = true;

        shovel = new boolean[height][width];
        shovel[9][9] = true;

        fertilizer = new boolean[height][width];
        fertilizer [16][16] = true;

        hydration = new boolean[height][width];
        hydration[17][3] = true;

        goal = new boolean[height][width];
        goal [11][10] = true;

    }

    @Override
    public boolean isPushableItem(int newManX, int newManY) {
        return false;
    }


    public boolean isWall(int x, int y) {
        if (x < 0 || x >= maze[0].length || y < 0 || y >= maze.length) {
            // koordinatlar matrisin dışında mı
            return true;
        }
        return maze[y][x] == 1;
    }

    public void moveMan(int dx, int dy) {
        int newManX = manX + dx;
        int newManY = manY + dy;

        if (newManX >= 0 && newManX < maze[0].length && newManY >= 0 && newManY < maze.length && maze[newManY][newManX] == 0) {
            // maze.length satır sayısı,  maze[0].length sütun sayısı
            // Adamın yeni pozisyonu labirent sınırları içinde ve duvarla çakışmıyor mu

            // Öğe hareket ettirme işlemini gerçekleştir
            if (isItem(newManX, newManY)) {
                moveItem(newManX, newManY, newManX + dx, newManY + dy);
            }

            // Adamın yerini güncelle
            manX = newManX;
            manY = newManY;
        }
    }


    public void printMaze() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (i == manY && j == manX) {
                    System.out.print("M");
                } else if (maze[i][j] == 1) {
                    System.out.print("#");
                } else if (bean[i][j]) {
                    System.out.print("B");
                }else if (shovel[i][j]) {
                    System.out.print("S");
                }else if (fertilizer[i][j]) {
                    System.out.print("F");
                }else if (hydration[i][j]) {
                    System.out.print("H");
                }else if (goal[i][j]) {
                    System.out.print("X");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        System.out.println("M:man, X:goal, S:shovel, B:bean, F:fertilizer, H:hydration");
    }

    public boolean isItem(int x, int y) {
        return bean[x][y] || shovel[x][y] || fertilizer[x][y] || hydration[x][y] || goal[x][y];
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printMaze();
            System.out.println("Move the man by using w (up), s (down), a (left), d (right) keys and push the items to the goal:");
            String directionStr = scanner.nextLine().toUpperCase();

            switch (directionStr) {
                case "W":
                    moveMan(0, -1);
                    System.out.println("Moving UP...");
                    break;
                case "A":
                    moveMan(-1, 0);
                    System.out.println("Moving LEFT...");
                    break;
                case "S":
                    moveMan(0, 1);
                    System.out.println("Moving DOWN...");
                    break;
                case "D":
                    moveMan(1, 0);
                    System.out.println("Moving RIGHT...");
                    break;

            }
        }
    }



    @Override
    public void moveItem(int nextX, int nextY, int next2X, int next2Y) {

    }

    @Override
    public void pushItem(int newManX, int newManY, int dx, int dy) {

    }


    public int getManX() {
        return manX;
    }
    public int getManY() {
        return manY;
    }

}

