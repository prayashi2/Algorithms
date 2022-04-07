package SlidingWindow.Variable;

public class LarSubarrayWithSumK {

    public static int lenOfLongSubarr (int A[], int N, int K) {
        //Complete the function
        int i=0, j=0, sum=0, max=0;
        while(j<N) {
            sum+=A[j];
            if(sum==K) {
                max=Math.max(max, j-i+1);
            }
            else if(sum>K) {
                while(sum>K) {
                    sum-=A[i];
                    i++;
                }
            }
            j++;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lenOfLongSubarr(new int[]{1, 2, 1, 2, 1}, 5, 3));
    }
}
