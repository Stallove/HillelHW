package HW12;

public interface CustomCollection {

    boolean add(String str);

    boolean addAll(String[] strArr);

    boolean addAll(StringCollection strColl);

    boolean delete (int index);

    boolean delete (String str);

    String get(int index);

    boolean contains(String str);

    boolean clear();

    int getSize();

    boolean trim();

    boolean equals(StringCollection collection);

}
