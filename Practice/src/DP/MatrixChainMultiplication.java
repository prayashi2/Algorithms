package DP;

import java.util.Arrays;

public class MatrixChainMultiplication {

    static int matrixMultiplicationRec(int N, int arr[])
    {
        // code here
        return solveRec(arr, 1, N-1);
    }

    static int solveRec(int arr[], int i, int j)
    {
        if(i>=j) return 0;
        int min = Integer.MAX_VALUE;
        for(int k=i; k<=j-1; k++) {
            int tempAns = solveRec(arr, i, k) + solveRec(arr, k+1, j) + (arr[i-1]*arr[k]*arr[j]);
            min=Math.min(min, tempAns);
        }
        return min;
    }

    static int matrixMultiplicationMemo(int N, int arr[])
    {
        // code here
        int dp[][] = new int[1001][1001];
        for(int row[] : dp) {
            Arrays.fill(row, -1);
        }
        return solveMemo(arr, 1, N-1, dp);
    }

    static int solveMemo(int arr[], int i, int j, int dp[][])
    {
        if(i>=j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int min = Integer.MAX_VALUE;
        for(int k=i; k<=j-1; k++) {
            int tempAns = solveMemo(arr, i, k, dp) + solveMemo(arr, k+1, j, dp) + (arr[i-1]*arr[k]*arr[j]);
            min=Math.min(min, tempAns);
        }
        return dp[i][j]=min;
    }

    public static void main(String args[])
    {
        System.out.println(matrixMultiplicationMemo(5, new int[]{40, 20, 30, 10, 30}));
    }
}
