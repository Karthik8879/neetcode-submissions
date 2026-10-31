class Solution {
    public int numDistinct(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();
        int startS = 0;
        int startT = 0;
        int[][] memo = new int[lenS][lenT];
        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(s, t, startS, startT, lenS, lenT, memo);
    }

    int dp(String s, String t, int startS, int startT, int lenS, int lenT, int[][] memo) {
        // base case --> valid case
        if(startT == lenT) {
            return 1;
        }
        // base case --> invalid case when we have reach end of s but not reached end of t so invalid
        if(startS == lenS) {
            return 0;
        }

        // base case --> memo return
        if(memo[startS][startT] != -1) {
            return memo[startS][startT];
        }

        // skip
        int skip = dp(s, t, startS+1, startT, lenS, lenT, memo);

        // pick
        int pick = 0;
        if(s.charAt(startS) == t.charAt(startT)) {
            pick = dp(s, t, startS+1, startT+1, lenS, lenT, memo);
        }

        return memo[startS][startT] = skip + pick;
    }
}
