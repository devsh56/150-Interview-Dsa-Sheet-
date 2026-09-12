class Solution {
    public String removeKdigits(String num, int k) {
      Stack<Character> st = new Stack<>();
      for(int i =0 ;i<num.length();i++){
          char ch = num.charAt(i);
          while(!st.isEmpty() && st.peek() > ch && k > 0){
            st.pop();
            k--;
          }
          if(st.isEmpty() && ch == '0'){
            
          }else{
            st.push(ch);
          }
      } 
       while(k>0 && !st.isEmpty()){
        st.pop();
        k--;
       }
      if(st.isEmpty()) return "0";
     
      StringBuilder ll = new StringBuilder();
      while(!st.isEmpty()){
        ll.append(st.pop());
      }  
      return ll.reverse().toString();
    }
}