class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] res = new int[target.length];
        for(int[] row : triplets) {
if (row[0] > target[0] || row[1] > target[1] || row[2] > target[2]) {
                continue;
            }
            for(int j = 0; j < 3; j++) {
                if(row[j] == target[j]) {
                    res[j] = row[j];
                }
            }
        }
        return Arrays.equals(res, target);
    }
}
