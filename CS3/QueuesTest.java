/******************************************************************************

These two questions are related to Queues

Write your code inside the methods. Press [>RUN] to run the main which will test your code.

You can refrence your labs to help you solve these problems.

Once you are done:

1. Run the code. Check the output to see if your method works as intended.

2. Write your Name in the NAME variable.

3. Press the download button and then upload your QueuesTest.java file as the submission.

*******************************************************************************/
import java.util.*;
public class QueuesTest
{
  public static String NAME = "your name";


  public static void main (String[]args)
  {
    Queue < Integer > q = makeQ (new int[]
				 {
				 2, 93, 7, 19, 32, 4});
    System.out.println ("minValue((2,93,7,19,32,4)) > " + minValue (q) +
			"  " + (compare (q, makeQ (new int[]
						   {
						   2, 93, 7, 19, 32, 4}))
				&& minValue (makeQ (new int[]
						    {
						    2, 93, 7, 19, 32,
						    4})) ==
				2 ? "Correct" : "Incorrect"));
    q = makeQ (new int[]
	       {
	       5, 2, 1});
    System.out.println ("minValue((5,2,1)) > " + minValue (q) + "  " +
			(compare (q, makeQ (new int[]
					    {
					    5, 2, 1}))
			 && minValue (makeQ (new int[]
					     {
					     5, 2,
					     1})) ==
			 1 ? "Correct" : "Incorrect"));
    q = makeQ (new int[]
	       {
	       7});
    System.out.println ("minValue((7)) > " + minValue (q) + "  " +
			(compare (q, makeQ (new int[]
					    {
					    7})) && minValue (makeQ (new int[]
								     {
								     7})) ==
			 7 ? "Correct" : "Incorrect"));
    System.out.println ();
    System.out.println ("binary(3) > " + binary (3) + "  " +
			(compareS (binary (3), makeQS (new String[]
						       {
						       "1", "10",
						       "11"})) ? "Correct" :
			 "Incorrect"));
    System.out.println ("binary(5) > " + binary (5) + "  " +
			(compareS (binary (5), makeQS (new String[]
						       {
						       "1", "10", "11", "100",
						       "101"})) ? "Correct" :
			 "Incorrect"));
    System.out.println ("binary(6) > " + binary (6) + "  " +
			(compareS (binary (6), makeQS (new String[]
						       {
						       "1", "10", "11", "100",
						       "101",
						       "110"})) ? "Correct" :
			 "Incorrect"));

  }

  public static Queue < Integer > makeQ (int[]a)
  {
    Queue < Integer > m = new LinkedList ();
    for (int i = 0; i < a.length; i++)
      {
	m.offer (a[i]);
      }
    return m;
  }

  public static Queue < String > makeQS (String[]a)
  {
    Queue < String > m = new LinkedList ();
    for (int i = 0; i < a.length; i++)
      {
	m.offer (a[i]);
      }
    return m;
  }

  public static boolean compare (Queue < Integer > a, Queue < Integer > b)
  {
    while (!a.isEmpty () && !b.isEmpty ())
      {
	if (a.poll () != b.poll ())
	  return false;
      }
    if (!a.isEmpty () || !b.isEmpty ())
      return false;
    return true;
  }

  public static boolean compareS (Queue < String > a, Queue < String > b)
  {
    while (!a.isEmpty () && !b.isEmpty ())
      {
	if (!a.poll ().equals (b.poll ()))
	  return false;
      }
    if (!a.isEmpty () || !b.isEmpty ())
      return false;
    return true;
  }


/******************************************************************************

int minValue(Queue<Integer> nums)

Given an already filled Queue of Integers, find and return the minimum value and keep the queue intact (exactly as it was).

You may need more than 1 queue. You cannot use any other Data Structure. (Variables are ok)


minValue( (2,93,7,19,32,4) ) >>> 2

minValue( (5,2,1) ) >>> 1

minValue( (7) ) >>> 7

*******************************************************************************/
  public static int minValue (Queue < Integer > nums)
  {
    Queue < Integer > queue1 = new LinkedList <> ();
    int minVal = nums.poll ();
    queue1.offer (minVal);
    while (!nums.isEmpty ())
      {
	int x = nums.poll ();
	if (x < minVal)
	  {
	    minVal = x;
	  }
	queue1.offer (x);
      }
    while (!queue1.isEmpty ())
      {
	nums.offer (queue1.poll ());
      }

    return minVal;
  }



/******************************************************************************

Queue<String> binary(int n)

Given a positive number n, efficiently generate binary numbers between 1 and n using a Queue.

Return the resulting binary numbers as a Queue. They should be in accending order.

You may need more than 1 queue. You cannot use any other Data Structure. (Variables are ok)

Hint: Look for the pattern that occurs when you poll a number. 
Only create a few numbers at a time, and use the queue to your advantage.


binary(3) >>> (1, 10, 11)

binary(4) >>> (1, 10, 11, 100)

binary(16) >>> (1, 10, 11, 100, 101, 110, 111, 1000, 1001, 1010, 1011, 1100, 1101, 1110, 1111, 10000)


*******************************************************************************/
  public static Queue < String > binary (int n)
  {
    Queue < String > queue1 = new LinkedList <> ();
    Queue < String > queue2 = new LinkedList <> ();
    queue1.offer ("1");
    for (int i = 0; i < n; i++)
      {
	String x = queue1.poll ();
	queue2.offer (x);
	queue1.offer (x + "0");
	queue1.offer (x + "1");
      }
    return queue2;
  }
}
