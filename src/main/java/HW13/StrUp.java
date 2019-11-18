package HW13;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StrUp {
    private ArrayList<String> strBefore;
    private ArrayList<String> strAfter;

    public StrUp(ArrayList<String> strBefore) {
        this.strBefore = strBefore;
        strAfter = this.strBefore.stream().forEach(s -> s.toUpperCase());
    }

    public ArrayList<String> getStrBefore() {
        return strBefore;
    }

    public ArrayList<String> getStrAfter() {
        return strAfter;
    }
}
