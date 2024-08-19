import java.util.EmptyStackException;
import java.util.Arrays;
public class MyStack {
    private Integer[] stack;
    private int size;
    public MyStack() {
        this(10);
    }
    public MyStack(int initCap) {
        stack = new Integer[initCap];
        size = 0;
    }
    public boolean isEmpty() {
        return size == 0;
     }
    public Integer peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack[size - 1];
    }
    public Integer pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Integer top = stack[size - 1];
        size--;
        return top;
    }
    public void push(Integer item) {
        if (size == stack.length) {
            doubleCapacity();
        }
        stack[size] = item;
        size++;
    }
    private void doubleCapacity() {
        int capacity = stack.length * 2;
        Integer[] stack2 = new Integer[capacity];
        for (int i = 0; i < size; i++) {
            stack2[i] = stack[i];
        }
        stack = stack2;
    }
    @Override
    public String toString() {
        if (isEmpty()) {
            return "Stack: empty";
        }
        String stackString = "Stack: " + stack[size - 1];
        for (int i=size-2; i>=0; i--) {
            stackString+=" -> "+stack[i];
        }
        return stackString;
    } 
}


