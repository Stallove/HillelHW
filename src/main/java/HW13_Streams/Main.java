package HW13_Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

//      Имеется коллекция из String, отфильтровать и вывести на экран все значения,
//      которые написаны в loverCase and length = 4

        List<String> strings = new ArrayList<>();

        strings.add("aaaa");
        strings.add("BBBB");
        strings.add("bbbbb");
        strings.add("ssss");
        strings.add("LLLLL");
        strings.add("hhhh");

        Predicate<String> isLower = str -> str.equals(str.toLowerCase());
        Predicate<String> lessThanFour = str -> str.length() == 4;
        strings.stream().filter(isLower.and(lessThanFour)).forEach(System.out::println);
        /*
            aaaa
            ssss
            hhhh
        */
        System.out.println("=======");

//      Имеется коллекция из Integes, использую стримы посчитать среденее значения всех чисел

        List<Integer> integers = new ArrayList<>();

        integers.add(12);
        integers.add(33);
        integers.add(54);
        integers.add(96);
        integers.add(28);
        System.out.println(integers.stream().mapToInt(in -> in).average());
        /*
            OptionalDouble[44.6]
        */
        System.out.println("======");

//      Имеется коллекция из String, привести все стринги в UPPERCASE и вернуть коллекцию List<Pair>

        StrUp stringsUp = new StrUp(strings);

        System.out.println("Original collection");
        stringsUp.getStrBefore().forEach(System.out::println);
        System.out.println();
        System.out.println("Collection with UPPERCASE Strings");
        stringsUp.getStrAfter().forEach(System.out::println);

        /*
            Collection with UPPERCASE Strings
            AAAA
            BBBB
            BBBBB
            SSSS
            LLLLL
            HHHH
        */

    }
}
