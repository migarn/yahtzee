package com.yyy;

import java.util.ArrayList;

public class Score {
    private ArrayList<Integer> scores;
    private ArrayList<String> labels;

    public Score() {
        this.scores = new ArrayList<>();

        // -1 assigned everywhere, to distinguish unscored figures from scored with 0
        for (int i = 0; i < 8; i++) {
            this.scores.add(-1);

            setLabels();
        }
    }

    public ArrayList<Integer> getScores() {
        return scores;
    }

    public ArrayList<String> getLabels() {
        return labels;
    }

    public void addScore(Cast cast, int chosenFigures) {
        int score = 0;

        for (int castResult : cast.getCastResults()) {
            if (castResult == chosenFigures) {
                score += castResult;
            }
        }

        this.scores.set(chosenFigures - 1, score);
    }

    public void calculateScore() {
        int upperSectionSum = 0;

        for (int i = 0; i < 6; i++) {
            if (this.scores.get(i) != -1) {
                upperSectionSum += this.scores.get(i);
            }
        }

        if (upperSectionSum >= 63) {
            this.scores.set(6,35);
        }
        else {
            this.scores.set(6,0);
        }

        this.scores.set(7, upperSectionSum + this.scores.get(6));
    }

    private void setLabels() {
        this.labels = new ArrayList<>();
        this.labels.add("Aces");
        this.labels.add("Twos");
        this.labels.add("Threes");
        this.labels.add("Fours");
        this.labels.add("Fives");
        this.labels.add("Sixes");
        this.labels.add("Bonus");
        this.labels.add("Score");
    }

    public void print() {
        for (int i = 0; i < this.scores.size(); i++) {
            String label = this.labels.get(i);
            int score = this.scores.get(i);
            if (score == -1) {
                score = 0;
            }

            String row = String.format("%-8s %3d pkt.", label + ":", score);
            System.out.println(row);
        }
    }
}
