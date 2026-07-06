class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
       // Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
       Arrays.sort(intervals, (a, b) -> {
    if (a[0] == b[0]) {
        return b[1] - a[1];
    }
    return a[0] - b[0];
});
        int n = intervals.length;
        int i =1 ;
        int start =intervals[0][0];
        int end =intervals[0][1];
        int count = 1;
        while(i<n){
            if(start <= intervals[i][0] && end >= intervals[i][1]){
                i++;
                continue;
            }
            count++;
            start = Math.min(start,intervals[i][0]);
            end = Math.max(end,intervals[i][1]);
            i++;
        }
        return count;
    }
}