import java.util.Scanner;

public class PrimeFactorization {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an Integer: ");
        int num = input.nextInt();
        StringBuilder str = new StringBuilder();
        int counter = 0;
        for(int x = 2; x < num; x++)
            if (num % x == 0) {
                counter++;
                str.append(x).append(" ");
            }
        System.out.println("There are " + counter + " factors for the number " + num + ": " + str);
        //Prime Factorization
        System.out.print("Enter an Integer: ");
        num = input.nextInt();
        System.out.print("The prime factorization for " + num + " is: ");
        for (int x = 2; x < num; x++) {
            while (num % x == 0) {
                System.out.print(x + " ");
                num /= x;
            }
        }
        System.out.println(num);
    }
}
