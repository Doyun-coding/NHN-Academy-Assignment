package card;

public class Hart extends Card {
    public Hart(int number) {
        this.number = number;
        this.displayNumber = setDisplayNumber(number);
        this.rank = 3;
    }

    @Override
    public String getShape() {
        return "Hart";
    }
}
