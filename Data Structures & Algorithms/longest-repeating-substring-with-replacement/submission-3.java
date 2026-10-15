class Solution {
    public int characterReplacement(String s, int k) {
        int maxLen = 0, maxFreq = 0;
        int low = 0, high = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        while(high < s.length()) {
            // input into hm
            hm.put(s.charAt(high), hm.getOrDefault(s.charAt(high), 0) + 1);
            maxFreq = Math.max(maxFreq, hm.get(s.charAt(high)));
            // firing case
            while((low < high) && ((high - low + 1) - maxFreq) > k) {
                hm.put(s.charAt(low), hm.get(s.charAt(low))-1);
                if(hm.get(s.charAt(low)) == 0) {
                    hm.remove(s.charAt(low));
                }
                low++;
            }
            maxLen = Math.max(maxLen, (high - low + 1));
            high++;
        }
        return maxLen;
    }
}
