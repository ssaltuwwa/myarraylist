public class MyQueue<T> {
    private MyLinkedList<T> list;

    public MyQueue() {
        list = new MyLinkedList<>();
    }

    public void enqueue(T item) {
        list.addLast(item);
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T item = list.getFirst();
        list.removeFirst();
        return item;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.getFirst();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }
}

class TestMyQueue {
    public static void main(String[] args) {
        MyQueue<String> queue = new MyQueue<>();

        System.out.println("---- Testing enqueue() ----");
        queue.enqueue("First");
        queue.enqueue("Second");
        queue.enqueue("Third");
        System.out.println("Queue size: " + queue.size()); // 3

        System.out.println("\n---- Testing peek() ----");
        System.out.println("Front element: " + queue.peek()); // "First"

        System.out.println("\n---- Testing dequeue() ----");
        System.out.println("Dequeued: " + queue.dequeue()); // "First"
        System.out.println("Dequeued: " + queue.dequeue()); // "Second"
        System.out.println("Queue size after dequeues: " + queue.size()); // 1

        System.out.println("\n---- Testing isEmpty() ----");
        System.out.println("Is empty? " + queue.isEmpty()); // false

        System.out.println("\n✅ MyQueue Tests Completed Successfully!");
    }
}
