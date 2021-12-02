public class StackAsLinkedList {

    StackNode head;
    class StackNode {
        int data;
        StackNode next;

        StackNode(int d) {
            data = d;
            next = null;
        }
    }

    void push(int data) {
        StackNode newNode = new StackNode(data);
        if(head==null) {
            head=newNode;
        }
        else {
            StackNode temp = head;
            newNode.next=temp;
            head=newNode;
        }
        System.out.println(data + " pushed into stack");
    }

    int pop() {
        int popped = Integer.MIN_VALUE;
        if(head == null) {
            System.out.println("Stack is Empty");
        }
        else {
            popped = head.data;
            head=head.next;
        }
        return popped;
    }

    int peek() {
        if(head == null) {
            System.out.println("Stack is empty");
            return Integer.MIN_VALUE;
        }
        else {
            return head.data;
        }
    }

    boolean isEmpty() {
        return (head==null);
    }

    public static void main(String args[]) {
        StackAsLinkedList s = new StackAsLinkedList();
        s.push(10);
        s.push(15);
        s.push(20);
        System.out.println(s.pop() + " popped from stack");
        s.push(25);
        System.out.println(s.peek() + " is top element");
    }
}
