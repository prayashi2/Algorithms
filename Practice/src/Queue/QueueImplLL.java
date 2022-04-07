package Queue;

public class QueueImplLL {

    QueueImplLLNode front, rear;

    class QueueImplLLNode {

        int data;
        QueueImplLLNode next;

        QueueImplLLNode(int data) {
            this.data=data;
            this.next=null;
        }
    }

    public boolean isEmpty() {
        return front==null;
    }

    public void enqueue(int data) {
        QueueImplLLNode newNode = new QueueImplLLNode(data);
        if(front==null) {
            front=rear=newNode;
            return;
        }
        rear.next=newNode;
        rear=newNode;
    }

    public int dequeue() {
        if(front==null) {
            System.out.println("Queue is Empty");
            return Integer.MIN_VALUE;
        }
        int del=front.data;
        front=front.next;
        if(front==null) rear=null;
        return del;
    }

    public int peek() {
        if(front==null) {
            System.out.println("Queue is Empty");
            return Integer.MIN_VALUE;
        }
        return front.data;
    }

    public void print() {
        QueueImplLLNode n = front;
        while(n!=null) {
            System.out.print(n.data + " ");
            n=n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueImplLL q = new QueueImplLL();
        System.out.println("Empty " + q.isEmpty());
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.print();
        System.out.println("Removed from Queue " + q.dequeue());
        System.out.println("Removed from Queue " + q.dequeue());
        q.print();
        System.out.println("Empty " + q.isEmpty());
        System.out.println("Peek is " + q.peek());
        System.out.println("Front is " + q.front.data);
        System.out.println("Peek is " + q.rear.data);
    }
}
