class Solution {
    public boolean exist(char[][] board, String word) {
        boolean [][] check = new boolean[board.length][board[0].length];
        for(int i =0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == word.charAt(0)){
                    if(getsearch(i,j,word,0,check,board)) return true;
                }
            }
        }
        return false;
    }
    public static boolean getsearch(int i ,int j , String word, int k ,boolean[][] check,char[][] board){
        if(k >= word.length()){
            return true;
        }
        if(i<0 || j < 0 || i > board.length-1 || j > board[0].length-1 || check[i][j]){
            return false;
        }
        check[i][j] = true;
        boolean ans = false;
        if(word.charAt(k) == board[i][j]){
         ans = getsearch(i,j-1,word,k+1,check,board) || getsearch(i,j+1,word,k+1,check,board) || getsearch(i-1,j,word,k+1,check,board) || getsearch(i+1,j,word,k+1,check,board);
        }
        check[i][j] = false;
        return ans;
    }
}