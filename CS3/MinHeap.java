public class MinHeap {
    private Integer[] heap;
    private int size;
    private static final int DEFAULT_CAPACITY = 8;

    public MinHeap() {
        this(DEFAULT_CAPACITY);
    }

    public MinHeap(int capacity) {
        heap = new Integer[capacity + 1];
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Integer peekMinimum() {
        return isEmpty() ? null : heap[1];
    }

    public int getLeftChildIndex(int index) {
        return 2 * index;
    }

    public int getRightChildIndex(int index) {
        return 2 * index + 1;
    }

    public int getParentIndex(int index) {
        return index / 2;
    }

    private void doubleCapacity() {
        Integer[] newHeap = new Integer[heap.length * 2];
        System.arraycopy(heap, 1, newHeap, 1, size);
        heap = newHeap;
    }

    public void insert(int value) {
        if (size == heap.length - 1) {
            doubleCapacity();
        }
        heap[++size] = value;
        bubbleUp(size);
    }

    private void bubbleUp(int index) {
        while (index > 1 && heap[getParentIndex(index)] > heap[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public Integer popMinimum() {
        if (isEmpty()) {
            return null;
        }
        int min = heap[1];
        heap[1] = heap[size];
        heap[size--] = null;
        bubbleDown(1);
        return min;
    }

    private void bubbleDown(int index) {
        while (getLeftChildIndex(index) <= size) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (getRightChildIndex(index) <= size && heap[getRightChildIndex(index)] < heap[getLeftChildIndex(index)]) {
                smallerChildIndex = getRightChildIndex(index);
            }
            if (heap[index] <= heap[smallerChildIndex]) {
                break;
            }
            swap(index, smallerChildIndex);
            index = smallerChildIndex;
        }
    }

    public void display() {
        System.out.println("..............................................................");
        displayHelper(1, 0);
        System.out.println("..............................................................");
    }

    private void displayHelper(int index, int depth) {
        if (index <= size) {
            displayHelper(getRightChildIndex(index), depth + 1);
            System.out.println("    ".repeat(depth) + heap[index]);
            displayHelper(getLeftChildIndex(index), depth + 1);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= size; i++) {
            sb.append(heap[i]);
            if (i < size) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}