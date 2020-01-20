package com.yyy;

import java.util.Scanner;

public class LoopingScanner {
    private Scanner scanner = new Scanner(System.in);

    public int scanInt(String instruction, int... availableInputs) {
        int input = 0;
        boolean inLoop = true;

        while (inLoop) {
            try {
                System.out.println(instruction);
                input = scanner.nextInt();
                for (int i : availableInputs) {
                    if (input == i) {
                        inLoop = false;
                        break;
                    }
                }
                scanner.nextLine();
            }
            catch (Exception e) {
                scanner.nextLine();
            }
        }

        return input;
    }

    public String scanString(String instruction) {
        System.out.println(instruction);
        return scanner.nextLine();
    }



}
