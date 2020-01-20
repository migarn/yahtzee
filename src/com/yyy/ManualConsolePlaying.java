package com.yyy;

public class ManualConsolePlaying implements PlayingMethod {
    protected LoopingScanner scanner;

    public ManualConsolePlaying() {
        this.scanner = new LoopingScanner();
    }

    public void takeTurn(Score score) {
        int trial = 1;
        this.scanner.scanString("\nAby rzucić koścmi wpisz dowolny ciąg znaków i zatwierdź klawiszem ENTER.");
        System.out.println("\nTwój rzut:");
        sleep();
        Cast cast = new Cast(6);
        cast.print();
        correctOrCalculate(score, cast, trial);
    }

    private int[] defineAvailableFigures(Score score) {
        int arrayLength = 0;

        for (int i = 0; i < 6; i++) {
            if (score.getScores().get(i) == -1) {
                arrayLength++;
            }
        }

        int[] availableFigures = new int[arrayLength];
        int arrayIndex = 0;
        for (int i = 0; i < 6; i++) {
            if (score.getScores().get(i) == -1) {
                availableFigures[arrayIndex] = i + 1;
                arrayIndex ++;
            }
        }
        return availableFigures;
    }

    private String printAvailableFigures(Score score) {
        String availableFigures = "";

        for (int i = 0; i < 6; i++) {
            if (score.getScores().get(i) == -1) {
                availableFigures += "\n" + (i + 1) + " - " + score.getLabels().get(i).toLowerCase();
            }
        }
        return availableFigures;
    }

    protected void correctOrCalculate(Score score, Cast cast, int trial) {
        if (trial == 3) {
            calculateScore(score, cast);
        }
        else {
            int choice = this.scanner.scanInt("\nWpisz:\n1 - aby powtórzyć rzuty\n2 - aby określić figury, którym będą przyznane punkty",1,2);
            if (choice == 1) {
                trial++;
                int amountToCorrect = this.scanner.scanInt("\nPodaj ilość kości, których rzuty chcesz powtórzyć:",1,2,3,4,5,6);

                for (int i = 0; i < amountToCorrect; i++) {
                    int diceNumber = this.scanner.scanInt("\nPodaj numer kości, której rzut chcesz powtórzyć:",1,2,3,4,5,6);
                    cast.setToCorrection(diceNumber);
                }
                System.out.println("\nTwój powtórzony rzut:");
                sleep();
                Cast anotherCast = new Cast(cast);
                anotherCast.print();
                correctOrCalculate(score, anotherCast, trial);
            }
            else {
                calculateScore(score, cast);
            }
        }
    }

    protected void calculateScore(Score score, Cast cast) {
        int[] availableFigures = defineAvailableFigures(score);
        int chosenFigure = this.scanner.scanInt("\nWybierz figury, którym chcesz porzydzielić punkty:" + printAvailableFigures(score),availableFigures);
        score.addScore(cast, chosenFigure);
        System.out.println("\nTwoje wyniki:");
        score.calculateScore();
        score.print();
    }

    protected void sleep() {
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
