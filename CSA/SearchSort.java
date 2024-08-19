import java.util.Arrays;
import java.util.Random;

public class SearchSort {
    private int[] nums;

    public SearchSort(int[] nums) {
        this.nums = nums;
    }

    public SearchSort(int size) {
        this.nums = new int[size];
        initArray();
    }

    public void initArray() {
        Random rand = new Random();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = rand.nextInt(1000) + 1;
        }
    }

    private void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int linearSearch(int key) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public int linearSearchRecur(int key) {
        return linearSearchRecur(key, 0);
    }

    private int linearSearchRecur(int key, int index) {
        if (index >= nums.length) {
            return -1;
        } else if (nums[index] == key) {
            return index;
        } else {
            return linearSearchRecur(key, index + 1);
        }
    }

    public int binarySearch(int key) {
        Arrays.sort(nums);
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == key) {
                return mid;
            } else if (nums[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public int binarySearchRecursive(int key) {
        Arrays.sort(nums);
        return binarySearchRecursive(key, 0, nums.length - 1);
    }

    private int binarySearchRecursive(int key, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (nums[mid] == key) {
            return mid;
        } else if (nums[mid] < key) {
            return binarySearchRecursive(key, mid + 1, high);
        } else {
            return binarySearchRecursive(key, low, mid - 1);
        }
    }

    public void bubbleSort(boolean print) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(j, j + 1);
                }
            }
            if (print) {
                System.out.println(Arrays.toString(nums));
            }
        }
    }

    public void selectionSort(boolean print) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            swap(i, min);
            if (print) {
                System.out.println(Arrays.toString(nums));
            }
        }
    }
}