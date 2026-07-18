class Solution {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        int a = nums[0];
        int b = nums[nums.length-1];
        return euclidean(a,b);
    }
    public static int euclidean(int a, int b){
        while(b!=0){
            int r = a % b;
            a=b;
            b=r;
        }
        return a;
    }
}