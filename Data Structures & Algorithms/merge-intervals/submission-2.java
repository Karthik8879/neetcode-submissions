class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        int[] opening = intervals[0];
        List<int[]> res = new ArrayList<>();
        for(int i = 1; i < intervals.length; i++) {
            if(opening[1] >= intervals[i][0]) {
                opening[1] = Math.max(opening[1], intervals[i][1]);
            } else {
                res.add(opening);
                opening = intervals[i];
            }
        }
        res.add(opening);
        return res.toArray(new int[res.size()][]);
    }
}
