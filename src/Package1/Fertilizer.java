package Package1;

public class Fertilizer extends Item {
    public Fertilizer(int x, int y) {
        super(x, y);
    }

    public char getSymbol() {
        return 'F';
    }

    @Override
    public boolean isPushableItem(int newManX, int newManY) {
        return true;
    }

}
