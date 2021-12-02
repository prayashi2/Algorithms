class QNode {
    int key;
    QNode next;

    QNode(int data) {
        this.key = data;
        this.next = null;
    }
}

public class QueueAsLinkedList {

    QNode rear, front;

    public QueueAsLinkedList() {
        this.front = this.rear =null;
    }

    void enqueue(int data) {
        QNode newNode = new QNode(data);
        System.out.println(data + " enqueued to queue");
        if(this.rear == null) {
            this.front = this.rear = newNode;
            return;
        }
        this.rear.next = newNode;
        this.rear = newNode;
    }

    int dequeue() {
        if(this.front == null) return Integer.MIN_VALUE;
        int del = this.front.key;
        this.front = this.front.next;
        if(front == null) rear=null;
        return del;
    }
}

class QueueAsLinkedListMain {

    public static void main (String args[]) {
        QueueAsLinkedList q = new QueueAsLinkedList();
        q.enqueue(5);
        q.enqueue(10);
        q.enqueue(15);
        q.enqueue(20);
        System.out.println(q.dequeue() + " dequeued from queue");
        System.out.println(q.front.key + " is front");
        System.out.println(q.rear.key + " is rear");

    }
}
