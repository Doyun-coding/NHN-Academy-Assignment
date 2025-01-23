package player;

public class HighCardNode {
    private int number;
    private int number2;
    private String shape;

    public HighCardNode(int number, String shape) {
        this.number = number;
        this.shape = shape;
    }

    public HighCardNode(int number, int number2, String shape) {
        this.number = number;
        this.number2 = number2;
        this.shape = shape;
    }

    public int getNumber() {
        return this.number;
    }

    public int getNumber2() {
        return this.number2;
    }

    public String getShape() {
        return this.shape;
    }

}
