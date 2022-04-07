package SlidingWindow.Fixed;

import java.util.LinkedList;

public class FirstNegIntInEveryWindow {

    public long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        LinkedList<Long> q = new LinkedList<Long>();
        long res[] = new long[N-K+1];
        int i=0, j=0;
        while(j<N) {
            if(A[j]<0) q.add(A[j]);
            if(j-i+1==K) {
                if(!q.isEmpty()) {
                    res[i]=q.getFirst();
                    if(A[i]==q.getFirst()) q.removeFirst();
                }
                i++;
            }
            j++;
        }
        return res;
    }
}
