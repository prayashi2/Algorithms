package DP;

public class MinNoOfInsAndDel {

    public int minOperations(String str1, String str2)
    {
        // Your code goes here
        int m = str1.length();
        int n = str2.length();
        int dp[][] = new int[m+1][n+1];
        for(int i=1; i<m+1; i++) {
            for(int j=1; j<n+1; j++) {
                if(str1.charAt(i-1)==str2.charAt(j-1)) {
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return m+n-2*dp[m][n];
    }
}
