public class MyStack<T> {
    private MyArrayList<T> list;

    public MyStack() {
        list = new MyArrayList<>();
    }

    public void push(T item) {
        list.addLast(item);
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T item = list.getLast();
        list.removeLast();
        return item;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return list.getLast();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }
}

class TestMyStack {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();

        System.out.println("---- Testing push() ----");
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Stack size: " + stack.size()); // 3

        System.out.println("\n---- Testing peek() ----");
        System.out.println("Top element: " + stack.peek()); // 30

        System.out.println("\n---- Testing pop() ----");
        System.out.println("Popped: " + stack.pop()); // 30
        System.out.println("Popped: " + stack.pop()); // 20
        System.out.println("Stack size after pops: " + stack.size()); // 1

        System.out.println("\n---- Testing isEmpty() ----");
        System.out.println("Is empty? " + stack.isEmpty()); // false

        System.out.println("\n✅ MyStack Tests Completed Successfully!");
    }
}
