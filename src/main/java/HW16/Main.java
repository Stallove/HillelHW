package HW16;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Rock-Paper-Scissors");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Amount of rounds: ");
        int bestOf = scanner.nextInt();

        System.out.println("To exit the game enter \"Quit\"");
        System.out.println();
        System.out.println("1: Rock");
        System.out.println("2: Paper");
        System.out.println("3: Scissors");
        System.out.println();

        int computerChoice;
        int computerWinsCount = 0;
        String playerChoice;
        int varPlayerChoice;
        int humanWinsCount = 0;
        int draws = 0;
        int numOfRounds = 1;
        int[][] winnerTable = {{0, 2, 1},
                               {1, 0, 2},
                               {2, 1, 0}};

        for (; numOfRounds <= bestOf; numOfRounds++) {
            System.out.println("===========================");
            System.out.println("Round " + numOfRounds);

            varPlayerChoice = -2;
            while (varPlayerChoice == -2) {

                System.out.print("Your choice: ");
                playerChoice = scanner.next();

                switch (playerChoice.toLowerCase()) {
                    case "1":
                    case "rock":
                        varPlayerChoice = 0;
                        break;
                    case "2":
                    case "paper":
                        varPlayerChoice = 1;
                        break;
                    case "3":
                    case "scissors":
                        varPlayerChoice = 2;
                        break;
                    case "5":
                    case "quit":
                        varPlayerChoice = -1;
                        break;
                    case "6":
                    case "score":
                        System.out.println("Human wins: " + humanWinsCount);
                        System.out.println("Computer wins: " + computerWinsCount);
                        break;
                    case "help":
                        System.out.println("1: Rock");
                        System.out.println("2: Paper");
                        System.out.println("3: Scissors");
                        System.out.println("4: Help - Command");
                        System.out.println("5: \"Exit\"");
                        System.out.println("6: Score");
                        varPlayerChoice = -2;
                        break;
                    default:
                        System.out.println("Unknown command.");
                        System.out.println("Enter \"help\" to see command list.");
                        varPlayerChoice = -2;
                }
            }
            if(varPlayerChoice == -1){
                break;
            }

            computerChoice = (int)(Math.random() * 3);
            System.out.print("Computer choice: ");
            if (computerChoice == 0)  {
                System.out.println("Rock");
            } else if (computerChoice == 1) {
                System.out.println("Paper");
            } else if (computerChoice == 2) {
                System.out.println("Scissors");
            }

            if (winnerTable[varPlayerChoice][computerChoice] == 0) {
                System.out.println("Draw");
                draws++;
            } else if (winnerTable[varPlayerChoice][computerChoice] == 1) {
                System.out.println("Human win!");
                humanWinsCount++;
            } else if (winnerTable[varPlayerChoice][computerChoice] == 2) {
                System.out.println("Computer win!");
                computerWinsCount++;
            }
        }
        System.out.println("===========SCORE===========");
        System.out.println("Human wins: " + humanWinsCount);
        System.out.println("Computer wins: " + computerWinsCount);
        System.out.println("Draws: " + draws);

        try (FileWriter scoreWriting = new FileWriter("src\\main\\java\\HW16\\Score.txt", true)) {
            scoreWriting.append(
                            "Human wins: " + humanWinsCount + '\n' +
                            "Computer wins: " + computerWinsCount + '\n' +
                            "Draws: " + draws + '\n' +
                            "Amount of rounds: " + bestOf + '\n' +
                            "===========================" + '\n'
            );
            scoreWriting.close();
        }
    }
}
