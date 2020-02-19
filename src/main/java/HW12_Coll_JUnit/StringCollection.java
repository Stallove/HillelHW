package HW12_Coll_JUnit;

public class StringCollection implements CustomCollection {
    private String coll[];   // Объявление переменных
    private int count = 0;

    public StringCollection() {             // Конструктор коллекции
        coll = new String[10];
    }
    public StringCollection(int size) {             // Конструктор коллекции
        if (size >= 2) {
            coll = new String[size];
        } else {
            coll = new String[2];
        }
    }

    public boolean add(String addString) {  // Добавление элемента в коллекцию
        if (count + 1 > coll.length)
            coll = increaseColl();
        coll[count] = addString;
        count++;
        return true;
    }

    public boolean addAll(String[] strArr) {    // Добавление элементов через массив
        for (int i = 0; i < strArr.length; i++) {
            this.add(strArr[i]);
        }
        return true;
    }

    public boolean addAll(StringCollection strColl) {    // Добавление элементов через коллекцию
        for (int i = 0; i < strColl.count; i++)
            this.add(strColl.coll[i]);
        return true;
    }

    public boolean trim() { // Пересоздание коллекции без бустых ячеек
        String[] tempArr = new String[count];
        for (int i = 0; i < count; i++)
            tempArr[i] = coll[i];
        coll = tempArr;
        return true;
    }

    public boolean contains(String str) { // Метод определяющий наличие строки в коллекции
        for (int i = 0; i < count; i++)
            if (this.coll[i] == str)
                return true;
        return false;
    }

    private String[] increaseColl() {   // Внутрений метод увеличения длинны коллекции на 2/3
        String IncreasedCollection[] = new String[coll.length + coll.length * 2 / 3];
        for (int i = 0; i < count; i++)
            IncreasedCollection[i] = coll[i];
        return IncreasedCollection;
    }

    public boolean delete(int deleteIndex) {// Удаление по идндексу
        if (deleteIndex > count || deleteIndex < 0)
            return false;
        coll[deleteIndex] = null;
        for (;deleteIndex + 1 < coll.length; deleteIndex++)
            coll[deleteIndex] = coll[deleteIndex + 1];
        count--;
        return true;
    }

    public boolean delete(String string) { // Удаление по значению
        for (int i = 0; i < count; i++)
            if (coll[i].equals(string)) {
                delete(i);
                i--;
            }
        return true;
    }

    public String get(int index) { // Получение строки по индексу
        if (index > count || index < 0)
            return null;
        return coll[index];
    }

    public boolean equals(StringCollection collection) { // Сравнение двух коллекций
        if(this.count != collection.getSize() || this.coll.length != collection.coll.length)
            return false;
        for (int i = 0; i < count; i++)
            if (this.coll[i] != collection.coll[i])
                return false;
        return true;
    }

    public boolean clear() { // Очистка коллекции
        for (int i = 0; i < count; i++)
            coll = null;
        count = 0;
        System.out.println("StringArrCollection is clear.");
        return true;
    }

    public boolean findString(String string) { // Поиск первого попавшегося совподения
        for (int i = 0; i < count; i++) {
            if (coll[i].equals(string)) {
                return true;
            }
        }
        return false;
    }

    public int[] findIndexAll(String string) { // Поиск всех совпадений по значению
        int foundIndices[] = new int[0]; // Индексы всех всех совпадений помещаются в массив
        for (int i = 0, in = 0; i < count; i++) {
            if (coll[i].equals(string)) {
                if (in + 1 > foundIndices.length)
                    foundIndices = increasingArr(foundIndices);
                foundIndices[in] = i;
                in++;
            }
        }
        return foundIndices;                // Метод возвращает массив с индексами совпадений
    }

    private int[] increasingArr(int[] arr) {    // Метод для увеличения массива совпадений
        int IncreasedArr[] = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++)
            IncreasedArr[i] = arr[i];
        return IncreasedArr;
    }

    public int getSize() {  // Возвращение количесва занятых ячеек коллекции
        return count;
    }

    public boolean stringReplacement (String string, int index) {
        if (index > count || index < 0)
            return false;
        coll[index] = string;
        return true;
    }
}
