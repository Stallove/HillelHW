package HW19_ATM_Threads;

public class Threadsss implements Runnable{
    private String name;

    public Threadsss(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        synchronized (ATM.class) {
            for (int i = 0; i < 5; i++) {
                int amount = (int) (Math.random() * 1000);
                if ((int) (Math.random() * 2) == 0) {
                    ATM.addCash(amount);
                    System.out.println(name + "\\\\Add money\\\\" + amount + " = " + ATM.getCash());
                } else {
                    if (ATM.getCash() > amount) {
                        ATM.withdrawCash(amount);
                        System.out.println(name + "\\\\Withdraw money\\\\" + amount + " = " + ATM.getCash());
                    } else {
                        System.out.println(name + "\\\\Withdraw money\\\\" + "Not enough money!");
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
