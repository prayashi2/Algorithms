public class Stack {

    final int MAX = 1000;
    int top;
    int a[] = new int[MAX];

    Stack() {
        top = -1;
    }

     boolean push(int data) {
        if(top==MAX-1) {
            System.out.println("Stack Overflow");
            return false;
        }
        else {
            a[++top]=data;
            System.out.println(data + " pushed into stack");
            return true;
        }
    }

    int pop() {
        if(top<0) {
            System.out.println("Stack Underflow");
            return 0;
        }
        else {
            int del = a[top--];
            return del;
        }
    }

    int peek() {
        if(top<0) {
            System.out.println("Stack UnderFlow");
            return 0;
        }
        else {
            return a[top];
        }
    }

    boolean isEmpty() {
        return (top<0);
    }

}

class StackMain {
    public static void main(String args[]) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack.pop() + " popped from stack");
        stack.push(40);
        System.out.println(stack.peek() + " is top element");
    }
}