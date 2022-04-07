package Stack;

import java.util.Stack;

public class StockSpan {

    public static int[] calculateSpan(int price[], int n)
    {
        // Your code here
        Stack<Integer> st = new Stack<Integer>();
        int res[] = new int[n];
        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && price[st.peek()]<=price[i]) st.pop();
            if(st.isEmpty()) res[i]=-1;
            else res[i]=st.peek();
            st.push(i);
        }
        for(int i=0; i<n; i++) {
            res[i]=i-res[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int res[] = calculateSpan(new int[]{100, 80, 60, 70, 60, 65, 70, 75}, 8);
        for(int l : res) {
            System.out.print(l + " ");
        }
    }
}
