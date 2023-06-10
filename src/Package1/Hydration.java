package Package1;

public class Hydration extends Item {
    public Hydration(int x, int y) {

        super(x, y);
    }

    @Override
    public char getSymbol() {

        return 'H';
    }
    @Override
    public boolean isPushableItem(int newManX, int newManY) {
        // Sulama nesnesi her zaman itilebilir olduğu için true döndürülür
        return true;
    }

}


