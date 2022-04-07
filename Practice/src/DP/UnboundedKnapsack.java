package DP;

public class UnboundedKnapsack {

    static int knapSackDP(int N, int W, int val[], int wt[])
    {
        // code here
        int dp[][] = new int[N+1][W+1];
        for(int i=1; i<N+1; i++) {
            for(int j=1; j<W+1; j++) {
                if(wt[i-1]<=j) {
                    dp[i][j] = Math.max(dp[i-1][j], val[i-1]+dp[i][j-wt[i-1]]);
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[N][W];
    }

    static int knapSackDPShort(int N, int W, int val[], int wt[])
    {
        // code here
        int dp[] = new int[W+1];
        for(int i=0; i<N; i++) {
            for(int j=0; j<W+1; j++) {
                if(wt[i]<=j) {
                    dp[j] = Math.max(dp[j], val[i]+dp[j-wt[i]]);
                }
            }
        }
        return dp[W];
    }
}
