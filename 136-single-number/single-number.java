class Solution {
    public int singleNumber(int[] nums) {
        int appearElement = 0;
        for(int i =0;i<nums.length;i++){
            appearElement = appearElement ^ nums[i];
        }
        return appearElement;
    }
}