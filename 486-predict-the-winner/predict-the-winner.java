class Solution {
    public boolean predictTheWinner(int[] nums) {
        return getthewinner(0,nums.length-1,nums) >= 0;
    }
    public static int getthewinner(int left, int right,int n[]){
        if(left == right) return n[left];

        int leftsidesum = n[left] - getthewinner(left+1,right,n);
        int rightsidesum = n[right] - getthewinner(left,right-1,n);

        return Math.max(leftsidesum,rightsidesum);
    }
}