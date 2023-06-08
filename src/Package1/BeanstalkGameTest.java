package Package1;

import java.util.Scanner;

public class BeanstalkGameTest {

    public static void main(String[] args) {
        BeanstalkGame game = new BeanstalkGame(20, 20);
        game.play();
    }

    public static void simulateUserInput(BeanstalkGame game, String input) {
        Scanner scanner = new Scanner(input);
        while (scanner.hasNext()) {
            String directionStr = scanner.nextLine().toUpperCase();

            switch (directionStr) {
                case "W":
                    game.moveMan(Direction.UP, 0);
                    System.out.println("Moving UP...");
                    break;
                case "A":
                    game.moveMan(0, Direction.LEFT);
                    System.out.println("Moving LEFT...");
                    break;
                case "S":
                    game.moveMan(Direction.DOWN, 0);
                    System.out.println("Moving DOWN...");
                    break;
                case "D":
                    game.moveMan(0, Direction.RIGHT);
                    System.out.println("Moving RIGHT...");
                    break;
            }

            game.printMaze();
        }
    }
}
