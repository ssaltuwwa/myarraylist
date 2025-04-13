public class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> heap;

    public MyMinHeap() {
        heap = new MyArrayList<>();
    }

    public void insert(T item) {
        heap.add(item);
        heapifyUp(heap.size() - 1);
    }

    public T extractMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        T min = heap.get(0);
        T lastItem = heap.get(heap.size() - 1);
        heap.set(0, lastItem);
        heap.remove(heap.size() - 1);
        heapifyDown(0);
        return min;
    }

    public T peekMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap.get(0);
    }

    public boolean isEmpty() {
        return heap.size() == 0;
    }

    public int size() {
        return heap.size();
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap.get(index).compareTo(heap.get(parentIndex)) < 0) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    private void heapifyDown(int index) {
        int size = heap.size();
        while (index < size) {
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
            int smallest = index;

            if (leftChild < size && heap.get(leftChild).compareTo(heap.get(smallest)) < 0) {
                smallest = leftChild;
            }
            if (rightChild < size && heap.get(rightChild).compareTo(heap.get(smallest)) < 0) {
                smallest = rightChild;
            }
            if (smallest != index) {
                swap(index, smallest);
                index = smallest;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}

class TestMyMinHeap {
    public static void main(String[] args) {
        MyMinHeap<Integer> heap = new MyMinHeap<>();

        System.out.println("---- Testing insert() ----");
        heap.insert(50);
        heap.insert(20);
        heap.insert(30);
        heap.insert(10);
        System.out.println("Heap size: " + heap.size()); // 4

        System.out.println("\n---- Testing peekMin() ----");
        System.out.println("Minimum element: " + heap.peekMin()); // 10

        System.out.println("\n---- Testing extractMin() ----");
        System.out.println("Extracted: " + heap.extractMin()); // 10
        System.out.println("New minimum: " + heap.peekMin()); // 20

        System.out.println("\n---- Testing isEmpty() ----");
        System.out.println("Is empty? " + heap.isEmpty()); // false

        System.out.println("\n✅ MyMinHeap Tests Completed Successfully!");
    }
}
