class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[1] - b[1]); // sorting wrt end time
        int endTime = intervals[0][1];
        int cnt = 1;
        for(int i = 1; i < intervals.length; i++) {
            if(endTime <= intervals[i][0]) {
                cnt++;
                endTime = intervals[i][1];
            }
        }
        return intervals.length - cnt;
    }
}
