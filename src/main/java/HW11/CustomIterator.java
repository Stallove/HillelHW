package HW11;

public class CustomIterator{
    private String arr[];
    private int index = 0;

    public CustomIterator(String[] arr) {
        this.arr = arr;
    }

    public boolean hasNext() {
        return index < arr.length;
    }

    public String next() {
        if (!hasNext())
            return null;
        index++;
        return arr[index];
    }

    public boolean hasPrevious() {
        return index > 0;
    }

    public String previous() {
        if (!hasPrevious())
            return null;
        index--;
        return arr[index];
    }

    public boolean delete() {
        int i = index;
        while (i + 1 < arr.length) {
            arr[i] = arr[i + 1];
            i++;
        }
        arr[i] = null;
        return true;
    }

    public void set(String str) {
        arr[index] = str;
    }

    public String get() {
        return arr[index];
    }
}
