package DP;

public class LongestCommonSubstring {

    int longestCommonSubstrRec(String S1, String S2, int n, int m){
        // code here
        return longestCommonSubstrRec(S1, S2, m, n, 0);
    }

    int longestCommonSubstrRec(String S1, String S2, int n, int m, int count){
        // code here
        if(n==0 || m==0) {
            return count;
        }
        if(S1.charAt(n-1)==S2.charAt(m-1)) {
            count = longestCommonSubstrRec(S1, S2, n-1, m-1, count+1);
        }
        count = Math.max(count,Math.max(longestCommonSubstrRec(S1, S2, n-1, m, 0), longestCommonSubstrRec(S1, S2, n, m-1, 0)));

        return count;
    }

    int longestCommonSubstrDP(String S1, String S2, int n, int m){
        // code here
        int dp[][] = new int[n+1][m+1];
        int ans=0;
        for(int i=1; i<n+1; i++) {
            for(int j=1; j<m+1; j++) {
                if(S1.charAt(i-1)==S2.charAt(j-1)) {
                    dp[i][j] =1+ dp[i-1][j-1];
                    ans = Math.max(ans, dp[i][j]);
                }
                else {
                    dp[i][j]=0;
                }
            }
        }
        return ans;
    }
}
