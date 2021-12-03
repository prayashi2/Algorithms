import java.util.*;
import java.util.LinkedList;
import java.util.Stack;

class Node {
    int data;
    Node next;
    Node(int d)
    {
        next = null;
        data = d;
    }
}

public class LinkedListProb {
    
    public static void main(String args[])
    {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;
        print(one);
        //System.out.println(isPalindrome(one));
        //List<Character> list = new ArrayList();
        //Node n = reverseList(one,list);
        //print(n);
        Node n1 = new Node(2);
        Node n2 = new Node(4);
        Node n3 = new Node(9);
        Node n4 = new Node(5);
        Node n5 = new Node(6);
        Node n6 = new Node(4);
        Node n7 = new Node(9);
        n1.next = n2;
        n2.next = n3;
        //print(n1);
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        //print(n4);
        //Node sum=addTwoNumbers(n1,n4);
        //print(sum);
        print(middleNode(one));
    }

    public static void print(Node head) {

        Node n = head;
        while(n!=null) {
            System.out.print(n.data);
            n=n.next;
        }
        System.out.println("");
    }

    public static boolean isPalindrome(Node head) {
        Stack<Integer> stack = new Stack();
        Node fast = head;
        Node slow = head;
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

    public static Node reverseList(Node head, List<Character> l) {
        List<Character> list = new ArrayList<>();
        Node prev = null;
        Node curr=head;
        Node temp;
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

    public static Node addTwoNumbers(Node l1, Node l2) {

        List<Integer> list = new ArrayList();
        int carry=0;
        carry=sum(l1,l2,carry,list);
        Node res = new Node(list.get(0));
        Node temp =res;
        for(int i=1; i<list.size(); i++) {
            temp.next=new Node(list.get(i));
            temp=temp.next;
        }
        if(carry>0) {
            temp.next=new Node(carry);
            temp=temp.next;
        }
        return res;
    }

    public static int sum (Node l1, Node l2, int carry, List<Integer> list) {

        int sum=l1.data+l2.data+carry;
        carry=sum/10;
        list.add(sum%10);
        if(l1.next!=null || l2.next!=null) {
            l1=l1.next!=null?l1.next:new Node(0);
            l2=l2.next!=null?l2.next:new Node(0);
            carry=sum(l1,l2,carry,list);
        }
        return carry;
    }

    public static Node middleNode(Node head) {
        Node temp = head;
        int count=0;
        while(temp!=null) {
            temp=temp.next;
            count++;
        }
        System.out.println(count);
        count=(count/2)+1;
        System.out.println(count);
        Node middle=head;
        while(count!=1) {
            middle=middle.next;
            count--;
        }
        return middle;
    }
}
