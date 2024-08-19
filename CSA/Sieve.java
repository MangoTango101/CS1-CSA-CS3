import java.util.Arrays;
import java.util.Scanner;
public class Sieve{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int totalNums = input.nextInt();
        boolean[] primeNums = new boolean[totalNums];
        Arrays.fill(primeNums, true);
        for (int i = 2; Math.pow(i,i)< Math.sqrt(totalNums); i++)
        {
            if(primeNums[i])
            {
                for(int j = (int) Math.pow(i,i); j < totalNums; j+=i)
                    primeNums[j] = false;
            }
        }
        for (int i = 2; i< primeNums.length; i++)
        {
            if(primeNums[i])
                System.out.println(i);
        }
    }
}