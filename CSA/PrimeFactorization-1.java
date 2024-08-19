import java.util.Scanner;

public class PrimeFactorization {
    public static void main(String[] args) {
        //Factors

        Scanner input = new Scanner(System.in); //Creating scanner object to get user input
        System.out.print("Enter an Integer: ");
        int num = input.nextInt(); //getting user input
        StringBuilder str = new StringBuilder(); //creating stringbuilder str to later output all the factors
        int counter = 0; //counter to tell how many factors there are
        for(int x = 2; x < num; x++) //creating loop to loop through all numbers less than the number and greater than 2 to exclude 1 and itself
            if (num % x == 0) { //checking if a number from the for loop is a factor or not
                counter++; //counts x as one of the factors but does not store it
                str.append(x).append(" "); //adding x as one of the factors
            }
        System.out.println("There are " + counter + " factors for the number " + num + ": " + str); //outputting the factors

        //Prime Factorization

        System.out.print("Enter an Integer: ");
        num = input.nextInt(); //getting user input
        System.out.print("The prime factorization for " + num + " is: "); //sentence stem to use before in the output due to changes in num
        for (int x = 2; x < num; x++) { //cycling through all number between 1 and num to check if they are divisible.
            while (num % x == 0) { //using a while loop in case a factor can be divisible again. Ex. 12 factors are 2 2 3.
                System.out.print(x + " "); //prints out the factor after the previous sentence stem
                num /= x; //dividing number by x, so then we can check for more prime factors
            }
        }
        if(num > 2) {
            /* in the end of the program, one number remain and if it is 1, it won't be outputted because
            it's not prime and 2 would already be divided in the while loop. */
            System.out.println(num);
        }
    }
}
