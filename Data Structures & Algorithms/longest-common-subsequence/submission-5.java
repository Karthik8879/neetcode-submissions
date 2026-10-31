class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int start1 = 0;
        int start2 = 0;
        int[][] memo = new int[len1][len2];
        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(text1, text2, start1, start2, len1, len2, memo);
    }

    int dp(String text1, String text2, int start1, int start2, int len1, int len2, int[][] memo) {
        // base case
        if(start1 == len1 || start2 == len2) {
            return 0;
        }

        // base case --> memoization return
        if(memo[start1][start2] != -1) {
            return memo[start1][start2];
        }

        // don't consider the characters of text1 when we do not find a match and we are skipping them
        int case1 = dp(text1, text2, start1+1, start2, len1, len2, memo);

        // other case when we are about to find a match
        int case2 = 0;
        for(int i = start2; i < len2; i++) {
            // we are going to be finding a match --> best case
            int pick = 0;
            if(text1.charAt(start1) == text2.charAt(i)) {
                pick = 1 + dp(text1, text2, start1+1, i+1, len1, len2, memo);
                case2 = Math.max(case2, pick);
            }
        }
        return memo[start1][start2] = Math.max(case1, case2);
    }
}
