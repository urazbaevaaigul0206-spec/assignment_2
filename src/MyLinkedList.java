import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T> {
    private static class MyNode<T> {
        T data;
        MyNode<T> next;
        MyNode<T> prev;

        MyNode(T data) {
            this.data = data;
        }
    }

    private MyNode<T> head;
    private MyNode<T> tail;
    private int length;

    public void add(T item) {
        MyNode<T> newNode = new MyNode<>(item);

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }


    public void set(int index, T item) {
        if (index < 0 || index >= length) return;
        MyNode<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.data = item;
    }


    public void add(int index, T item) {
        if (index < 0 || index > length) throw new IndexOutOfBoundsException();

        if (index == 0) {
            addFirst(item);
        } else if (index == length) {
            addLast(item);
        } else {
            MyNode<T> prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            MyNode<T> newNode = new MyNode<>(item);
            newNode.next = prev.next;
            prev.next = newNode;
            length++;
        }
    }


    public void addFirst(T item) {
        MyNode<T> node = new MyNode<>(item);
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
        length++;
    }


    public void addLast(T item) {
        add(item);
    }


    public T get(int index) {
        MyNode<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }


    public T getFirst() {
        if (head == null) {
            return null;
        }
        return head.data;
    }


    public T getLast() {
        if (tail == null) {
            return null;
        }
        return tail.data;
    }


    public void remove(int index) {
        if (index < 0 || index >= length) return;
        if (index == 0) {
            head = head.next;
            if (head == null) tail = null;
        } else {
            MyNode<T> prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            prev.next = prev.next.next;
            if (prev.next == null) {
                tail = prev;
            }
        }
        length--;
    }


    public void removeFirst() {
        if (head == null) return;
        head = head.next;
        length--;
        if (length == 0) {
            tail = null;
        }
    }


    public void removeLast() {
        if (length == 0) return;
        if (length == 1) {
            head = tail = null;
            length = 0;
        } else {
            MyNode<T> current = head;
            while (current.next != tail) {
                current = current.next;
            }
            current.next = null;
            tail = current;
            length--;
            if (current.next != null) {
                current.next.prev = current.prev;
            }
        }
    }


    public void sort() {
        if (length < 2) return;

        boolean swapped;
        do {
            swapped = false;
            MyNode<T> current = head;
            while (current != null && current.next != null) {
                if (((Comparable<T>) current.data).compareTo(current.next.data) > 0) {
                    T temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

    public int indexOf(Object item) {
        MyNode<T> current = head;
        for (int i = 0; i < length; i++) {
            if ((item == null && current.data == null) || (item != null && item.equals(current.data))) {
                return i;
            }

            current = current.next;
        }
        return -1;
    }


    public int lastIndexOf(Object item) {
        int lastIdx = -1;
        MyNode<T> current = head;
        for (int i = 0; i < length; i++) {
            if ((item == null && current.data == null) ||
                    (item != null && item.equals(current.data))) {
                lastIdx = i;
            }
            current = current.next;
        }
        return lastIdx;
    }


    public boolean exists(Object item) {
        return indexOf(item) != -1;
    }


    public Object[] toArray() {
        Object[] result = new Object[length];
        MyNode<T> current = head;
        int i = 0;
        while (current != null) {
            result[i++] = current.data;
            current = current.next;
        }
        return result;
    }


    public void clear() {
        head = null;
        tail = null;
        length = 0;
    }


    public int size() {
        return length;
    }



    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;

            public boolean hasNext() {
                return index < size();
            }

            public T next() {
                return get(index++);
            }
        };
    }
}