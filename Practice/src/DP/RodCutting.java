package DP;

public class RodCutting {

    public int cutRod(int price[], int n) {
        //code here
        int total=price.length;
        int wt[] = new int[total];
        for(int i=0; i<total; i++) {
            wt[i]=i+1;
        }
        int dp[][] = new int[total+1][n+1];
        for(int i=1; i<total+1; i++) {
            for(int j=1; j<n+1; j++) {
                if(wt[i-1]<=j) {
                    dp[i][j] = Math.max(dp[i-1][j], price[i-1]+dp[i][j-wt[i-1]]);
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[total][n];
    }
}
