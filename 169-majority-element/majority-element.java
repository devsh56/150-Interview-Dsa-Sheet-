class Solution {
    public int majorityElement(int[] nums) {
        int element = nums[0];
        int i=1;
        int count = 1;
        while(i<nums.length){
            if(element != nums[i])count--;
            else count++;
            if(count < 0){
                element = nums[i];
                count = 1;
            } 
            i++;
        }
        return element;
    }
}