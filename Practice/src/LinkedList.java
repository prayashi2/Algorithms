import java.util.ArrayList;
import java.util.List;

public class LinkedList {

    Node1 head;

    public static class Node1 {
        int data;
        Node1 next;
        Node1(int d) {
            data=d;
            next=null;
        }
    }

    public void print() {

        Node1 n = head;
        while(n!=null) {
            System.out.print(n.data);
            n=n.next;
        }
        System.out.println("");
    }

    public static void main(String args[]) {

        LinkedList l = new LinkedList();

        l.head = new Node1(1);
        Node1 n2 = new Node1(2);
        Node1 n3 = new Node1(4);
        Node1 n4 = new Node1(5);
        l.head.next=n2;
        n2.next=n3;
        n3.next=n4;
        l.print();
        l.push(0);
        l.print();
        l.insertAfter(n2,3);
        l.print();
        l.append(6);
        l.print();
        l.insertBefore(n4,7);
        l.print();
        l.delete(6);
        //l.deleteNode1(n2);
        l.print();
        //System.out.println(l.hasCycle(l.head));

    }

    void push (int data) {
        Node1 newNode1 = new Node1(data);
        newNode1.next= head;
        head = newNode1;
    }

    void insertAfter(Node1 prev, int data) {

        if(prev==null) System.out.println("Previous cannot be null");
        Node1 newNode1 = new Node1(data);
        newNode1.next= prev.next;
        prev.next=newNode1;
    }

    void append(int data) {
        Node1 newNode1 = new Node1(data);
        if(head == null) {
            head=newNode1;
            return;
        }
        Node1 last = head;
        while(last.next!=null) last=last.next;
        last.next=newNode1;
        return;
    }

    void insertBefore(Node1 curr, int data) {

        if(curr==null) System.out.println("Current cannot be null");
        Node1 newNode1 = new Node1(data);
        Node1 prev = head;
        while(prev.next!=curr) prev=prev.next;
        newNode1.next=curr;
        prev.next=newNode1;


    }

    void reverse(Node1 head) {
        Node1 prev = head;
        Node1 curr,temp;
        while(prev.next.next!=null) {
            curr = prev.next;
            temp = curr.next;
            curr.next = prev;
            prev = curr;
        }
        prev.next=prev;
    }

    void delete(int key) {
        Node1 temp = head;
        Node1 prev=null;
        if(temp!= null && temp.data==key) {
            head=temp.next;
            return;
        }
        while(temp!=null && temp.data!=key) {
            prev = temp;
            temp=temp.next;
        }
        if(temp==null) return;
        prev.next=temp.next;

    }

    void deleteNode1(Node1 newNode1) {
        newNode1.data=newNode1.next.data;
        newNode1.next=newNode1.next.next;

    }

    public boolean hasCycle(Node1 head) {
        List map = new ArrayList();
        while(head!=null){
            if(map.contains(head)) return true;
            map.add(head);
            head=head.next;
        }
        return false;
    }
}
