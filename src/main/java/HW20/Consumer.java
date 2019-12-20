package HW20;

import java.util.ArrayList;
import java.util.List;

public class Consumer implements Runnable {
    List<Integer> list = new ArrayList<>();
    @Override
    public void run() {
        while (true) {                                              // Потребитель всегда потребляет
            synchronized (DataBuffer.class) {
                while (!DataBuffer.isEmpty()) {                     // Пока склад не опустеет Потр. потребляет
                    list.add(DataBuffer.dataPoll());
                    System.out.println("Consumed integer: " + list.get(list.size() - 1));
                }
            }           // Дальше он выходит из синхронизированного блока чтобы освободить его для Пр.

            try {       // Ожидает и передает склад Пр.
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
