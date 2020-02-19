package HW11_Iterator_UniqueColl_RootsOfSquare;

import java.util.List;

public class CustomIterator {
    private final List array;
    private int count = 0;

    public CustomIterator(List array) {
        this.array = array;
    }

    public Object hasNext(){
        if(array.get(count + 1) != null && count + 1 < array.size())
            return array.get(count + 1);
        return null;
    }

    public boolean remove() {
        array.remove(count);
        count--;
        return true;
    }

    public Object previous() {
        if(count != 0) {
            count--;
            return array.get(count);
        }
        return null;
    }

    public Object next(){
        if(count < array.size()) {
            count++;
            return array.get(count+1);
        }
        return null;
    }
}
