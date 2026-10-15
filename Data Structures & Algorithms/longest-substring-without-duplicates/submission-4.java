class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs = new HashSet<>();
        int low = 0, high = 0;
        int maxLen = 0;
        while(high < s.length()) {
            while(low < high && hs.contains(s.charAt(high))) {
                hs.remove(s.charAt(low));
                low++;
            }
            hs.add(s.charAt(high));
            maxLen = Math.max(maxLen, hs.size());
            high++;
        }
        return maxLen;
    }
}
