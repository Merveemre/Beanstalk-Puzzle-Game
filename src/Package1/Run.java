package Package1;

import java.util.Scanner;
public class Run implements Move {
    @Override
    public void applyMove(Man man) {
        int dx = 0;
        int dy = 0;

        // Koordinat değişimleri
        if (man.game.isWall(man.getX() + 2, man.getY()))
            dx = 1;
        else if (man.game.isWall(man.getX() - 2, man.getY()))
            dx = -1;
        else if (man.game.isWall(man.getX(), man.getY() + 2))
            dy = 1;
        else if (man.game.isWall(man.getX(), man.getY() - 2))
            dy = -1;
        else if (man.game.isItem(man.getX() + 1, man.getY()) || man.game.isItem(man.getX() - 1, man.getY()))
            dx = 1;
        else if (man.game.isItem(man.getX(), man.getY() + 1) || man.game.isItem(man.getX(), man.getY() - 1))
            dy = 1;

        man.moveMan(2 * dx, 2 * dy);
    }
}
