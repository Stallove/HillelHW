package HW11_Iterator_UniqueColl_RootsOfSquare;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> strArrList = new ArrayList<>();
        strArrList.add("String1");
        strArrList.add("String2");
        strArrList.add("String3");
        strArrList.add("String4");
        strArrList.add("String5");
        CustomIterator iter = new CustomIterator(strArrList);

        for (int i = 0; i < strArrList.size(); i++) {
            System.out.println(strArrList.get(i));
        }

        System.out.println("-------------");
        System.out.println(iter.next());
        System.out.println(iter.remove());

        for (int i = 0; i < strArrList.size(); i++) {
            System.out.println(strArrList.get(i));
        }

        System.out.println("-------------");
        QuadraticEquation.root(1,5,3);

        System.out.println("-------------");
        List<String> str = new ArrayList<>();
        str.add("1");
        str.add("2");
        str.add("3");
        str.add("1");
        System.out.println(str.toString());

        Unique.uniqueMet(str);
        System.out.println(str.toString());

    }
}
