import java.util.Arrays;

public class EmployeeDatabase {
    private static final int n = 10;
    private Entry[] t;

    public EmployeeDatabase() {
        t = new Entry[n];
    }

    private static class Entry {
        int k;
        Employee e;
        boolean o;

        Entry(int k, Employee e) {
            this.k = k;
            this.e = e;
            o = true;
        }

        @Override
        public String toString() {
            return "k=" + k + ", e=" + e;
        }
    }

    private int h(int k) {
        return k % n;
    }

    private int p(int k) {
        return k % 2;
    }

    public void put(int k, Employee e) {
        int i = h(k);
        int j = i;

        while (t[i] != null && t[i].o && t[i].k != k) {
            i = (i + 1) % n;
            if (i == j) {
                System.out.println("Table is full: " + k);
                return;
            }
        }

        t[i] = new Entry(k, e);
    }

    public Employee get(int k) {
        int i = h(k);
        int j = i;

        while (t[i] != null) {
            if (t[i].k == k && t[i].o) {
                return t[i].e;
            }
            i = (i + 1) % n;
            if (i == j) {
                break;
            }
        }

        return null;
    }

    public void putQuadratic(int k, Employee e) {
        int i = h(k);
        int j = i;
        int c = 0;

        while (t[i] != null && t[i].o && t[i].k != k) {
            i = (j + (c * c)) % n;
            c++;
            if (c >= n) {
                System.out.println("Table is full: " + k);
                return;
            }
        }

        t[i] = new Entry(k, e);
    }

    public Employee getQuadratic(int k) {
        int i = h(k);
        int j = i;
        int c = 0;

        while (t[i] != null) {
            if (t[i].k == k && t[i].o) {
                return t[i].e;
            }
            i = (j + (c * c)) % n;
            c++;
            if (c >= n) {
                break;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return Arrays.toString(t);
    }

    public static class Employee {
        private String n;

        public Employee(String n) {
            this.n = n;
        }

        @Override
        public String toString() {
            return n;
        }
    }

    public static void main(String[] args) {
        EmployeeDatabase d = new EmployeeDatabase();

        d.put(12345, new Employee("John"));
        d.put(67890, new Employee("Jane"));
        d.put(24680, new Employee("Bob"));
        d.put(13579, new Employee("Alice"));
        d.put(86420, new Employee("Tom"));

        System.out.println(d.get(12345));
        System.out.println(d.get(99999));

        System.out.println("\nQuadratic probing");

        d.putQuadratic(12345, new Employee("John"));
        d.putQuadratic(67890, new Employee("Jane"));
        d.putQuadratic(24680, new Employee("Bob"));
        d.putQuadratic(13579, new Employee("Alice"));
        d.putQuadratic(86420, new Employee("Tom"));

        System.out.println(d.getQuadratic(12345));
        System.out.println(d.getQuadratic(99999));

        System.out.println("\nHash table: " + d);
    }
}