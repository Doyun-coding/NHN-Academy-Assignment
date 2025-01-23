package dealer;

import card.*;

import java.util.ArrayList;
import java.util.Collections;

public class Dealer {
    private ArrayList<Card> cards;

    public Dealer() {
        this.cards = new ArrayList<>();
    }

    public ArrayList<Card> settingCards() {
        for(int i = 1; i <= 4; i++) {
            if(i == 1) {
                for(int j = 2; j <= 15; j++) {
                    this.cards.add(new Spade(j));
                }
            }
            else if(i == 2) {
                for(int j = 2; j <= 15; j++) {
                    this.cards.add(new Diamonds(j));
                }
            }
            else if(i == 3) {
                for(int j = 2; j <= 15; j++) {
                    this.cards.add(new Hart(j));
                }
            }
            else if(i == 4) {
                for(int j = 2; j <= 15; j++) {
                    this.cards.add(new Clover(j));
                }
            }
        }

        return this.cards;
    }

    public void cardShuffle(ArrayList<Card> cards) {
        Collections.shuffle(cards);
    }

}
