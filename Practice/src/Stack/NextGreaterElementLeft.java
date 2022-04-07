package Stack;

import java.util.Stack;

public class NextGreaterElementLeft {

    public static long[] nextLargerElement(long[] arr, int n)
    {
        // Your code here
        long res[] = new long[n];
        Stack<Long> st = new Stack<Long>();
        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && st.peek()<=arr[i]) st.pop();
            if(st.isEmpty()) res[i]=-1;
            else res[i]=st.peek();
            st.push(arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        long res[] = nextLargerElement(new long[]{6, 3, 8, 4, 2, 1}, 6);
        for(long l : res) {
            System.out.println(l);
        }
    }
}
