class practiceprobs {
    public static boolean isPalindrome(String str) {
        if (str == null || str.length() <= 1) {
            return true;
        }

        if (str.charAt(0) != str.charAt(str.length() - 1)) {
            return false;
        }
        return isPalindrome(str.substring(1, str.length() - 1));
    }

    public static boolean isPrime(int num, int i) {
        if (num <= 2) { 
            return (num == 2);
        }
        if (i == num) { 
            return true;
        }
        if (num % i == 0) { 
            return false;
        }
        return isPrime(num, i + 1); 
    }

    public void timesTwo(int n) {
        int count = 0;
        while (n % 2 == 0) {
            count++;
            n /= 2;
        }
        if (count > 0) {
            System.out.print("2");
            for (int i = 1; i < count; i++) {
                System.out.print(" * 2");
            }
        }
        if (n > 1) {
            if (count > 0) {
                System.out.print(" * ");
            }
            System.out.print(n);
        }
        System.out.println();
    }

    public int tri(int n) {
        if (n == 1) {
            return 1;
        } else {
            return tri(n-1) + n;
        }
    }

    public int pent(int n) {
        if (n == 1) {
            return 1;
        } else {
            return pent(n-1) + 3*(n-1) + 1;
        }
    }

    public int sumArray(int[] arr, int n) {
        if (n == 0) {
            return 0;
        } else {
            return sumArray(arr, n-1) + arr[n-1];
        }
    }

    public String reverseString(String str) {
        if (str.isEmpty()) {
            return "";
        } else {
            return reverseString(str.substring(1)) + str.charAt(0);
        }
    }

    public void printReverse(String str) {
        if (str.isEmpty()) {
            return;
        } else {
            printReverse(str.substring(1));
            System.out.print(str.charAt(0));
        }
    }

    public boolean isPowerOfN(int num, int base) {
        if (num == 1) {
            return true;
        } else if (num == 0 || num % base != 0) {
            return false;
        } else {
            return isPowerOfN(num / base, base);
        }
    }

    public void printPattern2(int n) {
        if (n <= 0) {
            System.out.print(n + " ");
            return;
        }
        System.out.print(n + " ");
        printPattern2(n - 5);
        System.out.print(n + " ");
    }

    public static void printSquares(int n) {
        if (n == 1) {
            System.out.print(1);
        } else {
            int square = n * n;
            System.out.print(square + ", ");
            printSquares(n - 1);
            System.out.print(", " + square);
        }
    }

    public static String wordWrap(String line, int width) {
        if (line.length() <= width) {
            return line; 
        } else {
            int breakIndex = line.lastIndexOf(" ", width); 
            if (breakIndex == -1) {
                breakIndex = width; 
            }
            String line1 = line.substring(0, breakIndex); 
            String line2 = line.substring(breakIndex).trim();
            return line1 + "\n" + wordWrap(line2, width); 
        }
    }
}
