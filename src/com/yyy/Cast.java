package com.yyy;

import java.util.ArrayList;
import java.util.Random;

public class Cast {
    private ArrayList<Integer> castResults;

    public Cast(int diceQuantity) {
        this.castResults = new ArrayList<>();

        for (int i = 0; i < diceQuantity; i++) {
            this.castResults.add(new Random().nextInt(6) + 1);
        }
    }

    public Cast(Cast initialCast) {
        // Konstruktor losujący wartości tylko dla kości oznaczonych do poprawy (z wartościami 0)
        this.castResults = new ArrayList<>();
        this.castResults.addAll(initialCast.getCastResults());

        for (int i = 0; i < this.castResults.size(); i++) {
            if (this.castResults.get(i) == 0) {
                this.castResults.set(i, new Random().nextInt(6) + 1);
            }
        }
    }

    public ArrayList<Integer> getCastResults() {
        return castResults;
    }

    public void setToCorrection(int index) {
        // Rzutom przeznaczonym do poprawy nadaję wartość 0
        this.castResults.set(index - 1, 0);
    }

    public void print() {
        String line1 = "";
        String line2 = "";
        String line3 = "";
        String line4 = "";
        String line5 = "";

        for (int castResult : this.castResults) {
            line1 += "\u250c\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2510 ";
            line5 += "\u2514\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2518 ";

            switch (castResult) {
                case 1:
                    line2 += "\u2502       \u2502 ";
                    line3 += "\u2502   O   \u2502 ";
                    line4 += "\u2502       \u2502 ";
                    break;

                case 2:
                    line2 += "\u2502 O     \u2502 ";
                    line3 += "\u2502       \u2502 ";
                    line4 += "\u2502     O \u2502 ";
                    break;

                case 3:
                    line2 += "\u2502 O     \u2502 ";
                    line3 += "\u2502   O   \u2502 ";
                    line4 += "\u2502     O \u2502 ";
                    break;

                case 4:
                    line2 += "\u2502 O   O \u2502 ";
                    line3 += "\u2502       \u2502 ";
                    line4 += "\u2502 O   O \u2502 ";
                    break;

                case 5:
                    line2 += "\u2502 O   O \u2502 ";
                    line3 += "\u2502   O   \u2502 ";
                    line4 += "\u2502 O   O \u2502 ";
                    break;

                case 6:
                    line2 += "\u2502 O   O \u2502 ";
                    line3 += "\u2502 O   O \u2502 ";
                    line4 += "\u2502 O   O \u2502 ";
                    break;

                default:
                    break;
            }
        }
        System.out.println(line1 + "\n" + line2 + "\n" + line3 + "\n" + line4 + "\n" + line5);
    }
}
