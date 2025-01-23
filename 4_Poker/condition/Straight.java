package condition;

import card.*;
import player.Player;

import java.util.ArrayList;

public class Straight {
    private ArrayList<Card> cards;
    private Player player;

    public Straight(ArrayList<Card> cards, Player player) {
        this.cards = cards;
        this.player = player;
    }

    public boolean isStraight() {
        int[] count = new int[16];

        for(int i = 0; i < 5; i++) {
            count[cards.get(i).getNumber()] += 1;
        }

        int maxLength = 0;
        boolean c = true;

        for(int i = 2; i <= 15; i++) {
            if(count[i] >= 2) break;

            if(count[i] == 1) {
                maxLength++;
                for(int j = i+1; j <= 15; j++) {
                    if(count[j] == 1) {
                        maxLength++;
                        if(maxLength == 5) {

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

                        }
                    }
                    else {
                        c = false;
                        break;
                    }
                }
                if(!c) break;
            }
        }

        if(maxLength == 5) {
            return true;
        }

        return false;
    }

}
