class Solution {
    public int candy(int[] ratings) {
        int preChoc []= new int[ratings.length];
        int postChoc[]=new int[ratings.length];
        preChoc[0] = 1;
        postChoc[ratings.length-1] = 1;
        for(int i = 1 ;i<ratings.length;i++){
            if(ratings[i] > ratings[i-1])
            preChoc[i] = preChoc[i-1] + 1;
            else preChoc[i] = 1;
        }
        for(int i =  ratings.length-2 ;i >=0;i--){
            if(ratings[i] > ratings[i+1]){
                postChoc[i] = postChoc[i+1] + 1;
            }
            else{
                postChoc[i] = 1;
            }
        }
        int choclate = 0;
        for(int i =0 ;i<ratings.length;i++){
           // System.out.println(postChoc[i] +"" + preChoc[i]);
            choclate += Math.max(postChoc[i], preChoc[i]);
        }
        return choclate;
    }
}