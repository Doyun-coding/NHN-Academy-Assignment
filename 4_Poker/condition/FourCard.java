package condition;

import card.*;
import player.Player;

import java.util.ArrayList;

public class FourCard {
    private ArrayList<Card> cards;
    private Player player;

    public FourCard(ArrayList<Card> cards, Player player) {
        this.cards = cards;
        this.player = player;
    }

    public boolean isFourCard() {
        int[] count = new int[16];

        for(int i = 0; i < 5; i++) {
            int number = cards.get(i).getNumber();
            count[number]++;
            if(count[number] == 4) {

                if(cards.get(i).getRank() == 1) {
                    player.setHighCard(new Spade(cards.get(i).getNumber()));
                }
                else if(cards.get(i).getRank() == 2) {
                    player.setHighCard(new Diamonds(cards.get(i).getNumber()));
                }
                else if(cards.get(i).getRank() == 3) {
                    player.setHighCard(new Hart(cards.get(i).getNumber()));
                }
                else if(cards.get(i).getRank() == 4) {
                    player.setHighCard(new Clover(cards.get(i).getNumber()));
                }

                return true;
            }
        }

        return false;
    }
}
