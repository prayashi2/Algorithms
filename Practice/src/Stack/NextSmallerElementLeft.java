package Stack;

import java.util.Stack;

public class NextSmallerElementLeft {

    public static long[] nextSmallerElement(long[] arr, int n)
    {
        // Your code here
        long res[] = new long[n];
        Stack<Long> st = new Stack<Long>();
        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && st.peek()>=arr[i]) st.pop();
            if(st.isEmpty()) res[i]=-1;
            else res[i]=st.peek();
            st.push(arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        long res[] = nextSmallerElement(new long[]{4, 6, 1, 8, 3, 5}, 6);
        for(long l : res) {
            System.out.println(l);
        }
    }
}
