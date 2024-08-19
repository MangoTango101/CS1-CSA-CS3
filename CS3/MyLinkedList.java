public class MyLinkedList {
    public ListNode head;
    public ListNode tail;
    private int size;

    private class ListNode {
        int value;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
            this.next = null;
        }

        @Override
        public String toString() {
            return "" + this.value;
        }
    }

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public MyLinkedList(int value) {
        this.head = new ListNode(value);
        this.tail = this.head;
        this.size = 1;
    }

    public int size() {
        return size;
    }

    public void add(int newValue) {
        ListNode node = new ListNode(newValue);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public void add(int newValue, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        ListNode node = new ListNode(newValue);
        if (index == 0) {
            node.next = head;
            head = node;
            if(size == 0) tail = node;
        } else {
            ListNode current = head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            node.next = current.next;
            current.next = node;
            if(node.next == null) tail = node;
        }
        size++;
    }

    public boolean contains(int value) {
        ListNode current = head;
        while (current != null) {
            if (current.value == value) return true;
            current = current.next;
        }
        return false;
    }

    public int indexOf(int value) {
        ListNode current = head;
        int index = 0;
        while (current != null) {
            if (current.value == value) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        ListNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    public void set(int newValue, int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        ListNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.value = newValue;
    }

    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        size--;
        if (index == 0) {
            int value = head.value;
            head = head.next;
            if(size == 0) tail = null;
            return value;
        }
        ListNode current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        int value = current.next.value;
        if(current.next == tail) tail = current;
        current.next = current.next.next;
        return value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        ListNode current = head;
        while (current != null) {
            builder.append(current.value);
            current = current.next;
            if (current != null) builder.append(", ");
        }
        builder.append("]");
        return builder.toString();
    }
}
