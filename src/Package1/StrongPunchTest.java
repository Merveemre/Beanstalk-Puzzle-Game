package Package1;

import java.util.Scanner;

public class StrongPunchTest {
    public static void main(String[] args) {
        // Oyunu başlat ve Man oluştur
        BeanstalkGame game = new BeanstalkGame(20, 20);
        game.initializeGame();
        Man man = new Man(0, 0, game);

        // Yumruk atma hareketini seç ve uygula
        StrongPunch strongPunch = new StrongPunch();
        strongPunch.applyMove(man);

        // Sonucu doğrula
        System.out.println("Current Location: (" + man.getX() + ", " + man.getY() + ")");
        System.out.println("Status: " + game.getGameState());
    }
}