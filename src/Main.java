public class Main {
    public static void main(String[] args) {

        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);

        System.out.println(list.get(1)); // 20

        MyStack<Integer> stack = new MyStack<>();
        stack.push(5);
        stack.push(10);
        System.out.println(stack.pop()); // 10

        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        System.out.println(queue.dequeue()); // 1

        MyMinHeap<Integer> heap = new MyMinHeap<>();
        heap.insert(5);
        heap.insert(2);
        heap.insert(8);
        System.out.println(heap.extractMin()); // 2
    }
}