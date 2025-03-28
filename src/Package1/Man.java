package Package1;

import java.util.Scanner;

public class Man extends Cell {
    private int moveCount;
    private int stepCount;
    private Move currentSpecialMove; // Geçerli özel hareket

    public BeanstalkGame game;

    public Man(int x, int y, BeanstalkGame game) {
        super(x, y);
        moveCount = 0;
        stepCount = 0;
        this.game = game;
    }

    @Override
    public char getSymbol() {
        return 'M';
    }

    public void performMove() {
        Scanner scanner = new Scanner(System.in);
        moveCount++;
        stepCount++;

        if (stepCount % 10 == 0) {
            // Özel hareketin kontrolü
            if (currentSpecialMove != null) {
                currentSpecialMove.applyMove(this);
                return;
            }

            // Yeni hareket seçimi
            if (moveCount % 10 == 0) {
                currentSpecialMove = selectSpecialMove();
                if (currentSpecialMove != null) {
                    currentSpecialMove.applyMove(this);
                    return;
                }
            }
        }

        game.play();
    }

    public Move selectSpecialMove() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("You have unlocked a new move! Select your move:\n1: Run \n2: Slide \n3: Strong Punch \n4: Strong Push \n5: Pull");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                return new Run();
            case 2:
                return new Slide();
            case 3:
                return new StrongPunch();
            case 4:
                return new StrongPush();
            case 5:
                return new Pull();
            default:
                return null;
        }
    }

    public void moveMan(int dx, int dy) {
        int newManX = getX() + dx;
        int newManY = getY() + dy;

        // Yeni pozisyonun kontrolü
        if (!game.isWall(newManX, newManY)) {
            // Obje var mı kontrol et
            if (game.isItem(newManX, newManY)) {
                // Objenin itilebilir olup olmadığını kontrol et
                if (game.isPushableItem(newManX, newManY)) {
                    // Obje itme işlemi
                    game.pushItem(newManX, newManY, dx, dy);
                }
            } else {
                // Karakteri hareket ettir
                game.setX(newManX);
                game.setY(newManY);
            }
        }
    }
}
