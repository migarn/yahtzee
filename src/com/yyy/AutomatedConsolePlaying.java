package com.yyy;

import java.util.ArrayList;

public class AutomatedConsolePlaying extends ManualConsolePlaying {

    public AutomatedConsolePlaying() {
        super();
    }

    @Override
    public void takeTurn(Score score) {
        int trial = 1;
        Cast cast = new Cast(6);
        System.out.println("\nRzut komputera:");
        sleep();
        cast.print();
        sleep();
        correctOrCalculate(score, cast, trial);
    }

    @Override
    protected void correctOrCalculate(Score score, Cast cast, int trial) {
        if (trial == 3) {
            calculateScore(score, cast);
        }
        else {
            int choice = decideIfCorrect(score, cast);
            if (choice == 1) {
                System.out.println("\nKomputer powtarza rzuty.");
                sleep();
                trial++;
                int figureToCorrection = chooseFigures(score, cast);
                ArrayList<Integer> diceToCorrection = chooseDiceToCorrection(cast, figureToCorrection);
                System.out.println("\nKomputer powtarza rzuty koścmi numer:");

                for (int diceNumber : diceToCorrection) {
                    System.out.println(diceNumber);
                    cast.setToCorrection(diceNumber);
                }
                sleep();
                System.out.println("\nPowtórzony rzut komputera:");
                sleep();
                Cast anotherCast = new Cast(cast);
                anotherCast.print();
                sleep();
                correctOrCalculate(score, anotherCast, trial);
            }
            else {
                calculateScore(score, cast);
            }
        }
    }

    @Override
    protected void calculateScore(Score score, Cast cast) {
        int chosenFigure = chooseFigures(score, cast);
        String label = score.getLabels().get(chosenFigure - 1);
        System.out.println("\nKomputer przydziela punkty figurom: " + label.toLowerCase());
        sleep();
        score.addScore(cast, chosenFigure);
        System.out.println("\nWyniki komputera:");
        score.calculateScore();
        score.print();
        sleep();
    }

    private int decideIfCorrect(Score score, Cast cast) {
        for (int i = 1; i < 7; i++) {
            int repeatedFigures = 0;
            for (int castResult : cast.getCastResults()) {
                if (castResult == i) {
                    repeatedFigures++;
                    if (repeatedFigures == 6 && score.getScores().get(i - 1) == -1) {
                        return 2;
                    }
                }
            }
        }
        return 1;
    }

    private ArrayList<Integer> chooseDiceToCorrection(Cast cast, int figure) {
        ArrayList<Integer> diceToCorrection = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            if (cast.getCastResults().get(i) != figure) {
                diceToCorrection.add(i + 1);
            }
        }

        return diceToCorrection;
    }

    private int chooseFigures(Score score, Cast cast) {
        int repeatedFigures = 0;
        int tempRepeatedFigures;
        int mostFrequentFigure = 0;

        for (int i = 1; i < 7; i++) {
            tempRepeatedFigures = 0;
            for (int castResult : cast.getCastResults()) {
                if (castResult == i) {
                    tempRepeatedFigures++;
                }
            }
            if (tempRepeatedFigures >= repeatedFigures && score.getScores().get(i - 1) == -1) {
                repeatedFigures = tempRepeatedFigures;
                mostFrequentFigure = i;
            }
        }
        return mostFrequentFigure;
    }
}
