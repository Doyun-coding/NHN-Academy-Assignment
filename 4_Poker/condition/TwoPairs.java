package condition;

import card.*;
import player.Player;

import java.util.ArrayList;

public class TwoPairs {
    private ArrayList<Card> cards;
    private Player player;

    public TwoPairs(ArrayList<Card> cards, Player player) {
        this.cards = cards;
        this.player = player;
    }

    public boolean isTwoPairs() {
        int cnt = 0;
        int[] count = new int[16];
        Card[] arr = new Card[2];

        for(int i = 0; i < 5; i++) {
            int number = cards.get(i).getNumber();
            count[number]++;
            if(count[number] == 2) {

                if(cards.get(i).getRank() == 1) {
                    arr[cnt] = new Spade(cards.get(i).getNumber());
                }
                else if(cards.get(i).getRank() == 2) {
                    arr[cnt] = new Diamonds(cards.get(i).getNumber());
                }
                else if(cards.get(i).getRank() == 3) {
                    arr[cnt] = new Hart(cards.get(i).getNumber());
                }
                else if(cards.get(i).getRank() == 4) {
                    arr[cnt] = new Clover(cards.get(i).getNumber());
                }

                cnt++;
            }
        }

        if(cnt == 2) {
            if(arr[0].getNumber() > arr[1].getNumber()) {
                player.setHighCard(arr[0], arr[1]);
            }
            else {
                player.setHighCard(arr[1], arr[0]);
            }

            return true;
        }

        return false;
    }

}
