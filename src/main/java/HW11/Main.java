package HW11;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String[] strArr = new String[]{"aaa", "bbb", "ccc", "ddd"};
        CustomIterator iter = new CustomIterator(strArr);

        for (int i = 0; i < strArr.length; i++) {
            System.out.println(strArr[i]);
        }

        System.out.println("-------------");
        iter.next();
        iter.delete();

        for (int i = 0; i < strArr.length; i++) {
            System.out.println(strArr[i]);
        }

        System.out.println("-------------");
        QuadraticEquation.root(1,5,3);

        System.out.println("-------------");
        ArrayList<String> str = new ArrayList<>();
        str.add("1");
        str.add("2");
        str.add("3");
        str.add("1");
        System.out.println(str.toString());

        Unique.uniqueMet(str);
        System.out.println(str.toString());

    }
}
