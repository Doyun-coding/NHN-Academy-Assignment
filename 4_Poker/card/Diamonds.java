package card;

public class Diamonds extends Card {
    public Diamonds(int number) {
        this.number = number;
        this.displayNumber = setDisplayNumber(number);
        this.rank = 2;
    }

    @Override
    public String getShape() {
        return "Diamonds";
    }
}
