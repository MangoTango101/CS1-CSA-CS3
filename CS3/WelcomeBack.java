import java.lang.Math.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/*
public class WelcomeBack {
    public String getMiddle(String str) {
        int high = str.length();
        if (str.length() % 2 == 0) {
            return str.substring(high / 2 - 1, high / 2 + 1);
        } else {
            return str.substring(high / 2, high / 2 + 1);
        }

    }
    public int [] sumNumbers(int n) {
        int[] consecutiveArray = new int[Math.abs(n) + 1];
        int low = 0;
        for (int i = 0; i <= Math.abs(n); i++) {
            low += i;
            consecutiveArray[i] = low;

        }
        return consecutiveArray;
    }
    public int sumDigits(int num)
    {
        int sum=0;
        while(num>0)
        {
            sum+=num%10;
            num=num/10;
        }
        return sum;
    }
    public int keepSummingDigits(int num)
    {
        while (num >= 10) {
            int sum = 0;
            while (num> 0) {
                sum+= num%10;
                num=num/10;
            }
            num=sum;
        }
        return num;

    }
    public String getIntersection(int [] a, int [] b) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i <= a.length; i++) {
            for (int n = 0; n <= b.length; n++) {
                if (a[i] == b[n]) {
                    arrayList.add(a[i]);
                }
            }
        }
        return arrayList.toString();
    }
    public static Map<Integer, Integer> mapLengths(String[] words)
    {
        HashMap<Integer, Integer> map = new HashMap <>();
        for(int i=0;i<=words.length;i++)
        {
            map.put(words[i].length());
        }
    }

    public int sumDigitsRecur(int num) {
        return num == 0 ? 0 : num % 10 + sumDigitsRecur(num / 10);
    }

    public static int sumWithoutCarry(int a, int b)
    {
        int totalSum = 0;
        int mul = 1;
        int sum;
        while (true) {
            if(a==0 && b==0)
                break;
            sum = (a % 10) + (b% 10);
            sum %= 10;
            totalSum = (sum * mul) + totalSum;
            a /= 10;
            b /= 10;
            mul *= 10;

        }
        return totalSum;
    }

    public static int buySell1(int[] stock) {
        int low = stock[0];
        int max=0;
        for(int i=0;i<=stock.length;i++) {
            int num=stock[i];
            int num2=num-low;
            if(num2>max) {
                max=num2;
            }
            if(num<low) {
                low=num;

            }
        }
        return max;
    }
    public static void zeck(String fileName)
    {

    }
}
*/