/*
https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
 */

class FindMinimumInRotatedArray {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        while(low<high)    {
            int mid = (low+high)/2;
            if(nums[mid]> nums[high]){
                low = mid+1;
            }else{
                high = mid;
            }
        }
        return nums[low];
    }
}