package Package1;

public class Shovel extends Item {
    public Shovel(int x, int y) {
        super(x, y);
    }

    public char getSymbol() {
        return 'S';
    }
    @Override
    public boolean isPushableItem(int newManX, int newManY) {
        return true;
    }

}
