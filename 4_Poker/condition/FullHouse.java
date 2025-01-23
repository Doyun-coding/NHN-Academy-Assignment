package condition;

import card.*;
import player.Player;

import java.util.ArrayList;

public class FullHouse {
    private ArrayList<Card> cards;
    private Player player;

    public FullHouse(ArrayList<Card> cards, Player player) {
        this.cards = cards;
        this.player = player;
    }

    public boolean isFullHouse() {
        int[] count = new int[16];

        for(int i = 0; i < 5; i++) {
            int number = cards.get(i).getNumber();
            count[number]++;
        }

        boolean onePair = false;
        boolean triPair = false;
        int one = 0;
        int tri = 0;
        for(int i = 2; i <= 15; i++) {
            if(count[i] == 2) {
                onePair = true;
                one = i;
            }
            if(count[i] == 3) {
                triPair = true;
                tri = i;
            }
        }

        if(onePair && triPair) {
            Card[] arr = new Card[2];

            for(int i = 0; i < 5; i++) {
                if(one == cards.get(i).getNumber()) {

                    if(cards.get(i).getRank() == 1) {
                        arr[0] = new Spade(cards.get(i).getNumber());
                    }
                    else if(cards.get(i).getRank() == 2) {
                        arr[0] = new Diamonds(cards.get(i).getNumber());
                    }
                    else if(cards.get(i).getRank() == 3) {
                        arr[0] = new Hart(cards.get(i).getNumber());
                    }
                    else if(cards.get(i).getRank() == 4) {
                        arr[0] = new Clover(cards.get(i).getNumber());
                    }

                }

                if(tri == cards.get(i).getNumber()) {

                    if(cards.get(i).getRank() == 1) {
                        arr[1] = new Spade(cards.get(i).getNumber());
                    }
                    else if(cards.get(i).getRank() == 2) {
                        arr[1] = new Diamonds(cards.get(i).getNumber());
                    }
                    else if(cards.get(i).getRank() == 3) {
                        arr[1] = new Hart(cards.get(i).getNumber());
                    }
                    else if(cards.get(i).getRank() == 4) {
                        arr[1] = new Clover(cards.get(i).getNumber());
                    }

                }
            }

            player.setHighCard(arr[1], arr[0]);

            return true;
        }

        return false;
    }

}
