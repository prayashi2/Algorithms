import java.util.ArrayList;
import java.util.List;

public class LinkedList {

    Node head;

    public static class Node {
        int data;
        Node next;
        Node(int d) {
            data=d;
            next=null;
        }
    }

    public void print() {

        Node n = head;
        while(n!=null) {
            System.out.print(n.data);
            n=n.next;
        }
        System.out.println("");
    }

    public static void main(String args[]) {

        LinkedList l = new LinkedList();

        l.head = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(4);
        Node n4 = new Node(5);
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
        //l.deleteNode(n2);
        l.print();
        //System.out.println(l.hasCycle(l.head));

    }

    void push (int data) {
        Node newNode = new Node(data);
        newNode.next= head;
        head = newNode;
    }

    void insertAfter(Node prev, int data) {

        if(prev==null) System.out.println("Previous cannot be null");
        Node newNode = new Node(data);
        newNode.next= prev.next;
        prev.next=newNode;
    }

    void append(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head=newNode;
            return;
        }
        Node last = head;
        while(last.next!=null) last=last.next;
        last.next=newNode;
        return;
    }

    void insertBefore(Node curr, int data) {

        if(curr==null) System.out.println("Current cannot be null");
        Node newNode = new Node(data);
        Node prev = head;
        while(prev.next!=curr) prev=prev.next;
        newNode.next=curr;
        prev.next=newNode;


    }

    void reverse(Node head) {
        Node prev = head;
        Node curr,temp;
        while(prev.next.next!=null) {
            curr = prev.next;
            temp = curr.next;
            curr.next = prev;
            prev = curr;
        }
        prev.next=prev;
    }

    void delete(int key) {
        Node temp = head;
        Node prev=null;
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

    void deleteNode(Node newNode) {
        newNode.data=newNode.next.data;
        newNode.next=newNode.next.next;

    }

    public boolean hasCycle(Node head) {
        List map = new ArrayList();
        while(head!=null){
            if(map.contains(head)) return true;
            map.add(head);
            head=head.next;
        }
        return false;
    }
}
