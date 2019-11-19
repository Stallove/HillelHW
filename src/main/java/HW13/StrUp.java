package HW13;


import java.util.List;
import java.util.stream.Collectors;

public class StrUp {
    private List<String> strBefore;
    private List<String> strAfter;

    public StrUp(List<String> str) {
        this.strBefore = str;
        this.strAfter = str.stream().map(e -> e.toUpperCase()).collect(Collectors.toList());
    }

    public List<String> getStrBefore() {
        return strBefore;
    }

    public List<String> getStrAfter() {
        return strAfter;
    }
}
