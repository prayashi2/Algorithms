package LinkedList;

public class LLImpl {

    LLImplNode head;

    static class LLImplNode {
        int data;
        LLImplNode next;

        LLImplNode(int data) {
            this.data=data;
            this.next=null;
        }
    }

    public void insertFirst(int data) {
        LLImplNode newNode = new LLImplNode(data);
        newNode.next=head;
        head=newNode;

    }

    public void insertLast(int data) {
        LLImplNode newNode = new LLImplNode(data);
        if(head==null) {
            head=newNode;
            return;
        }
        LLImplNode n=head;
        while(n.next!=null) {
            n=n.next;
        }
        n.next=newNode;
        return;
    }

    public void insertBefore(LLImplNode curr, int data) {
        if(curr==null) System.out.println("Insert Before position cannot be null");
        LLImplNode newNode = new LLImplNode(data);
        LLImplNode prev=head;
        while(prev!=null && prev.next!=curr) {
            prev=prev.next;
        }
        newNode.next=curr;
        prev.next=newNode;
    }

    public void insertAfter(LLImplNode prev, int data) {
        if(prev==null) System.out.println("Insert After position cannot be null");
        LLImplNode newNode = new LLImplNode(data);
        newNode.next=prev.next;
        prev.next=newNode;
    }

    public void deleteKey(int key) {
        LLImplNode curr=head;
        LLImplNode prev=null;
        if(curr!=null && curr.data==key) {
            head=head.next;
            return;
        }
        while(curr!=null && curr.data!=key) {
            prev=curr;
            curr=curr.next;
        }
        if(curr==null) {
            System.out.println("Key not found");
            return;
        }
        prev.next=curr.next;
    }

    public void deleteAtPosition(int pos) {
        LLImplNode curr=head;
        LLImplNode prev=null;
        if(pos==0 && curr!=null) {
            head=head.next;
            return;
        }
        int count=0;
        while(curr!=null && count!=pos) {
            prev=curr;
            curr=curr.next;
            count++;
        }
        if(curr==null) {
            System.out.println("Key not found");
            return;
        }
        prev.next=curr.next;
    }

    //Conditon : node is not the last node
    public void deleteNode(LLImplNode newNode) {
        newNode.data=newNode.next.data;
        newNode.next=newNode.next.next;
    }

    public void print() {
        System.out.println();
        LLImplNode n = head;
        while(n!=null) {
            System.out.print(n.data + " ");
            n=n.next;
        }
    }

    public static void main(String[] args) {

        LLImpl ll = new LLImpl();
        ll.head = new LLImplNode(10);
        LLImplNode n1 = new LLImplNode(15);
        ll.head.next=n1;
        ll.insertLast(20);
        ll.insertLast(30);
        ll.insertFirst(8);
        ll.insertLast(40);
        ll.insertLast(50);
        ll.print();
        ll.insertFirst(5);
        ll.print();
        ll.deleteKey(30);
        ll.print();
        ll.deleteNode(ll.head);
        ll.print();
        ll.insertBefore(n1, 12);
        ll.print();
        ll.insertAfter(n1,18);
        ll.print();
        ll.deleteAtPosition(6);
        ll.print();
    }
}
