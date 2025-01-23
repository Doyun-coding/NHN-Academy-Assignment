package card;

public class Clover extends Card {
    public Clover(int number) {
        this.number = number;
        this.displayNumber = setDisplayNumber(number);
        this.rank = 4;
    }

    @Override
    public String getShape() {
        return "Clover";
    }
}
