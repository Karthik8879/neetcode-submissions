class Solution {
    public boolean isMatch(String s, String p) {
        int lenS = s.length();
        int lenP = p.length();
        int startS = 0;
        int startP = 0;
        int[][] memo = new int[lenS+1][lenP+1];
        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(s, p, startS, startP, lenS, lenP, memo);
    }

    boolean dp(String s, String p, int startS, int startP, int lenS, int lenP, int[][] memo) {
        // base case
        if(startP == lenP) {
            if(startS == lenS) {
                return true;
            }
            return false;
        }

        // base case --> memo return
        if(memo[startS][startP] != -1) {
            return memo[startS][startP] == 1;
        }

        boolean match = startS < lenS && (s.charAt(startS) == p.charAt(startP) || p.charAt(startP) == '.');

        if(startP + 1 < lenP && p.charAt(startP+1) == '*') {
            // zero occurance skip *
            boolean skip = dp(s, p, startS, startP+2, lenS, lenP, memo);
            // we are going to consume *
            boolean use = match && dp(s, p, startS+1, startP, lenS, lenP, memo);
            boolean res = skip || use;
            memo[startS][startP] = res ? 1 : 0;
            return res;
        }
        boolean res = match && dp(s, p, startS+1, startP+1, lenS, lenP, memo);
        memo[startS][startP] = res ? 1 : 0;
        return res;
    }
}
