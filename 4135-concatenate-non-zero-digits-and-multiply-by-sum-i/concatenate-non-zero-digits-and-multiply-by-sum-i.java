class Solution {
    public long sumAndMultiply(int n) {
        StringBuilder sb = new StringBuilder();
        long sum = 0;
        while(n>0){
            int s = n%10;
            System.out.println(s);
            n = n/10;
            if(s != 0)
            sb.append(s);
            sum+=s;
        }
        return sb.length() == 0 ? 0 :Long.parseLong(sb.reverse().toString()) * sum;
    }
}