class Solution {
    class Custom{
        int bestStart = 0;
        int maxLen = 0;
        Custom(int bestStart, int maxLen) {
            this.bestStart = bestStart;
            this.maxLen = maxLen;
        }
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        Custom[] memo = new Custom[n]; 
        // we are not going to be populating memo with anything because we can distinguish wrt null and populated wrt Custom type
        Custom ans = dp(s, 0, n, memo);
        return s.substring(ans.bestStart, ans.bestStart + ans.maxLen);
    }

    Custom dp(String s, int start, int n, Custom[] memo) {
        // base case
        if(start >= n) {
            return new Custom(0, 0);
        }
        // base case --> memo - return 
        if(memo[start] != null) {
            return memo[start];
        }
        Custom max = new Custom(start, 1); // base max
        for(int i = start; i < n; i++) {
            // if Palindrome store it
            if(isValidPalindrome(s, start, i)) {
                int len = i - start + 1;
                if(len > max.maxLen) {
                    max = new Custom(start, len);
                }
            }
            // call dp
            Custom curr = dp(s, i+1, n, memo);
            if(curr.maxLen > max.maxLen) {
                max = curr;
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
