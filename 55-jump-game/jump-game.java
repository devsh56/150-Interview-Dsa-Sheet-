class Solution {
    public boolean canJump(int[] nums) {
        int max = nums[0];
        int i=1;
        for(;i<=max && max < nums.length-1;i++){
            max = Math.max((nums[i]+i),max);
            if(max <= i)return false; 
        }
        if(max >= nums.length-1)return true;
        return false;
    }
}