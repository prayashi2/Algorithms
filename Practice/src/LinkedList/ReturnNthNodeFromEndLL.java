package LinkedList;

public class ReturnNthNodeFromEndLL {

    int getNthFromLast(Node head, int n)
    {
        // Your code here
        Node dummy=new Node(0);
        dummy.next=head;
        Node slow=dummy, fast=dummy;
        while(n-->0) {
            if(fast.next==null) return -1;
            fast=fast.next;
        }
        while(fast.next!=null) {
            fast=fast.next;
            slow=slow.next;
        }
        return slow.next.data;
    }
}
