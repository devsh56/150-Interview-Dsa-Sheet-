class Solution {
    public int largestRectangleArea(int[] height) {
        Stack<Integer> st = new Stack<>();
        int ans = 0;
        for(int i =0 ;i<height.length;i++){
            while(i<height.length && !st.isEmpty() && height[st.peek()] > height[i]){
                int a = st.pop();
                if(st.isEmpty()){
                     ans = Math.max(ans,height[a] * i);
                }else{
                    ans= Math.max(ans,height[a] * (i - st.peek()-1));
                }
            }
            st.push(i);
        }

        int r = height.length;
         while(!st.isEmpty()){
                int a = st.pop();
                if(st.isEmpty()){
                     ans = Math.max(ans,height[a] * r);
                }else{
                    ans= Math.max(ans,height[a] * (r - st.peek()-1));
                }
            }
        return ans;
    }
}