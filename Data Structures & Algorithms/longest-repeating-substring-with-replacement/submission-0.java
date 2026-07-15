class Solution {
    // "XYYX"
    //  l
    //    h
    // hm -> x:0, y:1
    // replacementLeft -> 2 till idx:1, 1 till idx:2, 
    // maxFreq -> 2
    // "AAABABB"
    // l
    //   r
    // hm -> a:4, b:3
    // replacementLeft -> 1 till idx:2, 0 till idx:3 
    // maxFreq -> 4
    public int characterReplacement(String s, int k) {
        int low = 0, high = 1;
        int maxFreq = 1, maxLen = 1;
        HashMap<Character, Integer> hm = new HashMap<>();
        hm.put(s.charAt(0), 1);

        for(high = 1; high < s.length(); high++) {
            char chH = s.charAt(high);
            hm.put(chH, hm.getOrDefault(chH, 0) + 1);
            maxFreq = Math.max(maxFreq, hm.get(chH));

            while ((high - low + 1) - maxFreq > k) {
                char leftChar = s.charAt(low);

                hm.put(leftChar, hm.get(leftChar) - 1);
                low++;
            }

            maxLen = Math.max(maxLen, (high - low + 1));
        }
        return maxLen;
    }
}
