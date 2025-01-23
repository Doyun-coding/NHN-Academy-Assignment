package condition;

import card.*;
import player.Player;

import java.util.ArrayList;

public class Flush {
    private ArrayList<Card> cards;
    private Player player;

    public Flush(ArrayList<Card> cards, Player player) {
        this.cards = cards;
        this.player = player;
    }

    public boolean isFlush() {
        String preShape = cards.get(0).getShape();

        for(int i = 1; i < 5; i++) {
            if(!cards.get(i).getShape().equals(preShape)) {
                return false;
            }
        }

        if(cards.get(0).getRank() == 1) {
            player.setHighCard(new Spade(cards.get(0).getNumber()));
        }
        else if(cards.get(0).getRank() == 2) {
            player.setHighCard(new Diamonds(cards.get(0).getNumber()));
        }
        else if(cards.get(0).getRank() == 3) {
            player.setHighCard(new Hart(cards.get(0).getNumber()));
        }
        else if(cards.get(0).getRank() == 4) {
            player.setHighCard(new Clover(cards.get(0).getNumber()));
        }

        return true;
    }


}
