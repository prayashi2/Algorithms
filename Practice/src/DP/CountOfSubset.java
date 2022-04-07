package DP;

public class CountOfSubset {

    public int perfectSumRec(int arr[],int n, int sum)
    {
        // Your code goes here
        if(sum==0) return 1;
        if(n==0) return 0;
        if(arr[n-1]<=sum) {
            return perfectSumRec(arr, n-1, sum) + perfectSumRec(arr, n-1, sum-arr[n-1]);
        }
        else {
            return perfectSumRec(arr, n-1, sum);
        }
    }

    public int perfectSumDP(int arr[],int n, int sum)
    {
        // Your code goes here
        int M = 1000000007;
        int dp[][] = new int[n+1][sum+1];
        for(int i=0; i<n+1; i++) {
            dp[i][0]=1;
        }
        for(int j=1; j<sum+1; j++) {
            dp[0][j]=0;
        }
        for(int i=1; i<n+1; i++) {
            for(int j=1; j<sum+1; j++) {
                if(arr[i-1]<=j) {
                    dp[i][j]=(dp[i-1][j] + dp[i-1][j-arr[i-1]])%M;
                }
                else {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }

    public int perfectSumDPShort(int arr[],int n, int sum)
    {
        // Your code goes here
        int M = 1000000007;
        int dp[] = new int[sum+1];
        dp[0]=1;
        for(int i=1; i<n+1; i++) {
            for(int j=sum; j>=0; j--) {
                if(arr[i-1]<=j) {
                    dp[j]=(dp[j] + dp[j-arr[i-1]])%M;
                }
            }
        }
        return dp[sum];
    }
}
