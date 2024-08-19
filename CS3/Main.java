/******************************************************************************

These two questions are related to Stacks

You will need to use the MyStack Class for this to work. Upload your "MyStack" by pressing the "Upload File" button to the left of [>RUN]

Hopefully your MyStack works!

Write your code inside the methods. Press [>RUN] to run the main which will test your code.

You can refrence your labs to help you solve these problems.

Once you are done:

1. Run the code. Check the output to see if your method works as intended.

2. Write your Name in the NAME variable.

3. Press the download button and then upload your Main.java file as the submission.

*******************************************************************************/
import java.util.*;
public class Main
{
    public static String NAME = "your name";
    
    
	public static void main(String[] args) {
        System.out.println("[1,2,2,4,4,8] > removeDups > [1,2,4,8] "+(compare(removeDups(makeStack(new int[]{1,2,2,4,4,8})),makeStack(new int[]{1,2,4,8})) ? "Correct" : "Incorrect"));
	    System.out.println("[7,7,4,2,2,2] > removeDups > [7,4,2] "+(compare(removeDups(makeStack(new int[]{7,7,4,2,2,2})),makeStack(new int[]{7,4,2})) ? "Correct" : "Incorrect"));
	    System.out.println("[1,1] > removeDups > [1] "+(compare(removeDups(makeStack(new int[]{1,1})),makeStack(new int[]{1})) ? "Correct" : "Incorrect"));
        System.out.println();
        System.out.println("[1,2,3,4] > merge > [5,6]  >>> [1,2,3,4,5,6] "+(compare(merge(makeStack(new int[]{1,2,3,4}),makeStack(new int[]{5,6})),makeStack(new int[]{1,2,3,4,5,6}))? "Correct" : "Incorrect"));
	    System.out.println("[1,3,5] > merge > [2,4,6]  >>> [1,2,3,4,5,6] "+(compare(merge(makeStack(new int[]{1,3,5}),makeStack(new int[]{2,4,6})),makeStack(new int[]{1,2,3,4,5,6}))? "Correct" : "Incorrect"));
	    System.out.println("[1] > merge > [2,8]  >>> [1,2,8] "+(compare(merge(makeStack(new int[]{1}),makeStack(new int[]{2,8})),makeStack(new int[]{1,2,8}))? "Correct" : "Incorrect"));
        System.out.println();
	}
	
	public static MyStack makeStack(int[] a){
	    MyStack m = new MyStack(4);
	    for(int i = 0;i < a.length;i++){
	        m.push(a[i]);
	    }
	    return m;
	}
	
	public static boolean compare(MyStack a, MyStack b){
	    while(!a.isEmpty() && !b.isEmpty()){
	        if(a.pop() != b.pop())
	            return false;
	    }
	    if (!a.isEmpty() || !b.isEmpty())
	        return false;
	    return true;
	}
	

/******************************************************************************

MyStack removeDups(MyStack s)

This method takes a stack as input, removes duplicates from the stack that are next to each other, and then returns is back in the correct order.

You can only use MyStack Data Stuctures. No other objects or variables can be created or used. You can make more MyStack objects if needed.

[1,2,2,4,4,8] > removeDups > [1,2,4,8]

[7,7,4,2,2,2] > removeDups > [7,4,2]

[1,1] > removeDups > [1]

*******************************************************************************/
	public static MyStack removeDups(MyStack s) {
    MyStack stack = new MyStack();

    while (!s.isEmpty()) {
        Integer x = s.pop();
        if (stack.isEmpty()) {
            stack.push(x);
        }
        if(!x.equals(stack.peek())){
             stack.push(x);
        }
    }
    
    while (!stack.isEmpty()) {
        s.push(stack.pop());
    }

    return s;
}
	
/******************************************************************************

MyStack merge(MyStack a, MyStack b)

This method merges two sorted stacks into one storted stack.

The returned stack must keep the correct sorted order of largest value on top.

You can only use MyStack Data Stuctures. However, you may need more than one.


[1,2,3,4] > merge > [5,6]  >>> [1,2,3,4,5,6]

[1,3,5] > merge > [2,4,6]  >>> [1,2,3,4,5,6]

[1] > merge > [2,8]  >>> [1,2,8]


*******************************************************************************/
	public static MyStack merge(MyStack a, MyStack b) {
    MyStack returnStack = new MyStack();
    MyStack stack2 = new MyStack();

    while (!a.isEmpty() || !b.isEmpty()) {
        if (a.isEmpty()) 
        {
            stack2.push(b.pop());
        } 
        if (b.isEmpty()) 
        {
            stack2.push(a.pop());
        } 
        else {
            if (a.peek() > b.peek())
            {
                stack2.push(a.pop());
            } 
            if(a.peek() <= b.peek())
            {
                stack2.push(b.pop());
            }
        }
    }
    while (!stack2.isEmpty()) {
        returnStack.push(stack2.pop());
    }
    return returnStack;
	}
}