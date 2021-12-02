public class QueueAsArray {

    int rear, front, size, capacity;
    int arr[];

    QueueAsArray(int capacity) {
        this.capacity = capacity;
        front = this.size = 0;
        rear = capacity-1;
        arr = new int[capacity];
    }

    boolean isFull(QueueAsArray queue) {
        return (queue.size==queue.capacity);
    }

    boolean isEmpty(QueueAsArray queue) {
        return (queue.size==0);
    }

    void enqueue(int data) {
        if(isFull(this)) return;
        rear=(rear+1)%capacity;
        arr[rear] = data;
        size+=1;
        System.out.println(data + " enqueued to queue");
    }

    int dequeue() {
        if(isEmpty(this)) return Integer.MIN_VALUE;
        int del = arr[front];
        front=(front+1)%capacity;
        size=size-1;
        return del;
    }

    int front() {
        if(isEmpty(this)) return Integer.MIN_VALUE;
        return arr[front];
    }

    int rear() {
        if(isEmpty(this)) return Integer.MIN_VALUE;
        return arr[rear];
    }

}

class QueueAsArrayMain {

    public static void main(String args[]) {
        QueueAsArray q = new QueueAsArray(200);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        System.out.println(q.dequeue() + " dequeued from queue");
        System.out.println(q.front() + " is front");
        System.out.println(q.rear() + " is rear");
    }
}
