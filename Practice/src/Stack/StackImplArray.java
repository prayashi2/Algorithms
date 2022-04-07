package Stack;

public class StackImplArray {

    static final int MAX = 5;
    int top;
    int a[] = new int[MAX];

    StackImplArray() {
        top=-1;
    }

    public boolean isEmpty() {
        return top==-1;
    }

    public void push(int data) {
        if(top>=MAX-1) {
            System.out.println("Stack is full");
            return;
        }
        a[++top] = data;
    }

    public int pop() {
        if(top==-1) {
            System.out.println("Stack is empty");
            return 0;
        }
        return a[top--];
    }

    public int peek() {
        if(top==-1) {
            System.out.println("Stack is empty");
            return 0;
        }
        return a[top];
    }

    public void print() {
        for(int i=top; i>=0; i--) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackImplArray s = new StackImplArray();
        System.out.println("Empty " + s.isEmpty());
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(40);
        s.print();
        System.out.println("Empty " + s.isEmpty());
        System.out.println("Popped Element is " + s.pop());
        System.out.println("Popped Element is " + s.pop());
        s.print();
        System.out.println("Peek Element is " + s.peek());
    }
}
