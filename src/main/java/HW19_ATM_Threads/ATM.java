package HW19_ATM_Threads;

public class ATM {
    private static int cash = 0;

    public static int getCash() {
        return cash;
    }

    public static void addCash(int amount) {
        cash += amount;
    }

    public static void withdrawCash(int amount) {
        cash -= amount;
    }
}
