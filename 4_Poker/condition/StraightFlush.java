package condition;

import card.*;
import player.Player;

import java.util.ArrayList;

public class StraightFlush {
    private ArrayList<Card> cards;
    private Player player;

    public StraightFlush(ArrayList<Card> cards, Player player) {
        this.cards = cards;
        this.player = player;
    }

    public boolean isStraightFlush() {
        Flush flush = new Flush(this.cards, player);
        boolean isFlush = flush.isFlush();

        Straight straight = new Straight(this.cards, player);
        boolean isStraight = straight.isStraight();

        if(isFlush && isStraight) {
            int max = 0;
            for(int i = 0; i < 5; i++) {
                max = Math.max(max, cards.get(i).getNumber());
            }

            if(cards.get(0).getRank() == 1) {
                player.setHighCard(new Spade(max));
            }
            else if(cards.get(0).getRank() == 2) {
                player.setHighCard(new Diamonds(max));
            }
            else if(cards.get(0).getRank() == 3) {
                player.setHighCard(new Hart(max));
            }
            else if(cards.get(0).getRank() == 4) {
                player.setHighCard(new Clover(max));
            }

            return true;
        }

        return false;
    }

}
