package HW15;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String strNumber;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число: ");
        strNumber = scanner.nextLine();
        NumToStr.strToConsole(strNumber);

        System.out.print("Введите число: ");
        strNumber = scanner.nextLine();
        NumToStr.strToConsole(strNumber);
        /*
            Введите число: 1234567890
              @@    @@@@   @@@@     @@  @@@@@@  @@@@  @@@@@@  @@@@   @@@@   @@@@
             @@@   @@  @@ @@  @@   @ @  @@     @@        @@  @@  @@ @@  @@ @@  @@
            @ @@      @@     @@   @  @  @@@@@  @@@@@    @@    @@@@   @@@@@ @@  @@
              @@     @@   @@  @@ @@@@@@     @@ @@  @@  @@    @@  @@     @@ @@  @@
            @@@@@@ @@@@@@  @@@@      @  @@@@@   @@@@  @@      @@@@   @@@@   @@@@
            Введите число: nsdfasd as
            NaN
         */
    }
}
