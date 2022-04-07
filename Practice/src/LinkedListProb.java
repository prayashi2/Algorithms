import java.util.*;
import java.util.LinkedList;
import java.util.Stack;

class Node1 {
    int data;
    Node1 next;
    Node1(int d)
    {
        next = null;
        data = d;
    }
}

public class LinkedListProb {
    
    public static void main(String args[])
    {
        Node1 one = new Node1(1);
        Node1 two = new Node1(2);
        Node1 three = new Node1(3);
        Node1 four = new Node1(4);
        Node1 five = new Node1(5);
        Node1 six = new Node1(6);
        Node1 seven = new Node1(7);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;
        print(one);
        //System.out.println(isPalindrome(one));
        //List<Character> list = new ArrayList();
        //Node1 n = reverseList(one,list);
        //print(n);
        Node1 n1 = new Node1(2);
        Node1 n2 = new Node1(4);
        Node1 n3 = new Node1(9);
        Node1 n4 = new Node1(5);
        Node1 n5 = new Node1(6);
        Node1 n6 = new Node1(4);
        Node1 n7 = new Node1(9);
        n1.next = n2;
        n2.next = n3;
        //print(n1);
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        //print(n4);
        //Node1 sum=addTwoNumbers(n1,n4);
        //print(sum);
        print(middleNode1(one));
    }

    public static void print(Node1 head) {

        Node1 n = head;
        while(n!=null) {
            System.out.print(n.data);
            n=n.next;
        }
        System.out.println("");
    }

    public static boolean isPalindrome(Node1 head) {
        Stack<Integer> stack = new Stack();
        Node1 fast = head;
        Node1 slow = head;
        while(fast!=null) {
            stack.push(fast.data);
            fast=fast.next;
        }
        while(slow!=null) {
            int pop = stack.pop();
            if(slow.data!=pop) return false;
            slow=slow.next;
        }
        return true;
    }

    public static Node1 reverseList(Node1 head, List<Character> l) {
        List<Character> list = new ArrayList<>();
        Node1 prev = null;
        Node1 curr=head;
        Node1 temp;
        int sum = curr.data;
        String sum1=Integer.toString(sum);
        list.add(sum1.charAt(sum1.length()-1));
        int carry=5;
        list.add(Integer.toString(carry).charAt(0));
        list.get(0);
        System.out.println(list);

        while(curr!=null) {
            temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        head=prev;
        return head;
    }

    public static Node1 addTwoNumbers(Node1 l1, Node1 l2) {

        List<Integer> list = new ArrayList();
        int carry=0;
        carry=sum(l1,l2,carry,list);
        Node1 res = new Node1(list.get(0));
        Node1 temp =res;
        for(int i=1; i<list.size(); i++) {
            temp.next=new Node1(list.get(i));
            temp=temp.next;
        }
        if(carry>0) {
            temp.next=new Node1(carry);
            temp=temp.next;
        }
        return res;
    }

    public static int sum (Node1 l1, Node1 l2, int carry, List<Integer> list) {

        int sum=l1.data+l2.data+carry;
        carry=sum/10;
        list.add(sum%10);
        if(l1.next!=null || l2.next!=null) {
            l1=l1.next!=null?l1.next:new Node1(0);
            l2=l2.next!=null?l2.next:new Node1(0);
            carry=sum(l1,l2,carry,list);
        }
        return carry;
    }

    public static Node1 middleNode1(Node1 head) {
        Node1 temp = head;
        int count=0;
        while(temp!=null) {
            temp=temp.next;
            count++;
        }
        System.out.println(count);
        count=(count/2)+1;
        System.out.println(count);
        Node1 middle=head;
        while(count!=1) {
            middle=middle.next;
            count--;
        }
        return middle;
    }
}
