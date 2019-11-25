package HW16;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Rock-Paper-Scissors");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Amount of rounds: ");
        int bestOf = scanner.nextInt();
        System.err.println("To exit the game enter \"Quit\"");

        int computerChoice;
        int computerWinsCount = 0;
        String playerChoice;
        int varPlayerChoice = 0;
        int humanWinsCount = 0;
        int numOfRounds = 0;
        int winnerTable[][] = {{0, 2, 1},
                               {1, 0, 2},
                               {2, 1, 0}};
        for (; numOfRounds < bestOf; numOfRounds++) {
            /* TODO */

            playerChoice = scanner.nextLine();
            switch (playerChoice.toLowerCase()) {
                case ("1"):
                case ("rock"):
                    varPlayerChoice = 0;
                    break;
                case ("2"):
                case ("paper"):
                    varPlayerChoice = 1;
                    break;
                case ("3"):
                case ("scissors"):
                    varPlayerChoice = 2;
                    break;
            }

            computerChoice = (int)Math.random() * 3 - 1;


            if(playerChoice.toLowerCase().equals("quit")){
                break;
            } else if (winnerTable[varPlayerChoice][computerChoice] == 0) {
                System.out.println("Draw");
                humanWinsCount++;
                humanWinsCount++;
            } else if (winnerTable[varPlayerChoice][computerChoice] == 1) {
                System.out.println("Human win!");
                humanWinsCount += 2;
            } else if (winnerTable[varPlayerChoice][computerChoice] == 2) {
                System.out.println("Computer win!");
                computerWinsCount += 2;
            }
        }

    }
}
