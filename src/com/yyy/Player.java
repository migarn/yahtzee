package com.yyy;

public class Player {
    private String name;
    private PlayingMethod playingMethod;
    private Score score;

    public Player(String name, PlayingMethod playingMethod) {
        this.name = name;
        this.playingMethod = playingMethod;
        this.score = new Score();
    }

    public String getName() {
        return name;
    }

    public Score getScore() {
        return score;
    }

    public void takeTurn() {
        playingMethod.takeTurn(this.score);
    }
}
