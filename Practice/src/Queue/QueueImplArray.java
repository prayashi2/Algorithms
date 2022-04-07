package Queue;

public class QueueImplArray {

    int front, rear, capacity;
    int a[];

    QueueImplArray(int capacity) {
        this.capacity=capacity;
        a = new int[capacity];
        int front=rear=0;
    }

    public boolean isEmpty() {
        return front==rear;
    }

    public void enqueue(int data) {
        if(rear==capacity) {
            System.out.println("Queue is full");
            return;
        }
        a[rear]=data;
        rear++;
    }

    public int dequeue() {
        if(front==rear) {
            System.out.println("Queue is empty");
            return 0;
        }
        int del=a[0];
        for(int i=0; i<rear-1; i++) {
            a[i]=a[i+1];
        }
        rear--;
        return del;
    }
    public int peek() {
        if(front==rear) {
            System.out.println("Queue is empty");
            return 0;
        }
        return a[0];
    }

    public void print() {
        for(int i=0; i<rear; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueImplArray q = new QueueImplArray(5);
        System.out.println("Empty " + q.isEmpty());
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        q.print();
        System.out.println("Removed from Queue " + q.dequeue());
        System.out.println("Removed from Queue " + q.dequeue());
        q.print();
        System.out.println("Empty " + q.isEmpty());
        System.out.println("Peek is " + q.peek());
    }
}
