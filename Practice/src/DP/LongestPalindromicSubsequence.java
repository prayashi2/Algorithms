package DP;

public class LongestPalindromicSubsequence {

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int i = 0, j = n-1;
        char c[] = s.toCharArray();
        char temp;
        while(i<j) {
            temp = c[i];
            c[i] = c[j];
            c[j] = temp;
            i++;
            j--;
        }
        return lcs (n, n, s, String.valueOf(c));
    }

    int lcs(int x, int y, String s1, String s2)
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
}
