import java.util.EmptyStackException;

public class MyStack<T> {
    private Object[] stack;
    private int size;

    public MyStack() {
        this(10);
    }

    public MyStack(int initCap) {
        stack = new Object[initCap];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (T) stack[size - 1];
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T top = (T) stack[size - 1];
        size--;
        return top;
    }

    public void push(T item) {
        if (size == stack.length) {
            doubleCapacity();
        }
        stack[size] = item;
        size++;
    }

    private void doubleCapacity() {
        int capacity = stack.length * 2;
        Object[] stack2 = new Object[capacity];
        System.arraycopy(stack, 0, stack2, 0, size);
        stack = stack2;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Stack: empty";
        }
        StringBuilder stackString = new StringBuilder("Stack: ").append(stack[size - 1]);
        for (int i = size - 2; i >= 0; i--) {
            stackString.append(" -> ").append(stack[i]);
        }
        return stackString.toString();
    }
}
