class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();

        List<int[]> updated = new ArrayList<>();
        for(int[] interval : intervals) {
            updated.add(interval);
        }
        updated.add(newInterval);

        Collections.sort(updated, (a,b) -> a[0] - b[0]); // sorting based on start idx

        int[] initial = updated.get(0);

        for(int i = 1; i < updated.size(); i++) {
            if(initial[1] < updated.get(i)[0]) {
                res.add(initial);
                initial = updated.get(i);
            } else {
                initial[1] = Math.max(initial[1], updated.get(i)[1]);
            }
        }
        // adding final initial where we are not able to compare anymore
        res.add(initial);

        return res.toArray(new int[res.size()][]);
    }
}
