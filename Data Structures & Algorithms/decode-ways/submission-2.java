class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int start = 0;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return dp(s, start, n, memo);
    }

    int dp(String s, int start, int n, int[] memo) {
        // base case --> reached final and returning recursion asnwer
        if(start >= n) {
            return 1; // we have reached a valid case
        }
        // base case --> invalid case of start from 0
        if(s.charAt(start) == '0') {
            return 0;
        }
        // base case --> memoization
        if(memo[start] != -1) {
            return memo[start];
        }
        int cnt = 0;
        for(int i = 1; i <= 2; i++) {
            // case --> beyond n
            if(start+i > n) {
                continue;
            }
            if(i == 1) {
                cnt += dp(s, start+1, n, memo);
            }
            if(i == 2) {
                int num = Integer.parseInt(s.substring(start, start+2));
                if(num >= 10 && num <= 26) {
                    cnt += dp(s, start+2, n, memo);
                }
            }
        }
        return memo[start] = cnt;
    }
}
