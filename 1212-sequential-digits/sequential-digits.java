class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        Queue<Integer> ans = new ArrayDeque();
        List<Integer> result = new ArrayList<>();
        for(int i =1 ;i<=9 ;i++)ans.add(i);
        int count = 1;
        while(!ans.isEmpty()){
            int size = ans.size();
            for(int i = 0 ;i<size;i++){
                int a = ans.poll();
                if( a >=low && a<= high) result.add(a);
                if(a > high)continue;
                    int v = a % 10;
                    if(v == 0 || v==9)continue;
                    ans.add(((a*10)+v+1));
            }
        }
        return result;
    }
}