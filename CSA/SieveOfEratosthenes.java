public class SieveOfEratosthenes {
    public static void main(String[] args) {
        int counter = 0; //initializing counter
        for(int i = 2; i <= 1000; i++) //for loop for all number between 2 and 1000
        {
            for(int j = 1; j <= 1000; j++) //for loop for all numbers between 1 and 1000
            {
                if(i%j == 0) { //checking if number i is divisible by numbers in j
                    counter++; //adding counter to check how many factors there are for i
                }
            }
            if (counter == 2) { //there are 2 factors, its prime
                System.out.print(i + " ");//prints out the prime number
            }
            counter = 0;//resets the number of factors for the next number

        }
    }
}