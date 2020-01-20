package com.yyy;

public class Main {

    public static void main(String[] args) {
        LoopingScanner scanner = new LoopingScanner();
        boolean inLoop = true;

        while (inLoop) {
            System.out.println("\nYahtzee - wersja uproszczona.\nProgram umożliwia grę w kości w uproszczonej wersji, a więc z punktowaniem tylko podstawowych kategorii." +
                    "\nUdostępniona jest możliwość rywalizacji pomiędzy dwoma graczami lub rywalizacji gracza z komputerem.");
            int choice = scanner.scanInt("\nWpisz:\n1 - aby rozpocząć grę dla jednej osoby\n2 - aby rozpocząć grę dla dwóch osób\n3 - aby zakończyć program",1,2,3);
            if (choice == 1) {
                String name = scanner.scanString("\nGraczu, podaj swoje imię:");
                Game gameForOne = new Game(new Player(name, new ManualConsolePlaying()), new Player("Komputer", new AutomatedConsolePlaying()));
                gameForOne.play();
            }
            else if (choice == 2) {
                String name1 = scanner.scanString("\nPierwszy graczu, podaj swoje imię:");
                String name2 = scanner.scanString("\nDrugi graczu, podaj swoje imię:");
                Game gameForTwo = new Game(new Player(name1, new ManualConsolePlaying()), new Player(name2, new ManualConsolePlaying()));
                gameForTwo.play();
            }
            else {
                inLoop = false;
            }
        }
    }
}
