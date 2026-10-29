class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        return dp(n, memo);
    }

    int dp(int n, int[] memo) {
        // base case --> when we have reached the target
        if(n == 0) {
            return 1;
        }
        // base case --> when we are beyong the target we have to return 0 
        if(n < 0) {
            return 0;
        }
        // base case --> memo return
        if(memo[n] != -1) {
            return memo[n];
        }
        int cnt = 0;
        // loop wrt the steps that we have --> here we have only 1 or 2 steps that we can take
        for(int i = 1; i <= 2; i++) {
            cnt += dp(n - i, memo);
        }
        memo[n] = cnt;
        return memo[n];
    }
}
