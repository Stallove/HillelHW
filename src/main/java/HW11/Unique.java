package HW11;

import java.util.List;

public class Unique {
    private static String check;
    public static boolean uniqueMet(List<String> aL) {
        for (int i = 0; i < aL.size(); i++) {
            check = aL.get(i);
            for (int j = i + 1; j < aL.size(); j++) {
                if (check.equals(aL.get(j))) {
                    aL.remove(j);
                }
            }
        }
        return true;
    }
}
