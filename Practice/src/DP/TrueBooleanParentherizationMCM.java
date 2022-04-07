package DP;

import java.util.Arrays;

public class TrueBooleanParentherizationMCM {

    static int countWaysRec(int N, String S){
        // code here
        return solveRec(S, 0, N-1, true);
    }

    static int solveRec(String S, int i, int j, boolean isTrue){
        if(i>j) return 0;
        if(i==j) {
            if(isTrue==true) return S.charAt(i)=='T' ? 1 : 0;
            else return S.charAt(i)=='F' ? 1 : 0;
        }
        int res = 0;
        for(int k=i+1; k<=j-1; k+=2) {
            int lt = solveRec(S, i, k-1, true);
            int lf = solveRec(S, i, k-1, false);
            int rt = solveRec(S, k+1, j, true);
            int rf = solveRec(S, k+1, j, false);
            if(S.charAt(k)=='|') {
                if(isTrue==true) res = res + lt*rt + lt*rf + lf*rt;
                else res = res + lf*rf;
            }
            else if(S.charAt(k)=='&') {
                if(isTrue==true) res = res + lt*rt;
                else res = res + lt*rf + lf*rt + lf*rf;
            }
            else if(S.charAt(k)=='^') {
                if(isTrue==true) res = res + lt*rf + lf*rt;
                else res = res + lt*rt + lf*rf;
            }
        }
        return res;
    }

    //Use 3d-Matrix or Map for memoization (One TC didnt work in GFG)
    static int countWaysMemo(int N, String S){
        // code here
        int dp[][][] = new int[N+1][N+1][2];
        for(int row[][] : dp) {
            for(int col[] : row) {
                Arrays.fill(col, -1);
            }
        }
        return solveMemo(S, 0, N-1, 1, dp);
    }

    static int solveMemo(String S, int i, int j, int isTrue, int dp[][][]){
        if(i>j) return 0;
        if(i==j) {
            if(isTrue==1) return S.charAt(i)=='T' ? 1 : 0;
            else return S.charAt(i)=='F' ? 1 : 0;
        }
        if(dp[i][j][isTrue]!=-1) return dp[i][j][isTrue];
        int res = 0;
        for(int k=i+1; k<=j-1; k+=2) {
            int lt = solveMemo(S, i, k-1, 1, dp);
            int lf = solveMemo(S, i, k-1, 0, dp);
            int rt = solveMemo(S, k+1, j, 1, dp);
            int rf = solveMemo(S, k+1, j, 0, dp);
            if(S.charAt(k)=='|') {
                if(isTrue==1) res = res + lt*rt + lt*rf + lf*rt;
                else res = res + lf*rf;
            }
            else if(S.charAt(k)=='&') {
                if(isTrue==1) res = res + lt*rt;
                else res = res + lt*rf + lf*rt + lf*rf;
            }
            else if(S.charAt(k)=='^') {
                if(isTrue==1) res = res + lt*rf + lf*rt;
                else res = res + lt*rt + lf*rf;
            }
        }
        return dp[i][j][isTrue]=res;
    }
}

