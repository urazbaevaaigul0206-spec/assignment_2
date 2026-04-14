import java.util.Iterator;

public class MyStack<T>  {
    private MyArrayList<T> list = new MyArrayList<>();
    public void push(T item) {
        list.add(item);
    }

    public T pop() {
        if (isEmpty()) return null;
        T item = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return item;
    }

    public T peek() {
        if (isEmpty()) return null;
        return list.get(list.size() - 1);
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }
}
