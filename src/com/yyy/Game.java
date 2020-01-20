package com.yyy;

public class Game {
    private Player player1;
    private Player player2;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void play() {
        for (int i = 1; i < 7; i++) {
            System.out.println("\nTura gracza " + player1.getName() + ":");
            this.player1.takeTurn();
            System.out.println("\nTura gracza " + player2.getName() + ":");
            this.player2.takeTurn();
            System.out.println("\n-----------------------");
            System.out.println("\nWyniki po rundzie " + i + ":");
            System.out.println("\nPunkty gracza " + player1.getName() + ":");
            player1.getScore().print();
            System.out.println("\nPunkty gracza " + player2.getName() + ":");
            player2.getScore().print();
            System.out.println("\n-----------------------");
        }
        if (player1.getScore().getScores().get(7) > player2.getScore().getScores().get(7)) {
            System.out.println("\nWygrywa gracz " + player1.getName() + "!");
        }
        else if (player1.getScore().getScores().get(7) < player2.getScore().getScores().get(7)) {
            System.out.println("\nWygrywa gracz " + player2.getName() + "!");
        }
        else {
            System.out.println("\nGra zakończyła się remisem.");
        }
    }
}
