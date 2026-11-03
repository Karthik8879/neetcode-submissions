class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
int[] res = new int[3];

        // Column 0: find max of all valid 0th elements
        for (int[] t : triplets) {
            if (t[0] <= target[0] && t[1] <= target[1] && t[2] <= target[2]) {
                res[0] = Math.max(res[0], t[0]);
            }
        }

        // Column 1: find max of all valid 1st elements
        for (int[] t : triplets) {
            if (t[0] <= target[0] && t[1] <= target[1] && t[2] <= target[2]) {
                res[1] = Math.max(res[1], t[1]);
            }
        }

        // Column 2: find max of all valid 2nd elements
        for (int[] t : triplets) {
            if (t[0] <= target[0] && t[1] <= target[1] && t[2] <= target[2]) {
                res[2] = Math.max(res[2], t[2]);
            }
        }

        return Arrays.equals(res, target);
    }
}
