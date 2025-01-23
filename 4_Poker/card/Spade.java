package card;

public class Spade extends Card {
    public Spade(int number) {
        this.number = number;
        this.displayNumber = setDisplayNumber(number);
        this.rank = 1;
    }

    @Override
    public String getShape() {
        return "Spade";
    }
}
