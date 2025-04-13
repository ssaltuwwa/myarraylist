public class MyLinkedList<T> implements MyList<T> {
    private class MyNode {
        T data;
        MyNode next;
        MyNode prev;

        MyNode(T data) {
            this.data = data;
        }
    }

    private MyNode head;
    private MyNode tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void add(T item) {
        addLast(item);
    }

    @Override
    public void set(int index, T item) {
        MyNode node = getNode(index);
        node.data = item;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        if (index == 0) {
            addFirst(item);
        } else if (index == size) {
            addLast(item);
        } else {
            MyNode current = getNode(index);
            MyNode newNode = new MyNode(item);
            MyNode previous = current.prev;
            previous.next = newNode;
            newNode.prev = previous;
            newNode.next = current;
            current.prev = newNode;
            size++;
        }
    }

    @Override
    public void addFirst(T item) {
        MyNode newNode = new MyNode(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T item) {
        MyNode newNode = new MyNode(item);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public T get(int index) {
        return getNode(index).data;
    }

    @Override
    public T getFirst() {
        if (head == null) throw new IllegalStateException("List is empty");
        return head.data;
    }

    @Override
    public T getLast() {
        if (tail == null) throw new IllegalStateException("List is empty");
        return tail.data;
    }

    @Override
    public void remove(int index) {
        MyNode node = getNode(index);
        unlink(node);
    }

    @Override
    public void removeFirst() {
        if (head == null) throw new IllegalStateException("List is empty");
        unlink(head);
    }

    @Override
    public void removeLast() {
        if (tail == null) throw new IllegalStateException("List is empty");
        unlink(tail);
    }

    @Override
    public void sort() {
        throw new UnsupportedOperationException("Sort not implemented yet.");
    }

    @Override
    public int indexOf(Object object) {
        int index = 0;
        for (MyNode x = head; x != null; x = x.next) {
            if (x.data.equals(object)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        int index = size - 1;
        for (MyNode x = tail; x != null; x = x.prev) {
            if (x.data.equals(object)) {
                return index;
            }
            index--;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int i = 0;
        for (MyNode x = head; x != null; x = x.next) {
            array[i++] = x.data;
        }
        return array;
    }

    @Override
    public void clear() {
        MyNode current = head;
        while (current != null) {
            MyNode next = current.next;
            current.prev = null;
            current.next = null;
            current.data = null;
            current = next;
        }
        head = tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    private MyNode getNode(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index: " + index);
        MyNode current;
        if (index < (size >> 1)) {
            current = head;
            for (int i = 0; i < index; i++) current = current.next;
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) current = current.prev;
        }
        return current;
    }

    private void unlink(MyNode node) {
        MyNode prev = node.prev;
        MyNode next = node.next;

        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
            node.prev = null;
        }

        if (next == null) {
            tail = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }

        node.data = null;
        size--;
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            private MyNode current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}

class TestMyLinkedList {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();

        System.out.println("---- Testing add(T item) ----");
        list.add("A");
        list.add("B");
        list.add("C");
        printList(list);

        System.out.println("\n---- Testing addFirst(T item) ----");
        list.addFirst("Start");
        printList(list);

        System.out.println("\n---- Testing addLast(T item) ----");
        list.addLast("End");
        printList(list);

        System.out.println("\n---- Testing get(index) ----");
        System.out.println("Element at index 2: " + list.get(2));

        System.out.println("\n---- Testing getFirst() ----");
        System.out.println("First element: " + list.getFirst());

        System.out.println("\n---- Testing getLast() ----");
        System.out.println("Last element: " + list.getLast());

        System.out.println("\n---- Testing set(index, item) ----");
        list.set(2, "Middle");
        printList(list);

        System.out.println("\n---- Testing remove(index) ----");
        list.remove(3);
        printList(list);

        System.out.println("\n---- Testing removeFirst() ----");
        list.removeFirst();
        printList(list);

        System.out.println("\n---- Testing removeLast() ----");
        list.removeLast();
        printList(list);

        System.out.println("\n---- Testing indexOf(object) ----");
        System.out.println("Index of Middle: " + list.indexOf("Middle"));

        System.out.println("\n---- Testing lastIndexOf(object) ----");
        list.add("Middle");
        printList(list);
        System.out.println("Last index of Middle: " + list.lastIndexOf("Middle"));

        System.out.println("\n---- Testing exists(object) ----");
        System.out.println("Exists B? " + list.exists("B"));
        System.out.println("Exists Z? " + list.exists("Z"));

        System.out.println("\n---- Testing toArray() ----");
        Object[] array = list.toArray();
        for (Object obj : array) {
            System.out.print(obj + " ");
        }
        System.out.println();

        System.out.println("\n---- Testing size() ----");
        System.out.println("Size: " + list.size());

        System.out.println("\n---- Testing clear() ----");
        list.clear();
        printList(list);
        System.out.println("Size after clear: " + list.size());

        System.out.println("\n✅ MyLinkedList Tests Completed Successfully!");
    }

    private static void printList(MyLinkedList<?> list) {
        System.out.print("[");
        for (Object elem : list) {
            System.out.print(elem + " ");
        }
        System.out.println("]");
    }
}
