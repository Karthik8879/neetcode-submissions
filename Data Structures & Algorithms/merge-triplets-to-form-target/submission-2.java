class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] res = new int[3];
        for(int i = 0; i < 3; i++) {
            for(int[] row : triplets) {
                if(row[0] <= target[0] && row[1] <= target[1] && row[2] <= target[2]) {
                    res[i] = Math.max(res[i], row[i]);
                }
            }
        }
        return Arrays.equals(res, target);
    }
}
