class Solution {
    public int maxCoins(int[] nums) {
        int[] arr = new int[nums.length+2];
        int n = arr.length;
        arr[0] = 1; // hardcoding
        arr[n-1] = 1; // hardcoding
        for (int i = 0; i < nums.length; i++) {
            arr[i + 1] = nums[i];
        }
        // we are hardcoding based on our use case regarding 1 as the padding for overflow case
        int start = 1; // because we have already populated our arr 0th idx with 1
        int end = n-2;
        int[][] memo = new int[n+1][n+1];
        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(arr, start, end, memo);
    }

    int dp(int[] arr, int start, int end, int[][] memo) {
        // No balloons remain in this range.
        if (start > end) {
            return 0;
        }

        // base case --> memo return
        if(memo[start][end] != -1) {
            return memo[start][end];
        }

        // store max
        int max = 0;
        // here range has to be matching the nums
        // we we have having 1 to n-1 to match that wrt arr and nums -> arr-2 size
        for(int i = start; i <= end; i++) {
            // 3 cases always
            // left coins
            // curr coins
            // right coins

            // left coins case -->
            int leftCoins = dp(arr, start, i-1, memo);

            // right coins case -->
            int rightCoins = dp(arr, i+1, end, memo);

            // curr coins
            int currCoins = arr[start-1] * arr[i] * arr[end+1];

            int total = leftCoins + currCoins + rightCoins;

            max = Math.max(max, total);
        }
        return memo[start][end] = max;
    }
}
