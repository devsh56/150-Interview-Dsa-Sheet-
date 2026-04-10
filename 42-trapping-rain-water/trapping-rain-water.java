class Solution {
    public int trap(int[] height) {
        Stack<Integer>st = new Stack<Integer>();
        int ans = 0;
        for(int i=0 ;i<height.length;i++){
            while(!st.isEmpty() && height[st.peek()] < height[i]){
                    int a = st.pop();
                    if(st.isEmpty()){
                        break;
                    }else{
                        ans+= (Math.min(height[i], height[st.peek()]) - height[a] ) * (i-st.peek()-1);
                    }
            }
            st.push(i);
        }
        return ans;
    }
}