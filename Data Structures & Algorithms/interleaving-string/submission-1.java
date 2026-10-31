class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        // base case
        if(len1 + len2 != len3) {
            return false;
        }
        int start1 = 0;
        int start2 = 0;
        int start3 = 0;
        int[][][] memo = new int[len1+1][len2+1][len3+1];
        for(int[][] layer : memo){
            for(int[] row : layer) {
                Arrays.fill(row, -1);
            }
        }
        return dp(s1, s2, s3, start1, start2, start3, len1, len2, len3, memo);
    }

    boolean dp(String s1, String s2, String s3, int start1, int start2, int start3, int len1, int len2, int len3, int[][][] memo) {
        // base case
        if(start3 == len3) {
            return true;
        }
        // base case --> memo return
        if (memo[start1][start2][start3] != -1) {
            return memo[start1][start2][start3] == 1;
        }
        boolean chooseS1 = false;
        boolean chooseS2 = false;
        if(start1 < len1 && s1.charAt(start1) == s3.charAt(start3)) {
            chooseS1 = dp(s1, s2, s3, start1+1, start2, start3+1, len1, len2, len3, memo);
        }
        if(start2 < len2 && s2.charAt(start2) == s3.charAt(start3)) {
            chooseS2 = dp(s1, s2, s3, start1, start2+1, start3+1, len1, len2, len3, memo);
        }
        // if((start1 < len1 && start2 < len2) && s1.charAt(start1) != s3.charAt(start3) && s2.charAt(start2) != s3.charAt(start3)) {
        //     return false;
        // }
        // if((start1 < len1 && start2 < len2) && s1.charAt(start1) == s3.charAt(start3) && s2.charAt(start2) == s3.charAt(start3)) {
        //     return dp(s1, s2, s3, start1+1, start2+1, start3+1, len1, len2, len3, memo);
        // }

        boolean res = chooseS1 || chooseS2;
        memo[start1][start2][start3] = res ? 1 : 0;

        return res;
    }
}
