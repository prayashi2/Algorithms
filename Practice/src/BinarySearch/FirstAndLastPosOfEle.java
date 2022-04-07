package BinarySearch;

public class FirstAndLastPosOfEle {

    public int[] searchRange(int[] nums, int target) {
        int res[] = new int[2];
        return bsearch(nums, 0, nums.length-1, target, res);
    }

    public static int[] bsearch(int[] nums, int l, int h, int target, int res[]) {
        if(h>=l) {
            int mid = l+(h-l)/2;
            if(target == nums[mid]) {
                int m = mid;
                while(mid-1>=0 && nums[mid-1]==target) {
                    mid--;
                }
                res[0] = mid;
                while(m+1<=nums.length-1 && nums[m+1]==target) {
                    m++;
                }
                res[1] = m;
                return res;

            }
            if(target<nums[mid]) {
                return bsearch(nums, l, mid-1, target, res);
            }
            else {
                return bsearch(nums, mid+1, h, target, res);
            }
        }
        res[0] =-1;
        res[1] =-1;
        return res;
    }
}
