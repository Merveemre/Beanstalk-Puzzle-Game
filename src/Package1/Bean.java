package Package1;
public class Bean extends Item {
    public Bean(int x, int y) {
        super(x, y);
    }

    @Override
    public char getSymbol() {
        return 'B';
    }

    @Override
    public boolean isPushableItem(int newManX, int newManY) {
        return true;
    }

}
