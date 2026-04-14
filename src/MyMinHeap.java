import java.util.Iterator;

public class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> list = new MyArrayList<>();

    public T peekMin() {
        if (list.size() == 0) return null;
        return list.get(0);
    }

    public void insert(T item) {
        list.add(item);
        siftUp(list.size() - 1);
    }

    public T extractMin() {
        if (list.size() == 0) return null;
        T min = list.get(0);

        // Берем последний элемент и ставим его на место первого
        T lastItem = list.get(list.size() - 1);
        list.set(0, lastItem);
        list.remove(list.size() - 1);

        siftDown(0);
        return min;
    }

    private void siftUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (list.get(index).compareTo(list.get(parentIndex)) < 0) {
                swap(index, parentIndex);
                index = parentIndex;
            } else break;
        }
    }

    private void siftDown(int index) {
        while (true) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;

            if (left < list.size() && list.get(left).compareTo(list.get(smallest)) < 0) smallest = left;
            if (right < list.size() && list.get(right).compareTo(list.get(smallest)) < 0) smallest = right;

            if (smallest != index) {
                swap(index, smallest);
                index = smallest;
            } else break;
        }
    }

    private void swap(int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
