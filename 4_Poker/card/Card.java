package card;

public abstract class Card implements Comparable<Card> {
    protected int number;
    protected String displayNumber;
    protected int rank;

    protected String setDisplayNumber(int number) {
        if(number == 2) {
            this.displayNumber = "2";
        }
        else if(number == 3) {
            this.displayNumber = "3";
        }
        else if(number == 4) {
            this.displayNumber = "4";
        }
        else if(number == 5) {
            this.displayNumber = "5";
        }
        else if(number == 6) {
            this.displayNumber = "6";
        }
        else if(number == 7) {
            this.displayNumber = "7";
        }
        else if(number == 8) {
            this.displayNumber = "8";
        }
        else if(number == 9) {
            this.displayNumber = "9";
        }
        else if(number == 10) {
            this.displayNumber = "10";
        }
        else if(number == 11) {
            this.displayNumber = "J";
        }
        else if(number == 12) {
            this.displayNumber = "Q";
        }
        else if(number == 14) {
            this.displayNumber = "K";
        }
        else if(number == 15) {
            this.displayNumber = "A";
        }

        return this.displayNumber;
    }

    @Override
    public int compareTo(Card o) {
        return this.rank - o.rank;
    }

    public int getNumber() {
        return this.number;
    }

    public String getDisplayNumber() {
        return this.displayNumber;
    }

    public int getRank() {
        return this.rank;
    }

    public abstract String getShape();
}
