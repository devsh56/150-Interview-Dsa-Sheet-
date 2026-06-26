class Solution {
    public static int  c = 0;
    public int totalNQueens(int n) {
        c=0;
        boolean b[][] = new boolean[n][n];
         GetQueenCount(0,n,b);
         return c;
    }
    public static void GetQueenCount(int row,int n , boolean[][] b){
        if(row == n) {
            c++;
            return;
        }
        for(int col = 0 ;col < n;col++){
            if(checkpieceonBoard(row,col,b)){
                b[row][col] = true;
                GetQueenCount(row+1,n,b);
                b[row][col] = false;
            }
        }
    }
    public static boolean checkpieceonBoard(int row, int col, boolean [][] b){
        int n = b.length;
        for(int i =0 ;i<n; i++){
            if(b[i][col]) return false;
        }
        int leftside = Math.min(row,col);

        for(int i =0;i<=leftside;i++){
            if(b[row-i][col-i])return false;
        }

        int rightside = Math.min(row,n-col-1);
        for(int i =0;i<=rightside;i++){
            if(b[row-i][col+i])return false;
        }
        return true;
    } 
}