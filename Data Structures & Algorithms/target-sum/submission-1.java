class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int start = 0;
        int sum = 0;
        int total = 0;
        for (int num : nums) {
            total += num;
        }

        if (target < -total || target > total) {
            return 0;
        }
        int[][] memo = new int[n][2 * total + 1];
        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(nums, start, sum, total, n, target, memo);
    }

    int dp(int[] nums, int start, int sum, int total, int n, int target, int[][] memo) {
        // base case
        if (start == n) {
            return sum == target ? 1 : 0;
        }
        // base case -> memo return
        // we have to do this sum+total so that we can handle the -ve values as well and we will not have to take into consideration the cases of -ve idex and out of bound cases like that
        if(memo[start][sum+total] != -1) {
            return memo[start][sum+total];
        }
        // store in variable
        int cnt = 0;
        // posSum
        int posSum = sum + nums[start];
        cnt += dp(nums, start+1, posSum, total, n, target, memo);
        // negSum
        int negSum = sum - nums[start];
        cnt += dp(nums, start+1, negSum, total, n, target, memo);
        System.out.println("1");
        return memo[start][sum+total] = cnt;
    }
}
