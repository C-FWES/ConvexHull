package Stack;

import java.util.ArrayList;
import java.util.List;

public class MyStack<E> {
    private List<E> list = new ArrayList<>();

    public void push(E s) {
        list.add(s);
    }

    public E pop() {
        if (list.size() == 0) {
            return null;
        }
        int top = list.size() - 1;
        E result = list.get(top);
        list.remove(top);
        return result;
    }

    public E peek() {
        if (list.size() == 0) {
            return null;
        }
        E result = list.get(list.size() - 1);
        return result;
    }


    public int getSize() {
        return list.size();
    }

}
