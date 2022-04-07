package DP;

import java.util.Arrays;

public class ZeroOneKnapsack {

    static int knapSack(int W, int wt[], int val[], int n)
    {
        // your code here
        if(W==0 || n==0) {
            return 0;
        }
        else if(wt[n-1]>W) {
            return knapSack(W, wt, val, n-1);
        }
        else {
            return Math.max(val[n-1]+knapSack(W-wt[n-1], wt, val, n-1), knapSack(W, wt, val, n-1));
        }

    }



    static int knapSackMemo(int W, int wt[], int val[], int n)
    {
        // your code here
        int dp[][] = new int[n+1][W+1];
        for(int row[] : dp) {
            Arrays.fill(row, -1);
        }
        return knapSackRec(W, wt, val, n, dp);
    }

    static int knapSackRec(int W, int wt[], int val[], int n, int dp[][])
    {
        // your code here
        if(W==0 || n==0) {
            return 0;
        }
        if(dp[n][W]!=-1) {
            return dp[n][W];
        }
        if(wt[n-1]>W) {
            return dp[n][W]=knapSackRec(W, wt, val, n-1, dp);
        }
        else {
            return dp[n][W]=Math.max(val[n-1]+knapSackRec(W-wt[n-1], wt, val, n-1, dp), knapSackRec(W, wt, val, n-1, dp));
        }
    }

    static int knapSackDP(int W, int wt[], int val[], int n)
    {
        // your code here
        int dp[][] = new int[n+1][W+1];
        for(int i=1; i<n+1; i++) {
            for(int j=1; j<W+1; j++) {
                if(wt[i-1]>j) {
                    dp[i][j]=dp[i-1][j];
                }
                else {
                    dp[i][j]=Math.max(val[i-1]+dp[i-1][j-wt[i-1]], dp[i-1][j]);
                }
            }
        }
        return dp[n][W];
    }

    static int knapSackDPShort(int W, int wt[], int val[], int n)
    {
        // your code here
        int dp[] = new int[W+1];
        for(int i=1; i<n+1; i++) {
            for(int j=W; j>=0; j--) {
                if(wt[i-1]<=j) {
                    dp[j]=Math.max(val[i-1]+dp[j-wt[i-1]], dp[j]);
                }
            }
        }
        return dp[W];
    }

    public static void main(String args[])
    {
        int wt[] = new int[]{4,5,1};
        int val[] = new int[]{1,2,3};
        System.out.println(knapSackDPShort(4, wt, val, 3));
    }
}
