package DP;

public class LongestCommonSubsequencePrint {

    static String lcsDP(int x, int y, String s1, String s2)
    {
        // your code here
        String dp[][] = new String[x+1][y+1];
        for(int i=0; i<x+1; i++) {
            for(int j=0; j<y+1; j++) {
                dp[i][j] = "";
            }
        }
        System.out.println("S2 " + s2);
        for(int i=1; i<x+1; i++) {
            for(int j=1; j<y+1; j++) {
                if(s1.charAt(i-1)==s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1]+s1.charAt(i-1);
                }
                else {
                    dp[i][j] = dp[i-1][j].length() > dp[i][j-1].length() ? dp[i-1][j] : dp[i][j-1];
                }
            }
        }
        return dp[x][y];
    }

    public static void main(String args[])
    {
        System.out.println(lcsDP(6, 7, "AGGTAB", "GXTXAYB"));
    }
}
