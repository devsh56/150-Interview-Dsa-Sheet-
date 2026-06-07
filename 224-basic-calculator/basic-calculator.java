class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int totalsum =0;
        int sign = 1;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                int value = 0;
                while(i<s.length() && Character.isDigit(s.charAt(i))){
                    value = (value*10) + (s.charAt(i)-'0');
                    i++;
                }
                value*=sign;
                sign = 1;
                totalsum+=value;
                i--;
            }else if(ch == '('){
                st.push(totalsum);
                st.push(sign);
                totalsum = 0;
                sign = 1;
            }else if(!st.isEmpty() && ch == ')'){
                totalsum*= st.pop();
                totalsum+= st.pop();
                sign = 1;
            }else if(ch == '-') sign *=-1;
        }
        return totalsum;
    }
}