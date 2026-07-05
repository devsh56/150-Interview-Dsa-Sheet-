class Solution {
    public static int Moduleo = 1000000007;
    public int[] pathsWithMaxScore(List<String> board) {
        char chArr [][] = new char[board.size()][board.get(0).length()];
        for(int i=0 ;i< board.size();i++){
         char[] ch = board.get(i).toCharArray();
//System.out.println(Arrays.toString(ch));
            for(int j =0 ;j< ch.length;j++){
                chArr[i][j] = ch[j]; 
            }
        }
        int dp[][]= new int[chArr.length][chArr[0].length];
        for(int arr[]:dp){
            Arrays.fill(arr,-1);
        }
        chArr[0][0] = '0';
        int max = getMaximumPath(0,0,chArr,dp);
        max = (chArr[chArr.length-1][chArr[0].length-1] =='#' ? max : 0);
  //      System.out.println(max);
          //int dp[][]= new int[chArr.length][chArr[0].length];
       int [][][] dp_new = new int[chArr.length][chArr[0].length][max+1];
       for(int arr[][] : dp_new){
        for(int a[] : arr){
            Arrays.fill(a,-1);
        }
       }
       int count = 0;
       if(chArr[chArr.length-1][chArr[0].length-1] =='#')
         count = getMaximumcountofvalue(0,0,chArr,dp_new,max);
     //   System.out.println(count);
        int ans [] = new int [2];
        ans[0]=max;
        ans[1]=count;
        return ans;
    }
    public static int getMaximumPath(int i , int j ,char[][]ch,int dp[][]){
        if(i == ch.length-1 && j== ch[0].length-1){
            ch[i][j] ='#';
            return 0;
        }
        if(i<0 || j < 0 || i >= ch.length || j>= ch[0].length || ch[i][j] == 'X')return 0;

        if(dp[i][j] != -1) return dp[i][j];
        char ch1 = ch[i][j];
        ch[i][j] = 'X';
        int ans = 0;
        ans = (ch1-'0') + Math.max(getMaximumPath(i+1,j,ch,dp),Math.max(getMaximumPath(i,j+1,ch,dp),getMaximumPath(i+1,j+1,ch,dp)));
        ch[i][j] = ch1;
        return dp[i][j] = ans;
    }
    public static int getMaximumcountofvalue(int i , int j ,char[][]ch,int dp[][][],int v){
        if(i == ch.length-1 && j== ch[0].length-1 ){
            if(v==0)return 1;
            else return 0;
        }
        if(i<0 || j < 0 || i >= ch.length || j>= ch[0].length || ch[i][j] == 'X' || v<0)return 0;

        if(dp[i][j][v] != -1) return dp[i][j][v];
        char ch1 = ch[i][j];
        int ans = 0;
        ans = (getMaximumcountofvalue(i+1,j,ch,dp,v-(ch1-'0')) % Moduleo +getMaximumcountofvalue(i,j+1,ch,dp,v-(ch1-'0')) % Moduleo+ getMaximumcountofvalue(i+1,j+1,ch,dp,v-(ch1-'0')) % Moduleo) % Moduleo;
        return dp[i][j][v] = ans % Moduleo;
    }
}