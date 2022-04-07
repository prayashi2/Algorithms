package DP;

public class MinSumPartition {

    public int minDifferenceDP(int arr[], int n)
    {
        // Your code goes here
        int sum=0;
        for(int i : arr) {
            sum+=i;
        }
        boolean dp[][] = new boolean[n+1][sum+1];
        for(int i=0; i<n+1; i++) {
            dp[i][0]=true;
        }
        for(int j=1; j<sum+1; j++) {
            dp[0][j]=false;
        }
        for(int i=1; i<n+1; i++) {
            for(int j=1; j<sum+1; j++) {
                if(arr[i-1]<=j) {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        int min=Integer.MAX_VALUE;
        int sum1=sum/2;
        boolean res[] = new boolean[sum1+1];
        for(int j=sum/2; j>=0; j--) {
            if(dp[n][j]==true && sum-2*j<min) {
                min=sum-2*j;
                break;
            }
        }
        return min;
    }

    public int minDifferenceDPShort(int arr[], int n)
    {
        // Your code goes here
        int sum=0;
        for(int i : arr) {
            sum+=i;
        }
        boolean dp[] = new boolean[sum+1];
        dp[0]=true;
        for(int i=1; i<n+1; i++) {
            for(int j=sum; j>=0; j--) {
                if(arr[i-1]<=j) {
                    dp[j] = dp[j] || dp[j-arr[i-1]];
                }
            }
        }
        int min=Integer.MAX_VALUE;
        int sum1=sum/2;
        boolean res[] = new boolean[sum1+1];
        for(int j=sum/2; j>=0; j--) {
            if(dp[j]==true && sum-2*j<min) {
                min=sum-2*j;
                break;
            }
        }
        return min;
    }
}
