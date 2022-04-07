package Stack;

import java.util.Stack;

public class NextSmallerElementRight {

    public static long[] nextSmallerElement(long[] arr, int n)
    {
        // Your code here
        long res[] = new long[n];
        Stack<Long> st = new Stack<Long>();
        for(int i=n-1; i>=0; i--) {
            while(!st.isEmpty() && st.peek()>=arr[i]) st.pop();
            if(st.isEmpty()) res[i]=-1;
            else res[i]=st.peek();
            st.push(arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        long res[] = nextSmallerElement(new long[]{1, 6, 4, 2}, 4);
        for(long l : res) {
            System.out.println(l);
        }
    }
}
