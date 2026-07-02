class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        boolean check [][]= new boolean[grid.size()][grid.get(0).size()];
        Boolean dp[][][]=new Boolean[grid.size()][grid.get(0).size()][health+1]; 
        return cangetOrNot(0,0,grid,health,check,dp); 
    }
    public static boolean cangetOrNot(int i , int j,List<List<Integer>> grid,int h,boolean[][]c,Boolean[][][]dp){
        if(i == grid.size()-1 && j == grid.get(0).size()-1){
            if(grid.get(i).get(j) == 1){
                h--;
            }
            if(h >= 1) return true;
            else return false;
        }
        if( i < 0 || j<0 || i >= grid.size() || j>= grid.get(0).size() || h < 0 || c[i][j] == true) return false;
        if(dp[i][j][h] != null) return dp[i][j][h];
        boolean flag = false;
        c[i][j] = true;
        if(grid.get(i).get(j) == 1){
             flag = flag || cangetOrNot(i,j+1,grid,h-1,c,dp) || cangetOrNot(i,j-1,grid,h-1,c,dp) || cangetOrNot(i+1,j,grid,h-1,c,dp) || cangetOrNot(i-1,j,grid,h-1,c,dp);
        }else{
            flag = flag || cangetOrNot(i,j+1,grid,h,c,dp) || cangetOrNot(i,j-1,grid,h,c,dp) || cangetOrNot(i+1,j,grid,h,c,dp) || cangetOrNot(i-1,j,grid,h,c,dp);
        }
        c[i][j] = false;
        return dp[i][j][h] = flag;
    }
}