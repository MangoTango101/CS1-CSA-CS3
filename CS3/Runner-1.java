import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.*;
public class Runner {
    public static void main(String[] args) {
        QueueProbs queueProbs = new QueueProbs();
        Queue<Integer> nums = new LinkedList<>(List.of(3, 5, 4, 17, 6, 83, 1, 84, 16, 37));
        Queue<Integer> evenFirstResult = queueProbs.evenFirst(nums);
        System.out.println("Even First Result: " + evenFirstResult);
        Queue<Integer> palindrome1 = new LinkedList<>(List.of(3, 8, 17, 9, 17, 8, 3));
        System.out.println("Is Palindrome 1: " + queueProbs.numPalindrome(palindrome1));
        Queue<Integer> palindrome2 = new LinkedList<>(List.of(3, 10, 17, 9, 17, 8, 3));
        System.out.println("Is Palindrome 2: " + queueProbs.numPalindrome(palindrome2));
        int n = 30;
        Queue<Integer> primes = queueProbs.sieveOfEratosthenes(n);
        System.out.println("Prime Numbers up to " + n + ": " + primes);
    }
}
