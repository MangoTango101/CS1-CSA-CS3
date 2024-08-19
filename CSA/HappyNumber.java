import java.util.ArrayList;

public class HappyNumber {
    public static boolean isHappy(int x) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        return isHappyHelper(x, list);
    }
    private static boolean isHappyHelper(int x, ArrayList<Integer> list) {
        if (x == 1) {
            return true;
        } else if (list.contains(x)) {
            return false;
        } else {
            list.add(x);
            int next = getNextNumber(x);
            return isHappyHelper(next, list);
        }
    }
    private static int getNextNumber(int x) {
        if (x < 10) {
            return x * x;
        } else {
            int latereg = x%10;
            int next = getNextNumber(x / 10);
            return next + (latereg * latereg);
        }
    }
}