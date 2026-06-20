class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length* board.length;
        int f = board.length;
        int mindis[] = new int[n+1];
        Arrays.fill(mindis,-1);
       Queue<Integer> ll = new ArrayDeque<>();
        ll.add(0);
        mindis[0]= 0;
        while(!ll.isEmpty()){
            int x = ll.poll();
            for(int i =1 ;i<=6 && x + i < n ;i++){
                int t = i+x;
                int row = t/f ;
                int col = t % f ;
                int value = board[f-1-row][row % 2 == 0 ? col :(f-1-col)];
                int point = (value > 0) ? value-1 : t;
                if(point == n-1) return mindis[x] + 1;
            else if (mindis[point] == -1 ){
                mindis[point] = mindis[x]+1;
                ll.add(point);
            }
            }
            
                
            }
             return -1;
        }
}