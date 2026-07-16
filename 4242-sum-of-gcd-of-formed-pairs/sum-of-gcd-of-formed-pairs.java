class Solution {
    public long gcdSum(int[] nums) {
     int m = nums[0];
     int prefix[] = new int[nums.length];
     prefix[0] = nums[0];   

     for(int i=1;i<nums.length;i++){
        m = Math.max(nums[i],m);
        prefix[i] = Gcd(m,nums[i]);
     }
     Arrays.sort(prefix);
     long sum = 0;
     int i = 0;
     int j = prefix.length-1;
     while(i<j){
     sum+= (long)Gcd(prefix[i],prefix[j]);
     i++;
     j--;
     }
     return sum;
    }
    public static int Gcd(int m , int n){
        while(n!=0){
         int r = m%n;
            m = n;
            n = r;
        }
        return m;
    }
}