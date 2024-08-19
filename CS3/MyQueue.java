public class MyQueue<T> implements QueueADT<T> {
    private MyLinkedList<T> queue;

    public MyQueue() {
        queue = new MyLinkedList<>();
    }

    public MyQueue(T... values) {
        queue = new MyLinkedList<>(values);
    }

    @Override
    public void offer(T item) {
        queue.add(item);
    }

    @Override
    public T poll() {
        if (isEmpty()) return null;
        return queue.remove(0);
    }

    @Override
    public T peek() {
        if (isEmpty()) return null;
        return queue.get(0);
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public void clear() {
        queue = new MyLinkedList<>();
    }
}
