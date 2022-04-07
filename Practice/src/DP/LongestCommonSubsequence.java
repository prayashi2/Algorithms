package DP;

import java.util.Arrays;

public class LongestCommonSubsequence {

    static int lcsRec1(int x, int y, String s1, String s2)
    {
        // your code here
        if(x==0 || y==0) {
            return 0;
        }
        if(s1.charAt(0)==s2.charAt(0)) {
            return 1+lcsRec1(x-1, y-1, s1.substring(1), s2.substring(1));
        }
        else return Math.max(lcsRec1(x-1, y, s1.substring(1), s2), lcsRec1(x, y-1, s1, s2.substring(1)));
    }

    static int lcsRec2(int x, int y, String s1, String s2)
    {
        // your code here
        if(x==0 || y==0) {
            return 0;
        }
        if(s1.charAt(x-1)==s2.charAt(y-1)) {
            return 1+lcsRec2(x-1, y-1, s1, s2);
        }
        else return Math.max(lcsRec2(x-1, y, s1, s2), lcsRec2(x, y-1, s1, s2));
    }

    static int lcsMemo(int x, int y, String s1, String s2)
    {
        // your code here
        int dp[][] = new int[x+1][y+1];
        for(int row[] : dp) {
            Arrays.fill(row, -1);
        }
        return lcsMemo(x, y, s1, s2, dp);

    }

    static int lcsMemo(int x, int y, String s1, String s2, int dp[][])
    {
        // your code here
        if(x==0 || y==0) {
            return 0;
        }
        if(dp[x][y]!=-1) {
            return dp[x][y];
        }
        if(s1.charAt(x-1)==s2.charAt(y-1)) {
            return dp[x][y] = 1+lcsMemo(x-1, y-1, s1, s2, dp);
        }
        else return dp[x][y] = Math.max(lcsMemo(x-1, y, s1, s2, dp), lcsMemo(x, y-1, s1, s2, dp));

    }

    static int lcsDP(int x, int y, String s1, String s2)
    {
        // your code here
        int dp[][] = new int[x+1][y+1];
        for(int i=1; i<x+1; i++) {
            for(int j=1; j<y+1; j++) {
                if(s1.charAt(i-1)==s2.charAt(j-1)) {
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else {
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[x][y];
    }

    public static void main(String args[])
    {
        System.out.println(lcsDP(6, 6, "ABCDGH", "AEDFHR"));
    }
}
