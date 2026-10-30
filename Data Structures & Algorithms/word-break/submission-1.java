class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
       int n = s.length();
       int start = 0;
       Boolean[] memo = new Boolean[n];
       return dp(s, start, n, wordDict, memo); 
    }

    boolean dp(String s, int start, int n, List<String> wordDict, Boolean[] memo) {
        // base case
        if(start == n) {
            return true;
        }
        // base case --> memoization case
        if(memo[start] != null) {
            return memo[start];
        }
        for(int i = start; i < n; i++) {
            String word = s.substring(start, i+1);
            if(wordDict.contains(word)) {
                // recursively check for the entire string
                boolean remainingWord = dp(s, i+1, n, wordDict, memo);
                if(remainingWord) {
                    return memo[start] = true;
                }
            }
        }
        return memo[start] = false;
    }
}