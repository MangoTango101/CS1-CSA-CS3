import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        System.out.println("Hello again, world!");
        //This is a comment!
        int numApples = 15;
        final int PRICE_OF_APPLES = 200;
        System.out.println("The total for " + numApples + " apples:\n" + (numApples*PRICE_OF_APPLES) + " cents.");
        if(numApples*PRICE_OF_APPLES >= 2000)
            System.out.println("Thank you valued customer!");
        for(int n = 10; n > 0; n--)
            System.out.print(n + " ");
        System.out.println();
        for(int n = 150; n <= 300; n++)
        {
            if(n%3 == 0)
                System.out.print(n + " ");
        }
        System.out.println();
        int sum = 0;
        for(int n = 1; n <= 100; n++)
            sum += n;
        System.out.println(sum);
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a Double: ");
        double num = input.nextDouble();
        System.out.println("Square root of " + num + " is: " + Math.sqrt(num));
        System.out.println(num + "^3 = " + Math.pow(num,3));
        System.out.print("Enter an Integer: ");
        int num1 = input.nextInt();
        System.out.print("Enter another Integer: ");
        int num2 = input.nextInt();
        int sub = num1 - num2;
        if(sub >= -10 && sub <= 10)
            System.out.println("Within 10");
        else
            System.out.println("Not Within 10");
        int counter = 0;
        sum = 0;
        int value = 1;
        while(value != 0)
        {
            System.out.print("Enter an Integer");
            value = input.nextInt();
            sum += value;
            counter++;
        }
        counter--;
        double avg = sum/counter;
        System.out.println("Sum of Integers: " + sum);
        System.out.println("Average of Integers: " + avg);
        double[] areas = new double[20];
        areas[0] = 4.56;
        int length = areas.length;
        boolean[] array = {true, true, false, false, true};
        simpleMethod();
        System.out.println(sum(1, 2));
        System.out.println(sumToN(14));
        triangle(7);
        altCaps("Hello World!!");
        Player p1 = new Player();
        p1.playerInfo();
        Player p2 = new Player("Joe", 19);
        p2.playerInfo();
    }
    public static void simpleMethod()
    {
        System.out.println("This is a method!");
    }
    public static int sum(int a, int b)
    {
        int sum = a+b;
        return sum;
    }
    public static int sumToN(int n)
    {
        int sum = 0;
        for(int x = n; x >= 1; x--)
        {
            if(x%3 == 0 || x%5 == 0)
            {
                sum+=x;
            }
        }
        return sum;
    }
    public static void triangle(int n)
    {
        for(int x = 1; x <= n;x++)
        {
            for(int y = 1; y <= x;y++)
            {
                System.out.print(x);
            }
            System.out.println();
        }
    }
    public static void altCaps(String s)
    {
        int length = s.length() - 1;
        String newString = "";
        char z;
        for(int x = 0;  x <= length; x++)
        {
            int y = x + 1;
            if(y%2 != 0)
            {
                z = s.charAt(x);
                z = Character.toUpperCase(z);
            }
            else
            {
                z = s.charAt(x);
                z = Character.toLowerCase(z);
            }
            newString += z;
        }
        System.out.println(newString);
    }
}