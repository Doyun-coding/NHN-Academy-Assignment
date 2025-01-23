package io;

public class Output {
    private final String winMessage = "승리했습니다.";
    private final String lossMessage = "패배했습니다.";

    public void printWinMessage() {
        System.out.println(winMessage);
    }

    public void printLossMessage() {
        System.out.println(lossMessage);
    }

}
