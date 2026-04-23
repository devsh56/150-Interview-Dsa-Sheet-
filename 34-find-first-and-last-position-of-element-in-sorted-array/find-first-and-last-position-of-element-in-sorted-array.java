class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = binarysearch(nums,target,true);
        int end = binarysearch(nums,target,false);
        int ans [] = new int[2];
        ans[0] = start;
        ans[1] = end;

        return ans;
    }
    public static int binarysearch(int nums[],int target,boolean startindex){
        int start =0;
        int end = nums.length-1;
        int ans = -1;
        while(start <= end){
            int mid = (start+end)/2;
            if(nums[mid] < target){
                start = mid+1;
            } else if(nums[mid] > target){
                end=mid-1;
            }else{
                ans = mid;
                if(startindex){
                    end = mid-1;
                }else{
                    start =mid +1;
                }
            }
        }
        return ans;
    }
}