class Solution {
    class Custom {
        int bestStart = 0;
        int maxLen = 0;
        Custom(int bestStart, int maxLen) {
            this.bestStart = bestStart;
            this.maxLen = maxLen;
        }
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        int start = 0;
        Custom[] memo = new Custom[n];
        // Arrays.fill(memo, -1); // we won't have this case because it is not an int it is a Custom type where we can check the case for null or not null 
        Custom ans = dp(s, start, n, memo);
        int bestStart = ans.bestStart;
        int maxLen = ans.maxLen;
        return s.substring(bestStart, bestStart + maxLen);
    }

    Custom dp(String s, int start, int n, Custom[] memo) {
        // base case --> return condition
        if(start >= n) {
            return new Custom(0, 0);
        }
        // base case --> memo case
        if(memo[start] != null) {
            return memo[start];
        }
        Custom max = new Custom(start, 1); // becase substring
        for(int i = start; i < n; i++) {
            // if valid palindrome
            // just normal check to store the palindrome cases
            if(isValidPalindrome(s, start, i)) {
                int len = i - start + 1;
                if(len > max.maxLen) {
                    max = new Custom(start, len);
                }
            }
            // dp call
            Custom custom = dp(s, i+1, n, memo);
            if(custom.maxLen > max.maxLen) {
                max = custom;
            }
        }
        return memo[start] = max;
    }

    boolean isValidPalindrome(String s, int start, int end) {
        while(start <= end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
