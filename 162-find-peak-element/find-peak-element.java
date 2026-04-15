class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 0 || nums.length == 1) return 0;
        if(nums[0] > nums[1]) return 0;
        if(nums[nums.length-1] > nums[nums.length-2]) return nums.length-1;
      int start = 1;
      int end = nums.length-2;
      while(start < end){
        int mid = (start+end)/2;
        if(nums[mid-1] < nums[mid]  && nums[mid+1] < nums[mid]) return mid;
        else if (nums[mid-1] < nums[mid]) start = mid+1;
        else end = mid-1;
      }  
      return end;
    }
}