package player;

import card.Card;

import java.util.ArrayList;

public class Player implements Comparable<Player> {
    private String name;
    private ArrayList<Card> cards;
    private int ranking;
    private Card highCard;
    private Card highCard2;

    public Player(String name) {
        this.name = name;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public ArrayList<Card> getCards() {
        return this.cards;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public int getRanking() {
        return this.ranking;
    }

    public String getName() {
        return this.name;
    }

    public Card getHighCard() {
        return this.highCard;
    }

    public Card getHighCard2() {
        return this.highCard2;
    }

    public void setHighCard(Card highCard) {
        this.highCard = highCard;
    }

    public void setHighCard(Card highCard, Card highCard2) {
        this.highCard = highCard;
        this.highCard2 = highCard2;
    }

    @Override
    public int compareTo(Player o) {
        if(this.ranking == o.ranking) {
            if(this.ranking == 1) {
                if(this.highCard.getNumber() == o.highCard.getNumber()) {
                    return this.highCard.getRank() - o.highCard.getRank();
                }

                return o.highCard.getNumber() - this.highCard.getNumber();
            }
            else if(this.ranking == 2) {
                return o.highCard.getNumber() - this.highCard.getNumber();
            }
            else if(this.ranking == 3) {
                if(this.highCard.getNumber() == o.highCard.getNumber()) {
                    if(this.highCard2.getNumber() == o.highCard2.getNumber()) {
                        return this.highCard.getRank() - o.highCard.getRank();
                    }

                    return o.highCard2.getNumber() - this.highCard2.getNumber();
                }

                return o.highCard.getNumber() - this.highCard.getNumber();
            }
            else if(this.ranking == 4) {
                if(this.highCard.getNumber() == o.highCard.getNumber()) {
                    return this.highCard.getRank() - o.highCard.getRank();
                }

                return o.highCard.getNumber() - this.highCard.getNumber();
            }
            else if(this.ranking == 5) {
                if(this.highCard.getNumber() == o.highCard.getNumber()) {
                    return this.highCard.getRank() - o.highCard.getRank();
                }

                return o.highCard.getNumber() - this.highCard.getNumber();
            }
            else if(this.ranking == 6) {
                return o.highCard.getNumber() - this.highCard.getNumber();
            }
            else if(this.ranking == 7) {
                if(this.highCard.getNumber() == o.highCard.getNumber()) {
                    if(this.highCard2.getNumber() == o.highCard2.getNumber()) {
                        return this.highCard.getRank() - o.highCard.getRank();
                    }

                    return o.highCard2.getNumber() - this.highCard2.getNumber();
                }

                return o.highCard.getNumber() - this.highCard.getNumber();
            }
            else if(this.ranking == 8) {
                if(this.highCard.getNumber() == o.highCard.getNumber()) {
                    return this.highCard.getRank() - o.highCard.getRank();
                }

                return o.highCard.getNumber() - this.highCard.getNumber();
            }
            else if(this.ranking == 9) {
                if(this.highCard.getNumber() == o.highCard.getNumber()) {
                    return this.highCard.getRank() - o.highCard.getRank();
                }

                return o.highCard.getNumber() - this.highCard.getNumber();
            }
        }

        return this.ranking - o.ranking;
    }
}
