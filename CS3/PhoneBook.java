public class PhoneBook implements IMap {
    private Entry[] table;
    private int size;

    public PhoneBook(int capacity) {
        table = new Entry[capacity];
        size = 0;
    }

    @Override
    public PhoneNumber put(Person person, PhoneNumber phoneNumber) {
        int index = getIndex(person);
        Entry current = table[index];

        while (current != null) {
            if (current.key.equals(person)) {
                PhoneNumber oldPhoneNumber = current.value;
                current.value = phoneNumber;
                return oldPhoneNumber;
            }
            current = current.next;
        }

        Entry newEntry = new Entry(person, phoneNumber);
        newEntry.next = table[index];
        table[index] = newEntry;
        size++;
        return null;
    }

    @Override
    public PhoneNumber get(Person person) {
        int index = getIndex(person);
        Entry current = table[index];

        while (current != null) {
            if (current.key.equals(person)) {
                return current.value;
            }
            current = current.next;
        }

        return null;
    }

    @Override
    public PhoneNumber remove(Person person) {
        int index = getIndex(person);
        Entry current = table[index];
        Entry previous = null;

        while (current != null) {
            if (current.key.equals(person)) {
                if (previous == null) {
                    table[index] = current.next;
                } else {
                    previous.next = current.next;
                }
                size--;
                return current.value;
            }
            previous = current;
            current = current.next;
        }

        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndex(Person person) {
        return person.hashCode() % table.length;
    }
}
