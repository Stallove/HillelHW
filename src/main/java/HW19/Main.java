package HW19;

public class Main {
    public static void main(String[] args) {
        ATM.addCash(10000);
        Thread thr1 = new Thread(new Threadsss("Thread 1"));
        Thread thr2 = new Thread(new Threadsss("Thread 2"));
        thr1.start();
        thr2.start();
    }
}
