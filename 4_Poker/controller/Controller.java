package controller;

import card.Card;
import condition.*;
import dealer.Dealer;
import io.Input;
import io.Output;
import player.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Controller {
    private static Input inputHandler = new Input();
    private static int playerN = 0;
    private static String userName = "";
    private static Player[] players;

    public Controller() {}

    public void run() {
        System.out.println(inputHandler.startGame());

        playerN = inputHandler.selectPlayerNumber();
        userName = inputHandler.inputUserName();

        playerNameRandom();
    }

    public void playerNameRandom() {
        players = new Player[playerN];
        players[0] = new Player(userName);

        ArrayList<String> randomName = new ArrayList<>();
        randomName.add("YongMin");
        randomName.add("SunWoo");
        randomName.add("Antonio Esfandiari");
        randomName.add("Lim Yo-Hwan");
        randomName.add("Hong Jin-ho");
        randomName.add("Dan Bilzerian");
        randomName.add("Phil Ivey");
        randomName.add("Tom Dwan");
        randomName.add("HillState");
        randomName.add("Goni");

        Collections.shuffle(randomName);

        for(int i = 1; i < playerN; i++) {
            players[i] = new Player(randomName.get(i));
        }

        setPlayerCards();
    }

    public void setPlayerCards() {
        Dealer dealer = new Dealer();

        ArrayList<Card> cards = dealer.settingCards();
        dealer.cardShuffle(cards);

        int idx = 0;
        for(int i = 0; i < playerN; i++) {
            ArrayList<Card> divideCards = new ArrayList<>();
            for(int j = idx; j < idx+5; j++) {
                divideCards.add(cards.get(j));
            }
            players[i].setCards(divideCards);
            idx += 5;
        }

        cardAnalysis();
    }

    public void cardAnalysis() {
        boolean[] done = new boolean[playerN];

        for(int i = 1; i <= 9; i++) {
            for(int j = 0; j < playerN; j++) {
                if(!done[j]) {
                    if(forCheck(players[j], i)) {
                        players[j].setRanking(i);
                        done[j] = true;
                    }
                }
            }
        }

        setRanking();
    }

    public boolean forCheck(Player player, int step) {
        if(step == 1) {
            return checkStraightFlush(player);
        }
        else if(step == 2) {
            return checkFourCard(player);
        }
        else if(step == 3) {
            return checkFullHouse(player);
        }
        else if(step == 4) {
            return checkFlush(player);
        }
        else if(step == 5) {
            return checkStraight(player);
        }
        else if(step == 6) {
            return checkTriple(player);
        }
        else if(step == 7) {
            return checkTwoPairs(player);
        }
        else if(step == 8) {
            return checkOnePair(player);
        }
        else if(step == 9) {
            return checkHighCard(player);
        }

        return false;
    }

    public boolean checkStraightFlush(Player player) {
        StraightFlush straightFlush = new StraightFlush(player.getCards(), player);

        return straightFlush.isStraightFlush();
    }

    public boolean checkFourCard(Player player) {
        FourCard fourCard = new FourCard(player.getCards(), player);

        return fourCard.isFourCard();
    }

    public boolean checkFullHouse(Player player) {
        FullHouse fullHouse = new FullHouse(player.getCards(), player);

        return fullHouse.isFullHouse();
    }

    public boolean checkFlush(Player player) {
        Flush flush = new Flush(player.getCards(), player);

        return flush.isFlush();
    }

    public boolean checkStraight(Player player) {
        Straight straight = new Straight(player.getCards(), player);

        return straight.isStraight();
    }

    public boolean checkTriple(Player player) {
        Triple triple = new Triple(player.getCards(), player);

        return triple.isTriple();
    }

    public boolean checkTwoPairs(Player player) {
        TwoPairs twoPairs = new TwoPairs(player.getCards(), player);

        return twoPairs.isTwoPairs();
    }

    public boolean checkOnePair(Player player) {
        OnePair onePair = new OnePair(player.getCards(), player);

        return onePair.isOnePair();
    }

    public boolean checkHighCard(Player player) {
        HighCard highCard = new HighCard(player.getCards(), player);

        return highCard.isHighCard();
    }

    public void setRanking() {
        Arrays.sort(players);

        result();
    }

    public void result() {
        Output outputHandler = new Output(players);

        outputHandler.printResult();
    }

}
