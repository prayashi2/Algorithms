import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArraySol {

    public static void main (String args[]) {
        //System.out.println(maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
       /* int[] result = plusOne(new int[] {9,9,9,2});
        for(int i =0; i <result.length; i++) {
            System.out.println(result[i]);
        } */
        //System.out.println(generate(5));
        System.out.println(myPow(0.00001, 2147483647));
    }

    public static double myPow(double x, int n) {
        if(x==0) return 0;
        if(n==0) return 1;
        if(n>0) return x*myPow(x,n-1);
        if(n<0) return myPow(x,n+1)/x;
        return 0;
    }

    public boolean isPowerOfThree(int n) {
        return div(n);
    }

    public static boolean div(int n) {
        if(n==3) return true;
        if(n<3 ) return false;
        else return div(n/3);
    }

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i : nums) {
            if(map.containsKey(i)) map.put(i, map.get(i)+1);
            else map.put(i,1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue()==1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i=0; i<=numRows-1; i++) {
            List<Integer> subRes = new ArrayList<Integer>();
            for(int j=0; j<=i; j++) {
                if(j==0 || j==i) subRes.add(1);
                else subRes.add(result.get(i-1).get(j-1)+result.get(i-1).get(j));
            }
            result.add(subRes);
        }
        return result;
    }

    public static int[] plusOne(int[] digits) {
        for(int i = digits.length-1; i>=0; i--) {
            if(++digits[i]!=10) return digits;
            digits[i]=0;
        }
        int[] res = new int[digits.length+1];
        res[0] = 1;
        return res;
    }

    public static int maxSubArray(int[] nums) {
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0; i<nums.length; i++) {
            sum=Math.max(nums[i],nums[i]+sum);
            max=Math.max(max,sum);
        }
        return max;
    }

    public int vmaxSubArray(int[] nums) {
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0; i<nums.length; i++) {
            sum = sum+nums[i];
            if(max<sum) max=sum;
            if(sum<0) sum=0;
        }
        return max;
    }
}
