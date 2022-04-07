package DP;

import java.util.Arrays;

public class EggDroppingPuzzle {

    static int eggDropRec(int n, int f)
    {
        // Your code here
        if(f==0 || f==1) return f;
        if(n==1) return f;
        int res=Integer.MAX_VALUE;
        for(int k=1; k<=f; k++) {
            int tempAns = 1 + Math.max(eggDropRec(n-1, k-1), eggDropRec(n, f-k));
            res=Math.min(res, tempAns);
        }
        return res;
    }

    static int eggDropMemo(int n, int f)
    {
        // Your code here
        int dp[][] = new int[n+1][f+1];
        for(int row[] : dp) {
            Arrays.fill(row, -1);
        }
        return solveMemo(n, f, dp);
    }
    static int solveMemo(int n, int f, int dp[][])
    {
        // Your code here
        if(f==0 || f==1) return f;
        if(n==1) return f;
        int res=Integer.MAX_VALUE;
        if(dp[n][f]!=-1) return dp[n][f];
        for(int k=1; k<=f; k++) {
            int tempAns = 1 + Math.max(solveMemo(n-1, k-1, dp), solveMemo(n, f-k, dp));
            res=Math.min(res, tempAns);
        }
        return dp[n][f]=res;
    }

    static int solveMemoOpt(int n, int f, int dp[][])
    {
        // Your code here
        if(f==0 || f==1) return f;
        if(n==1) return f;
        int res=Integer.MAX_VALUE;
        if(dp[n][f]!=-1) return dp[n][f];
        for(int k=1; k<=f; k++) {
            int bre, nbre;
            if(dp[n-1][k-1]!=-1) bre=dp[n-1][k-1];
            else bre=solveMemoOpt(n-1, k-1, dp);
            if(dp[n][f-k]!=-1) nbre=dp[n][f-k];
            else nbre=solveMemoOpt(n, f-k, dp);
            int tempAns = 1 + Math.max(bre, nbre);
            res=Math.min(res, tempAns);
        }
        return dp[n][f]=res;
    }

    static int eggDropDP(int n, int f)
    {
        // Your code here
        int dp[][] = new int[n+1][f+1];
        for(int i=1; i<=n ; i++) {
            dp[i][1]=1;
            dp[i][0]=0;
        }
        for(int j=1; j<=f; j++) {
            dp[1][j]=j;
        }
        for(int i=2; i<=n ; i++) {
            for(int j=2; j<=f; j++) {
                dp[i][j]=Integer.MAX_VALUE;
                for(int k=1; k<=j; k++) {
                    int tempAns=1+Math.max(dp[i-1][k-1], dp[i][j-k]);
                    dp[i][j]=Math.min(dp[i][j], tempAns);
                }
            }
        }
        return dp[n][f];
    }

    public static void main(String args[])
    {
        System.out.println(eggDropMemo(2, 10));
    }
}
