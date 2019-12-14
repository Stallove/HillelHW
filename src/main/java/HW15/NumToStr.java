package HW15;

import java.util.Scanner;

public class NumToStr {
    public static void main(String[] args) {
        String strNumber;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число: ");
        strNumber = scanner.nextLine();
        NumToStr.strToConsole(strNumber);
    }

    public static boolean strToConsole(String s) throws NumberFormatException {
        int num;

        try {
            num = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            System.out.println("NaN");
            return false;
        }

        NumToStr.strPrint(NumToStr.numToStr(num));
        return true;
    }

    public static boolean strToConsole(int i)  {
        NumToStr.strPrint(NumToStr.numToStr(i));
        return true;
    }

    private static String[] numToStr(int num) {
        String[] stringNum = {"", "", "", "", ""};
        String[] temp;
        while(num > 0) {
            temp = stringNums(num % 10);
            for (int i = 0; i < stringNum.length; i++) {
                stringNum[i] = temp[i] + " " + stringNum[i];
            }
            num /= 10;
        }
        return stringNum;
    }

    private static String[] stringNums(int num) {
        if(num == 1) {
            return new String[]{
                    "  @@  ",
                    " @@@  ",
                    "@ @@  ",
                    "  @@  ",
                    "@@@@@@"};
        } else if(num == 2) {
            return new String[]{
                    " @@@@ ",
                    "@@  @@",
                    "   @@ ",
                    "  @@  ",
                    "@@@@@@"};
        } else if(num == 3) {
            return new String[]{
                    " @@@@ ",
                    "@@  @@",
                    "   @@ ",
                    "@@  @@",
                    " @@@@ "};
        } else if(num == 4) {
            return new String[]{
                    "   @@ ",
                    "  @ @ ",
                    " @  @ ",
                    "@@@@@@",
                    "    @ "};
        } else if(num == 5) {
            return new String[]{
                    "@@@@@@",
                    "@@    ",
                    "@@@@@ ",
                    "    @@",
                    "@@@@@ "};
        } else if(num == 6) {
            return new String[]{
                    " @@@@ ",
                    "@@    ",
                    "@@@@@ ",
                    "@@  @@",
                    " @@@@ "};
        } else if(num == 7) {
            return new String[]{
                    "@@@@@@",
                    "   @@ ",
                    "  @@  ",
                    " @@   ",
                    "@@    "};
        } else if(num == 8) {
            return new String[]{
                    " @@@@ ",
                    "@@  @@",
                    " @@@@ ",
                    "@@  @@",
                    " @@@@ "};
        } else if(num == 9) {
            return new String[]{
                    " @@@@ ",
                    "@@  @@",
                    " @@@@@",
                    "    @@",
                    " @@@@ "};
        } else if(num == 0) {
            return new String[]{
                    " @@@@ ",
                    "@@  @@",
                    "@@  @@",
                    "@@  @@",
                    " @@@@ "};
        } else {
            return new String[]{"ERROR"};
        }
    }

    private static void strPrint(String[] strArr) {
        for (String e : strArr) {
            System.out.println(e);
        }
    }
}
