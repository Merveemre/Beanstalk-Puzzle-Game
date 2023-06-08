package Package1;

import java.util.Scanner;

public abstract class Game {
    protected int x, y;

    public Game(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public abstract void play();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Click Enter to Play");
        scanner.nextLine();
        Game game = new BeanstalkGame(20, 20);
        game.play();
    }

    public abstract void initializeGame();

    public abstract String getGameState();

    public abstract void moveItem(int nextX, int nextY, int next2X, int next2Y);

    public abstract boolean isPushableItem(int newManX, int newManY);

    public void pushItem(int dx, int dy) {
        // Yeni adam konumu
        int newManX = getX() + dx;
        int newManY = getY() + dy;

        // Yeni konumda itilebilir bir obje var mı kontrol et
        if (isPushableItem(newManX, newManY)) {
            // İtemi itme işlemini gerçekleştir
            int newItemX = newManX + dx;
            int newItemY = newManY + dy;
            moveItem(newManX, newManY, newItemX, newItemY);

            // Adamın konumunu güncelle
            setX(newManX);
            setY(newManY);
        } else {
            // İtme işlemi yapılamıyorsa sadece adamın konumunu güncelle
            setX(newManX);
            setY(newManY);
        }
    }

    public abstract void pushItem(int newManX, int newManY, int dx, int dy);
}
