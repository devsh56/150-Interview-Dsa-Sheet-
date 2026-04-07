class Solution {
    public int removeDuplicates(int[] nums) {
        int i =0;
        int n = nums.length;
        int maxCount = 0;
        int previndex = 0;
        while(i<n){
            int count = 1;
            int j = i+1;
            while(j<nums.length && nums[i] == nums[j]){
                count++;
                j++;
            }
            if(count >= 2){
                nums[previndex] = nums[i];
                nums[previndex+1] = nums[i];
                maxCount+=2;
                previndex+=2;
            }
            else{
                nums[previndex] = nums[i];
                previndex++;
                maxCount+=1;}
            i = j;
        }
      //  System.out.println(maxCount);
        return maxCount;
    }
}