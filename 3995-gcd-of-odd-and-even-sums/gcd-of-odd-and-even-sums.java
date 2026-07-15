class Solution {
    public int gcdOfOddEvenSums(int n) {
        int OddSum = 0;
        int EvenSum = 0;
        int v = 1;
        while(n-- > 0){
            OddSum+=v;
            v++;
            EvenSum+=v;
            v++;
        }
        return gcd(OddSum,EvenSum);
    }
    public static int gcd(int a, int b){
        while(b!=0){
            int r = a %b;
            a=b;
            b=r;
        }
        return a;
    }
}