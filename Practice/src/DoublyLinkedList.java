public class DoublyLinkedList {

    Node head;
    public static class Node {
        int data;
        Node prev;
        Node next;

        Node(int d) {
            data=d;
        }
    }

    public static void main(String args[]) {
        DoublyLinkedList l = new DoublyLinkedList();

        l.head = new Node(2);
        Node second = new Node(3);
        Node third = new Node(4);
        Node fourth = new Node(4);
        l.head.next = second;
        second.prev=l.head;
        second.next=third;
        third.prev=second;
        third.next=fourth;
        fourth.prev=third;
        l.print();
        l.push(1);
        l.print();
        l.insertAfter(second, 5);
        l.print();
        l.append(6);
        l.print();
        l.insertBefore(third, 7);
        l.print();
        l.deleteNode(third);
        l.print();
        l.delete(5);
        l.print();

    }

    public void print() {

        Node n = head;
        while(n!=null) {
            System.out.print(n.data);
            n=n.next;
        }
        System.out.println("");
    }

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next=head;
        newNode.prev=null;
        if(head!=null) head.prev=newNode;
        head=newNode;
    }

    public void insertAfter(Node prev, int data) {
        Node newNode = new Node(data);
        if(prev==null) System.out.println("Previous cannot be null");
        newNode.next=prev.next;
        newNode.prev=prev;
        prev.next=newNode;
        if(newNode.next!=null) {
            newNode.next.prev=newNode;
        }
    }

    public void append(int data) {
        Node newNode = new Node(data);
        newNode.next=null;
        if(head==null) {
            newNode.prev=null;
            head=newNode;
            return;
        }
        Node last = head;
        while(last.next!=null) {
            last=last.next;
        }
        last.next=newNode;
        newNode.prev=last;
    }

    public void insertBefore(Node curr, int data) {
        Node newNode = new Node(data);
        if(curr==null) System.out.println("Current cannot be null");
        newNode.next=curr;
        newNode.prev=curr.prev;
        curr.prev=newNode;
        if(newNode.prev!=null) {
            newNode.prev.next=newNode;
        }
        else {
            head=newNode;
        }
    }

    public void delete(int key) {
        Node temp = head;
        if(temp!=null && temp.data==key) {
            temp.next.prev=null;
            head=temp.next;
            return;
        }
        while(temp!=null && temp.data!=key) {
            temp=temp.next;
        }
        temp.prev.next=temp.next;
        if(temp.next!=null) {
            temp.next.prev=temp.prev;
        }

    }

    public void deleteNode(Node del) {
       if(head!=null && head==del) {
           head=del.next;
       }
       if(del.next!=null) {
           del.next.prev=del.prev;
       }
       if(del.prev!=null) {
           del.prev.next=del.next;
       }
       return;
    }
}


