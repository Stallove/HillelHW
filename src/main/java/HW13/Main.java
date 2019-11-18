package HW13;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

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

        List<User> userList = new ArrayList<>();

        userList.add(new User("Alex",   "Koporov",  22,     true));
        userList.add(new User("Boris",  "Britva",   48,     true));
        userList.add(new User("Artem",  "Koporovsky",12,    true));
        userList.add(new User("Mark",   "Twen",     80 ,    true));
        userList.add(new User("Mark",   "Cukenberg", 17,    true));
        userList.add(new User("Viktor", "Coy",      30,     true));
        userList.add(new User("Matilda","Luganskaya",12,    false));

        Predicate<User> isLengthName4 = (u) -> u.getName().length() == 4;



        System.out.println();
    }
}
