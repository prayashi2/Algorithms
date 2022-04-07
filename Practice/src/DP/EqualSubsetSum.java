package DP;

public class EqualSubsetSum {

    static int equalPartition(int N, int arr[])
    {
        // code here
        int sum=0;
        for(int i : arr) {
            sum+=i;
        }
        if (sum%2==0) {
            if(equalPartitionRec(N, arr, sum/2)==true) return 1;
            else return 0;
        }
        else {
            return 0;
        }
    }

    static boolean equalPartitionRec(int N, int arr[], int sum)
    {
        // code here
        if(sum==0) return true;
        if(N==0) return false;
        return equalPartitionRec(N-1, arr, sum-arr[N-1]) || equalPartitionRec(N-1, arr, sum);
    }

    static Boolean equalPartitionDP(int N, int arr[], int sum){
        // code here
        boolean dp[][] = new boolean[N+1][sum+1];
        for(int i=0; i<N+1; i++) {
            dp[i][0]=true;
        }
        for(int j=1; j<sum+1; j++) {
            dp[0][j]=false;
        }
        for(int i=1; i<N+1; i++) {
            for(int j=1; j<sum+1; j++) {
                if(arr[i-1]<=j) {
                    dp[i][j]=dp[i-1][j] || dp[i-1][j-arr[i-1]];
                }
                else {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[N][sum];
    }

    static boolean equalPartitionDPShort(int N, int arr[], int sum)
    {
        // code here
        boolean dp[] = new boolean[sum+1];
        dp[0]=true;
        for(int  i=1; i<N+1; i++) {
            for(int j=sum; j>=0; j--) {
                if(arr[i-1]<=j) {
                    dp[j] = dp[j] || dp[j-arr[i-1]];
                }
            }
        }
        return dp[sum];
    }
}
