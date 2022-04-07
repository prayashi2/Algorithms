package DP;

import java.util.Arrays;

public class PalindromePartitioningMCM {

    static int palindromicPartitionRec(String str)
    {
        // code here
        return solveRec(str, 0, str.length()-1);
    }

    static int solveRec(String str, int i, int j)
    {
        if(i>=j) return 0;
        if(ispalindrome(str, i, j)) return 0;
        int min = Integer.MAX_VALUE;
        for(int k=i; k<=j-1; k++) {
            int tempAns = solveRec(str, i, k) + solveRec(str, k+1, j) + 1;
            min=Math.min(min, tempAns);
        }
        return min;
    }

    static int palindromicPartitionMemo(String str)
    {
        // code here
        int dp[][] = new int[1001][1001];
        for(int row[] : dp) {
            Arrays.fill(row, -1);
        }
        return solveMemo(str, 0, str.length()-1, dp);
    }

    static int solveMemo(String str, int i, int j, int dp[][])
    {
        if(i>=j) return 0;
        if(ispalindrome(str, i, j)) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int min = Integer.MAX_VALUE;
        for(int k=i; k<=j-1; k++) {
            int tempAns = solveMemo(str, i, k, dp) + solveMemo(str, k+1, j, dp) + 1;
            min=Math.min(min, tempAns);
        }
        return dp[i][j]=min;
    }

    static int solveMemoOptimised(String str, int i, int j, int dp[][])
    {
        if(i>=j) return 0;
        if(ispalindrome(str, i, j)) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int min = Integer.MAX_VALUE;
        for(int k=i; k<=j-1; k++) {
            int left, right;
            if(dp[i][k]!=-1) left=dp[i][k];
            else {
                left=solveMemoOptimised(str, i, k, dp);
                dp[i][k]=left;
            }
            if(dp[k+1][j]!=-1) right=dp[k+1][j];
            else {
                right=solveMemoOptimised(str, k+1, j, dp);
                dp[k+1][j]=right;
            }
            int tempAns = left + right + 1;
            min=Math.min(min, tempAns);
        }
        return dp[i][j]=min;
    }

    static boolean ispalindrome(String str, int i, int j)
    {
        while(i<j) {
            if(str.charAt(i)!=str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String args[])
    {
        System.out.println(palindromicPartitionMemo("ababbbabbababa"));
    }
}
