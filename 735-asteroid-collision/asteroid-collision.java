class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer>st = new Stack<>();
        for(int i = 0 ;i<asteroids.length;i++){
            boolean flag = true;
            while(!st.isEmpty() && asteroids[i] < 0){
                int a = -asteroids[i];
                if(asteroids[st.peek()] < 0){
                    flag = true;
                    break;
                }
                if(asteroids[st.peek()] > a){
                    flag = false;
                    break;
                }
                else if(asteroids[st.peek()] == a){
                    flag = false;
                    st.pop();
                    break;
                }
                else{
                    st.pop();
                }

            }
            if(flag)
            st.add(i);
        }
        int ans [] = new int[st.size()];
        int j = st.size()-1;
        while(!st.isEmpty()){
            ans[j] = asteroids[st.pop()];
            j--;
        }

        return ans;
    }
}