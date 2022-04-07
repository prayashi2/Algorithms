package LinkedList;

public class IntersectionPointLL {

    int intersectPointShort(Node head1, Node head2)
    {
        // code here
        Node a = head1;
        Node b = head2;
        while(a!=b) {
            a = a==null ? head2 : a.next;
            b = b==null ? head1 : b.next;
        }
        return a.data;
    }

    int intersectPointLong(Node head1, Node head2)
    {
        // code here
        Node a = head1;
        Node b = head2;
        int count1=1, count2=1;
        while(a!=null) {
            a=a.next;
            count1++;
        }
        while(b!=null) {
            b=b.next;
            count2++;
        }
        a = head1;
        b = head2;
        int diff;
        if(count1>count2) {
            diff=count1-count2;
            while(diff-->0) {
                a=a.next;
            }
        }
        else if(count2>count1) {
            diff=count2-count1;
            while(diff-->0) {
                b=b.next;
            }
        }
        while(a!=b) {
            a=a.next;
            b=b.next;
        }
        return a.data;
    }
}
