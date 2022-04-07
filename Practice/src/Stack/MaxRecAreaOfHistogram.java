package Stack;

import java.util.Stack;

public class MaxRecAreaOfHistogram {

    public static long getMaxArea(long hist[], long n)
    {
        // your code here
        Stack<Integer> st1 = new Stack<Integer>();
        Stack<Integer> st2 = new Stack<Integer>();
        int m=hist.length;
        long left[] = new long[m];
        long right[] = new long[m];
        for(int i=0; i<m; i++) {
            while(!st1.isEmpty() && hist[st1.peek()]>=hist[i]) st1.pop();
            if(st1.isEmpty()) left[i]=-1;
            else left[i]=st1.peek();
            st1.push(i);
        }
        for(int i=m-1; i>=0; i--) {
            while(!st2.isEmpty() && hist[st2.peek()]>=hist[i]) st2.pop();
            if(st2.isEmpty()) right[i]=m;
            else right[i]=st2.peek();
            st2.push(i);
        }
        long max=Integer.MIN_VALUE;
        for(int i=0; i<m; i++) {
            long area = (right[i]-left[i]-1)*hist[i];
            max=Math.max(max, area);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(getMaxArea(new long[]{6, 2, 5, 4, 5, 1, 6}, 7));
    }
}
