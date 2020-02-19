package HW20_ThreadBuffer;

public class Producer implements Runnable {
    private int randomInt = 0;          // Эта переменная нужна чтобы не было потери данных.
    private boolean flag = true;        // Флаг нужен чтобы знать сброшено ли число в склад или осталось в переменной
                                        // Тут работает черная магия. (Но вроде все изучил)
    @Override
    public void run() {
        while(true) {

            synchronized (DataBuffer.class) {

                // Цыкл запускается если склад пуст или пока склад не заполнен до предела
                while (flag || DataBuffer.isEmpty()) {

                    // Если осталось число с прошлого заполнения оно сохранится и запишется в следуюущий раз
                    if(flag) {
                        randomInt = (int) (Math.random() * 100);
                    }

                    flag = DataBuffer.dataAdd(randomInt);

                    // Если добавление прошло успешно то выводится сообщение
                    if(flag) {
                        System.out.println("Produced integer: " + randomInt);
                    }

                    // Если нет, то будет выход из синхронезированного блока и передача очереди потребителю
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
