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
        return dp(text1, text2, len1, len2, start1, start2, memo);
    }

    int dp(String text1, String text2, int len1, int len2, int start1, int start2, int[][] memo) {
        // base case
        if(start1 == len1 || start2 == len2) {
            return 0;
        }
        if(text1.charAt(start1) == text2.charAt(start2)) {
            return 1 + dp(text1, text2, len1, len2, start1+1, start2+1, memo);
        }
        // base case --> memo return
        if(memo[start1][start2] != -1) {
            return memo[start1][start2];
        }
        // skip start1 
        int skipStart1 = dp(text1, text2, len1, len2, start1+1, start2, memo);
        int skipStart2 = dp(text1, text2, len1, len2, start1, start2+1, memo);
        return memo[start1][start2] = Math.max(skipStart1, skipStart2);
    }
}
