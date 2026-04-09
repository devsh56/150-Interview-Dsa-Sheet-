class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int maxgas = 0;
        int index = 0;
        int total = 0;
        for(int i =0 ;i<gas.length;i++){
            int value = gas[i] - cost[i];
            //gv+=value;
            maxgas += value;
            if(maxgas < 0 ){
                index = i+1;
                maxgas = 0;
            }
            total+=value;
        }
        if(total < 0) return -1 ;
        return index;
    }
}