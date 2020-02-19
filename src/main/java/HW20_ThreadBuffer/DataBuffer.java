package HW20_ThreadBuffer;

import java.util.ArrayDeque;

public class DataBuffer {
    private static final int MAXSIZE = 5;               // Ограничитель склада
    private static ArrayDeque<Integer> deque = new ArrayDeque<>(MAXSIZE);   // Склад = двунаправленная очередь

    public static boolean dataAdd(Integer integer) {    // Добавляет элемент в склад если есть место
        if (deque.size() < MAXSIZE) {
            return deque.offer(integer);
        } else {
            return false;
        }
    }

    public static Integer dataPoll() {                  // Забирает и удаляет элемент со склада
        return deque.poll();
    }

    public static boolean isEmpty() {                   // Метод используется как флаг для Пр. и Потр.
        return deque.isEmpty();
    }
}
