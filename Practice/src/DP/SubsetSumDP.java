package DP;

public class SubsetSumDP {

    static Boolean isSubsetSumRec(int N, int arr[], int sum){
        // code here
        if(sum==0) return true;
        if(N==0) return false;
        if(arr[N-1]<=sum) {
            return isSubsetSumRec(N-1, arr, sum-arr[N-1]) || isSubsetSumRec(N-1, arr, sum);
        }
        else {
            return isSubsetSumRec(N-1, arr, sum);
        }
    }

    static Boolean isSubsetSumDP(int N, int arr[], int sum){
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
                dp[i][j]=dp[i-1][j];
                if(arr[i-1]<=j) {
                    dp[i][j]=dp[i][j] || dp[i-1][j-arr[i-1]];
                }
            }
        }
        return dp[N][sum];
    }

    public static void main(String args[])
    {
        int arr[] = new int[]{3,34,4,12,5,2};
        System.out.println(isSubsetSumDP(6, arr, 9));
    }
}
