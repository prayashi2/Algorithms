package Stack;

public class StackImplLL {

    StackImplLLNode head;

    class StackImplLLNode {

        int data;
        StackImplLLNode next;

        StackImplLLNode(int data) {
            this.data=data;
            this.next=null;
        }
    }

    public boolean isEmpty() {
        return head==null;
    }

    public void push(int data) {
        StackImplLLNode newNode = new StackImplLLNode(data);
        newNode.next=head;
        head=newNode;
    }

    public int pop() {
        int popped=Integer.MIN_VALUE;
        if(head==null) {
            System.out.println("Stack is Empty");
        }
        else {
            popped=head.data;
            head=head.next;
        }
        return popped;
    }

    public int peek() {
        int peek=Integer.MIN_VALUE;
        if(head==null) {
            System.out.println("Stack is Empty");
        }
        else {
            peek=head.data;
        }
        return peek;
    }

    public void print() {
        StackImplLLNode n=head;
        while(n!=null) {
            System.out.print(n.data + " ");
            n=n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackImplLL s = new StackImplLL();
        System.out.println("Empty " + s.isEmpty());
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.print();
        System.out.println("Empty " + s.isEmpty());
        System.out.println("Popped Element is " + s.pop());
        System.out.println("Popped Element is " + s.pop());
        s.print();
        System.out.println("Peek Element is " + s.peek());
    }
}
