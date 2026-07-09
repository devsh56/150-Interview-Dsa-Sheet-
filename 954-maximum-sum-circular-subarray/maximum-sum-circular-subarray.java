class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalsum = 0;
        for(int a : nums){
            totalsum += a;
        }
        int min_sum = KadensMin(nums);
        int max_sum = KadensMax(nums);
        System.out.println(min_sum);
        System.out.println(max_sum);

        int circular_sum =totalsum - min_sum;
        if(circular_sum > 0) return Math.max(circular_sum,max_sum);
        return max_sum;
    }
    public static int KadensMax(int [] nums){
        int maxsum = nums[0];
        int sum = 0;
        for(int i =0 ;i<nums.length;i++){
            sum+=nums[i];
            maxsum = Math.max(maxsum,sum);
            if(sum < 0) sum = 0;
        }
        return maxsum;
    }
     public static int KadensMin(int [] nums){
        int minsum = nums[0];
        int sum = 0;
        for(int i =0 ;i<nums.length;i++){
            sum+=nums[i];
            minsum = Math.min(minsum,sum);
            if(sum > 0) sum = 0;
        }
        return minsum;
    }
}