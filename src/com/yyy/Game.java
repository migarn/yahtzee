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
            System.out.println("\nTurn of " + player1.getName() + ":");
            this.player1.takeTurn();
            System.out.println("\nTurn of " + player2.getName() + ":");
            this.player2.takeTurn();
            System.out.println("\n-----------------------");
            System.out.println("\nScores after round " + i + ":");
            System.out.println("\nScores of " + player1.getName() + ":");
            player1.getScore().print();
            System.out.println("\nScores of " + player2.getName() + ":");
            player2.getScore().print();
            System.out.println("\n-----------------------");
        }
        if (player1.getScore().getScores().get(7) > player2.getScore().getScores().get(7)) {
            System.out.println("\nPlayer " + player1.getName() + " wins!");
        }
        else if (player1.getScore().getScores().get(7) < player2.getScore().getScores().get(7)) {
            System.out.println("\nPlayer " + player2.getName() + " wins!");
        }
        else {
            System.out.println("\nThe game ended in a draw.");
        }
    }
}
