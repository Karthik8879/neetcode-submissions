class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int start = 0;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return dp(s, start, n, memo);
    }

    int dp(String s, int start, int n, int[] memo) {
        // base case
        if(start >= n) {
            return 1;
        }
        // Cannot decode a substring starting with 0
        if (s.charAt(start) == '0') {
            return 0;
        }
        // base case --> memo - return
        if(memo[start] != -1) {
            return memo[start];
        }
        int cnt = 0;
        // here we have only 2 options consider 1 element or 2 elements
        for(int i = 1; i <= 2; i++) {
            // Avoid going beyond the string
            if (start + i > n) {
                continue;
            }
            // single character
            if(i == 1) {
                cnt += dp(s, start+1, n, memo);
            }

            // 2 digits
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
