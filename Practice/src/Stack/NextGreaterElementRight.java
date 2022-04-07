package Stack;

import java.util.Stack;

public class NextGreaterElementRight {

    public static long[] nextLargerElement(long[] arr, int n)
    {
        // Your code here
        long res[] = new long[n];
        Stack<Long> st = new Stack<Long>();
        for(int i=n-1; i>=0; i--) {
            while(!st.isEmpty() && st.peek()<=arr[i]) st.pop();
            if(st.isEmpty()) res[i]=-1;
            else res[i]=st.peek();
            st.push(arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        long res[] = nextLargerElement(new long[]{1, 3, 2, 4}, 4);
        for(long l : res) {
            System.out.println(l);
        }
    }
}
