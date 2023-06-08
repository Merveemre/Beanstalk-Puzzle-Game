package Package1;
import java.util.Scanner;

public class SlideTest {
    public static void main(String[] args) {
        // Oyunu başlat ve Man objesini oluştur
        BeanstalkGame game = new BeanstalkGame(20,20);
        game.initializeGame();
        Man man = new Man(0, 0, game);

        // Hareketi seç ve uygula
        Slide slide = new Slide();
        slide.applyMove(man);

        // Sonucu doğrula
        System.out.println("Current Location: (" + man.getX() + ", " + man.getY() + ")");
        System.out.println("Status: " + game.getGameState());
    }
}
