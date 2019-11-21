package HW15;

public class NumToStr {

    public static String[] numToStr(int num) {
        int oneNum;
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

    public static String[] stringNums(int num) {
        if(num == 1) {
            String[] str = {
                    "  @@  ",
                    " @@@  ",
                    "@ @@  ",
                    "  @@  ",
                    "@@@@@@"};
            return str;
        } else if(num == 2) {
            String[] str = {
                    " @@@@ ",
                    "@@  @@",
                    "   @@ ",
                    "  @@  ",
                    "@@@@@@"};
            return str;
        } else if(num == 3) {
            String[] str = {
                    " @@@@ ",
                    "@@  @@",
                    "   @@ ",
                    "@@  @@",
                    " @@@@ "};
            return str;
        } else if(num == 4) {
            String[] str = {
                    "   @@ ",
                    "  @ @ ",
                    " @  @ ",
                    "@@@@@@",
                    "    @ "};
            return str;
        } else if(num == 5) {
            String[] str = {
                    "@@@@@@",
                    "@@    ",
                    "@@@@@ ",
                    "    @@",
                    "@@@@@ "};
            return str;
        } else if(num == 6) {
            String[] str = {
                    " @@@@ ",
                    "@@    ",
                    "@@@@@ ",
                    "@@  @@",
                    " @@@@ "};
            return str;
        } else if(num == 7) {
            String[] str = {
                    "@@@@@@",
                    "   @@ ",
                    "  @@  ",
                    " @@   ",
                    "@@    "};
            return str;
        } else if(num == 8) {
            String[] str = {
                    " @@@@ ",
                    "@@  @@",
                    " @@@@ ",
                    "@@  @@",
                    " @@@@ "};
            return str;
        } else if(num == 9) {
            String[] str = {
                    " @@@@ ",
                    "@@  @@",
                    " @@@@@",
                    "    @@",
                    " @@@@ "};
            return str;
        } else if(num == 0) {
            String[] str = {
                    " @@@@ ",
                    "@@  @@",
                    "@@  @@",
                    "@@  @@",
                    " @@@@ "};
            return str;
        } else {
            String[] str = {"ERROR"};
            return str;
        }
    }

    public static void strPrint(String[] strArr) {
        for (String e : strArr) {
            System.out.println(e);
        }
    }

    public static void strToConsole(String s) throws NumberFormatException {
        int num;

        try {
            num = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            System.out.println("NaN");
            return;
        }

        NumToStr.strPrint(NumToStr.numToStr(num));
    }
}
