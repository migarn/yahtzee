package com.yyy;

public class Main {

    public static void main(String[] args) {
        LoopingScanner scanner = new LoopingScanner();
        boolean inLoop = true;

        while (inLoop) {
            System.out.println("\nYahtzee - simplified version.\nThe program enables playing Yahtzee in simplified version (only upper section can be scored)." +
                    "\nTwo modes are enabled: player vs player or player vs computer.");
            int choice = scanner.scanInt("\nType:\n1 - to start a game for one player\n2 - to start a game for two players\n3 - to terminate",1,2,3);
            if (choice == 1) {
                String name = scanner.scanString("\nPlayer, please type you name:");
                Game gameForOne = new Game(new Player(name, new ManualConsolePlaying()), new Player("Computer", new AutomatedConsolePlaying()));
                gameForOne.play();
            }
            else if (choice == 2) {
                String name1 = scanner.scanString("\nFirst player, please type you name:");
                String name2 = scanner.scanString("\nSecond player, please type you name:");
                Game gameForTwo = new Game(new Player(name1, new ManualConsolePlaying()), new Player(name2, new ManualConsolePlaying()));
                gameForTwo.play();
            }
            else {
                inLoop = false;
            }
        }
    }
}
