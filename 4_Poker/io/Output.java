package io;

import player.Player;

public class Output {
    private Player[] players;

    public Output(Player[] players) {
        this.players = players;
    }

    public void printResult() {
        for(int i = 0; i < players.length; i++) {
            if(players[i].getRanking() == 1) {
                    System.out.println((i+1) + " 등 : " + players[i].getName() + "  (스트레이트 플러시)");
            }
            else if(players[i].getRanking() == 2) {
                System.out.println((i+1) + " 등 : " + players[i].getName() + "  (포 카드)");
            }
            else if(players[i].getRanking() == 3) {
                System.out.println((i+1) + " 등 : " + players[i].getName() + "  (풀 하우스)");
            }
            else if(players[i].getRanking() == 4) {
                System.out.println((i+1) + " 등 : " + players[i].getName() + "  (플러시)");
            }
            else if(players[i].getRanking() == 5) {
                System.out.println((i+1) + " 등 : " + players[i].getName() + "  (스트레이트)");
            }
            else if(players[i].getRanking() == 6) {
                System.out.println((i+1) + " 등 : " + players[i].getName() + "  (트리플 카드)");
            }
            else if(players[i].getRanking() == 7) {
                System.out.println((i+1) + " 등 : " + players[i].getName() + "  (투 페어)");
            }
            else if(players[i].getRanking() == 8) {
                System.out.println((i+1) + " 등 : " + players[i].getName() + "  (원 페어)");
            }
            else if(players[i].getRanking() == 9) {
                System.out.println((i+1) + " 등 : " + players[i].getName() + "  (하이 카드)");
            }

        }


    }

}
