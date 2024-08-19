/******************************************************************************

These two questions are related to LinkedLists

Write your code inside the methods. Press [>RUN] to run the main which will test your code.

You can refrence your labs to help you solve these problems.

Once you are done:

1. Run the code. Check the output to see if your method works as intended.

2. Write your Name in the NAME variable.

3. Press the download button and then upload your LinkedTest.java file as the submission.

*******************************************************************************/
import java.util.*;

class ListNode {

    int val;
    ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
    public String toString() {
        return "" + this.val;
    }
}

public class LinkedTest
{
    public static String NAME = "your name";
    
    
	public static void main(String[] args) {
	    ListNode head = addAll(new int[]{1,2,3,4,5,6,7,8,9});
        System.out.println("getNthFromLast(2) > "+getNthFromLast(2,head)+ "  " +( getNthFromLast(2,head) == 8 ? "Correct" : "Incorrect"));
        head = addAll(new int[]{1,2,3,4,5,6,7,8,9});
        System.out.println("getNthFromLast(5) > "+getNthFromLast(5,head)+ "  " +( getNthFromLast(5,head) == 5 ? "Correct" : "Incorrect"));
        head = addAll(new int[]{1,2,3,4,5,6,7,8,9});
        System.out.println("getNthFromLast(9) > "+getNthFromLast(9,head)+ "  " +( getNthFromLast(9,head) == 1 ? "Correct" : "Incorrect"));
        System.out.println();
        head = addAll(new int[]{2,1,4,3});
        ListNode sorted = sortList(head);
        System.out.println("sortList([2,1,4,3]) > "+toString(sorted)+ "  " +( toString(sorted).equals("[1, 2, 3, 4]") ? "Correct" : "Incorrect"));
        head = addAll(new int[]{1,2,3});
        sorted = sortList(head);
        System.out.println("sortList([1,2,3]) > "+toString(sorted)+ "  " +( toString(sorted).equals("[1, 2, 3]") ? "Correct" : "Incorrect"));
        head = addAll(new int[]{4,3,2,1});
        sorted = sortList(head);
        System.out.println("sortList([4,3,2,1]) > "+toString(sorted)+ "  " +( toString(sorted).equals("[1, 2, 3, 4]") ? "Correct" : "Incorrect"));

	}
	
    public static ListNode add(int newVal, ListNode head) {
		
		if( head == null) {
			head = new ListNode(newVal);
		}
		else {
			ListNode current = head;
			while(current.next != null) {
				current = current.next;
			}
			current.next = new ListNode(newVal);
			
		}
		return head;
	}
	
	public static ListNode addAll(int[] vals){
	    ListNode head = null;
	    for (int val : vals)
			head = add(val, head);
		return head;
	}
	
	public static String toString(ListNode head) {
		String result = "[";
		ListNode current = head;
		while(current != null) {
			result += current.val;
			current = current.next;
			if(current != null) {
				result += ", ";
			}
		}
		return result + "]";
	}
	
	

/******************************************************************************

int getNthFromLast(int n, ListNode head)

Write the method int getNthFromLast().

This method returns the value of the node that is n before the end of the linked list.

You cannot use any other Data Structure. (Variables are ok)


Linked List : 1->2->3->4->5->6->7->8->9

getNthFromLast(2) >>> 8

getNthFromLast(5) >>> 5

getNthFromLast(9) >>> 1

*******************************************************************************/
	public static int getNthFromLast(int n, ListNode head){
    ListNode node1 = head;
    ListNode node2 = head;
    for (int i = 0; i < n; i++) {
        if (node2 == null) {
            return -1;
        }
         node2 = node2.next;
    }
    while (node2 != null) {
        node1 = node1.next;
        node2 = node2.next;
    }
    return node1.val;
}


/******************************************************************************

ListNode sortList(ListNode head)

Write the method ListNode sortList(ListNode head).

This method will sort all the int values in the linked list to be in increasing order.

You can use any sorting algorithm of your choice, however you cannot use any other data structures.


Linked List : 2->1->4->3

sortList(head) >>> 1->2->3->4


*******************************************************************************/
	public static ListNode sortList(ListNode head) {
    ListNode temp1= new ListNode(0);
    ListNode node1 = head;
    while (node1 != null) {
        ListNode node2 = temp1;
        while (node2.next != null && node2.next.val < node1.val) {
            node2 = node2.next;
        }
        ListNode temp2 = node1.next;
        node1.next = node2.next;
        node2.next = node1;
        node1 = temp2;
    }
    return temp1.next;
}

}
