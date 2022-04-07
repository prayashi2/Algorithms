package LinkedList;

public class RotateLeftLL {

    //This can be used in circular rotate as well
    public Node rotateBetter(Node head, int k) {
        // add code here
        if(head==null || head.next==null || k==0) return head;
        Node curr=head;
        int len=1;
        while(curr.next!=null) {
            curr=curr.next;
            len++;
        }
        curr.next=head;
        k=k%len;
        while(k-->0) curr=curr.next;
        head=curr.next;
        curr.next=null;
        return head;
    }

    public Node rotate(Node head, int k) {
        // add code here
        if(head==null || head.next==null || k==0) return head;
        Node curr=head;
        int count=1;
        while(count<k) {
            curr=curr.next;
            count++;
        }
        if(curr.next==null) return head;
        Node newHead=curr.next;
        curr.next=null;
        Node curr1=newHead;
        while(curr1.next!=null) {
            curr1=curr1.next;
        }
        curr1.next=head;
        return newHead;
    }
}
