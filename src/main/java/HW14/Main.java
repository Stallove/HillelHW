package HW14;

public class Main {
    public static void main(String[] args) {
         int[] arr = new int[] {15, 2, 8, 9, 11, 1, 5, 8, 13, 3, 7};

        System.out.println("Before sort");
        for (int a : arr) {
            System.out.print(a + ", ");
        }
        System.out.println("\b\b");

//        Сортировка методом вставки
        Algorithm.insertSort(arr);

        System.out.println("After sort");
        for (int a : arr) {
            System.out.print(a + ", ");
        }
        System.out.println("\b\b");

        /*
        * Before sort
        * 15, 2, 8, 9, 11, 1, 5, 8, 13, 3, 7
        * After sort
        * 1, 2, 3, 5, 7, 8, 8, 9, 11, 13, 15
        */

//          Интерполяционный поиск

        System.out.println(Algorithm.interpolationSearch(arr, 3));
        System.out.println(Algorithm.interpolationSearch(arr, 4));
        System.out.println(Algorithm.interpolationSearch(arr, 5));

        /*
        * 2
        * -1
        * 3
        */
    }
}
