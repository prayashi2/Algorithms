package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public int majorityElementExtraSpace(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums) {
            int currentCount = map.compute(i, (k,v) -> v==null? 1: v+1);
            if(currentCount>nums.length/2) {
                return i;
            }
        }
        return -1;
    }

    public int majorityElement(int[] nums) {
        int n = nums.length;
        if(n==1) {
            return nums[0];
        }
        Arrays.sort(nums);
        int count = 1;
        int res = -1;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length-1; i++) {
            if(nums[i]==nums[i+1])
                count++;
            else {
                count=1;
            }
            if(count>max) {
                max=count;
                res=nums[i];
            }
        }
        return res;
    }
}
