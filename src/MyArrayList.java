public class MyArrayList<T> implements MyList<T> {
    private Object[] elements;
    private int size;
    private static final int INITIAL_CAPACITY = 10;

    public MyArrayList() {
        elements = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            Object[] newElements = new Object[elements.length * 2];
            System.arraycopy(elements, 0, newElements, 0, elements.length);
            elements = newElements;
        }
    }

    @Override
    public void add(T item) {
        ensureCapacity();
        elements[size++] = item;
    }

    @Override
    public void set(int index, T item) {
        checkIndex(index);
        elements[index] = item;
    }

    @Override
    public void add(int index, T item) {
        checkIndexForAdd(index);
        ensureCapacity();
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = item;
        size++;
    }

    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    @Override
    public void addLast(T item) {
        add(item);
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }

    @Override
    public T getFirst() {
        return get(0);
    }

    @Override
    public T getLast() {
        return get(size - 1);
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null;
    }

    @Override
    public void removeFirst() {
        remove(0);
    }

    @Override
    public void removeLast() {
        remove(size - 1);
    }

    @Override
    public void sort() {
        throw new UnsupportedOperationException("Sort method not implemented.");
    }

    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--) {
            if (elements[i].equals(object)) {
                return i;
            }
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
        System.arraycopy(elements, 0, array, 0, size);
        return array;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
    }

    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            private int cursor = 0;
            @Override
            public boolean hasNext() {
                return cursor < size;
            }
            @Override
            public T next() {
                return (T) elements[cursor++];
            }
        };
    }
}

class TestMyArrayList {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();

        System.out.println("---- Testing add(T item) ----");
        list.add(10);
        list.add(20);
        list.add(30);
        printList(list);

        System.out.println("\n---- Testing add(index, T item) ----");
        list.add(1, 15);
        printList(list);

        System.out.println("\n---- Testing addFirst(T item) ----");
        list.addFirst(5);
        printList(list);

        System.out.println("\n---- Testing addLast(T item) ----");
        list.addLast(35);
        printList(list);

        System.out.println("\n---- Testing get(index) ----");
        System.out.println("Element at index 2: " + list.get(2));

        System.out.println("\n---- Testing getFirst() ----");
        System.out.println("First element: " + list.getFirst());

        System.out.println("\n---- Testing getLast() ----");
        System.out.println("Last element: " + list.getLast());

        System.out.println("\n---- Testing set(index, item) ----");
        list.set(2, 17);
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
        System.out.println("Index of 17: " + list.indexOf(17));

        System.out.println("\n---- Testing lastIndexOf(object) ----");
        list.add(17); // add duplicate
        printList(list);
        System.out.println("Last index of 17: " + list.lastIndexOf(17));

        System.out.println("\n---- Testing exists(object) ----");
        System.out.println("Exists 30? " + list.exists(30));
        System.out.println("Exists 100? " + list.exists(100));

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

        System.out.println("\n✅ MyArrayList Tests Completed Successfully!");
    }

    private static void printList(MyArrayList<?> list) {
        System.out.print("[");
        for (Object elem : list) {
            System.out.print(elem + " ");
        }
        System.out.println("]");
    }
}
