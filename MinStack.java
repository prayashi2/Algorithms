import java.util.Stack;

public class MinStack {

    Stack<Integer> s;
    int min;

    MinStack() {
        s = new Stack();
    }

    public void push(int data) {
        if(s.isEmpty()) {
            s.push(data);
            min=data;
        }
        else if(data<min) {
            s.push(2*data-min);
            min=data;
        }
        else {
            s.push(data);
        }
        System.out.println("Pushed" + data);
    }

    public void peek() {
        if(s.empty()) {
            System.out.println("Stack is empty");
            return;
        }
        int top = s.peek();
        if(top<min) {
            System.out.println(min);
            min=2*min-top;
        }
        else {
            System.out.println(top);
        }
    }

    public void pop() {
        if(s.isEmpty()) {
            System.out.println("Stack Underflow");
            return;
        }
        int top = s.pop();
        if(top<min) {
            System.out.println("Popped"+ min);
            min=2*min-top;
        }
        else {
            System.out.println("Popped"+ top);
        }
    }

    public int getMin() {
        if(s.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        else {
            System.out.println("Min"+min);
            return min;
        }
    }

}

class MinStackMain {

    public static void main(String args[]) {
        MinStack ms = new MinStack();
        ms.push(2147483646);
        ms.push(2147483646);
        ms.push(2147483647);
        ms.peek();
        ms.pop();
        ms.getMin();
        ms.pop();
        ms.getMin();
        ms.pop();
        ms.push(2147483647);
        ms.peek();
        ms.getMin();
        ms.push(-2147483648);
        ms.peek();
        ms.getMin();
        ms.pop();
        ms.getMin();
    }
}