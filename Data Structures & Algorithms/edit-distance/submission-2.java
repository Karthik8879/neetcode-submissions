class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int start1 = 0;
        int start2 = 0;
        int[][] memo = new int[len1][len2];
        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(word1, word2, start1, start2, len1, len2, memo);
    }

    int dp(String word1, String word2, int start1, int start2, int len1, int len2, int[][] memo) {
        // base case --> valid case
        if(start2 == len2) {
            return len1-start1;
        }
        if(start1 == len1) {
            return len2-start2;
        }
        // base case --> memo return
        if(memo[start1][start2] != -1) {
            return memo[start1][start2];
        }

        // 3 cases in total
        // but if valid we go ahead
        if(word1.charAt(start1) == word2.charAt(start2)) {
            return dp(word1, word2, start1+1, start2+1, len1, len2, memo);
        }
        // insert
        int insert = dp(word1, word2, start1, start2+1, len1, len2, memo);
        // delete
        int delete = dp(word1, word2, start1+1, start2, len1, len2, memo);
        // replace
        int replace = dp(word1, word2, start1+1, start2+1, len1, len2, memo);

        return memo[start1][start2] = 1 + Math.min(insert, Math.min(delete, replace));
    }
}
