class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        int[] initial = intervals[0];
        for(int i = 1; i < intervals.length; i++) {
            if(initial[1] >= intervals[i][0]) {
                // merging intervals
                initial[1] = Math.max(initial[1], intervals[i][1]);
            } else {
                res.add(initial);
                initial = intervals[i];
            }
        }
        // final interval do manually because of no comparison being availabe
        res.add(initial);
        return res.toArray(new int[res.size()][]);
    }
}
