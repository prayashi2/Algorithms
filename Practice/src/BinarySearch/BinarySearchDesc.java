package BinarySearch;

public class BinarySearchDesc {

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
                return bsearch(nums, mid+1, h, target);
            }
            else {
                return bsearch(nums, l, mid-1, target);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{16,14,12,10,8,6,4,2},12));
    }
}
