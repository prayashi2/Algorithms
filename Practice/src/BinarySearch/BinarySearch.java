package BinarySearch;

public class BinarySearch {

    public static int search(int[] nums, int target) {
        return bsearch(nums, 0, nums.length-1, target);
    }

    public static int bsearch(int[] nums, int l, int h, int target) {
        if(h>=l) {
            int mid = l+(h-l)/2;
            if(target == nums[mid]) {
                return mid;
            }
            if(target<nums[mid]) {
                return bsearch(nums, l, mid-1, target);
            }
            else {
                return bsearch(nums, mid+1, h, target);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{1,4,6,8,10,12,14,16},12));
    }
}
