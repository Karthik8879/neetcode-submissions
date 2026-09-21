class Solution {

    public int lengthOfLongestSubstring(String s) {
        // "zxyzxyz"
        if(s.length() == 0) return 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        int maxLen = 1;
        int low = 0, high = 0;
        while(high < s.length()) {
            while(hm.containsKey(s.charAt(high))) {
                hm.remove(s.charAt(low));
                low++;
            }
            hm.put(s.charAt(high), 1);
            maxLen = Math.max(maxLen, high - low + 1);
            high++;
        }
        return maxLen;
    }


    public int lengthOfLongestSubstring2(String s) {
        // "zxyzxyz"
        if(s.length() == 0) return 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        int low = 0, high = 0;
        int maxLen = 1;
        while(high < s.length()) {
            while(hm.containsKey(s.charAt(high))) {
                hm.remove(s.charAt(low));
                low++;
            }
            hm.put(s.charAt(high), 1);
            maxLen = Math.max(maxLen, high - low + 1);
            high++;
        }
        return maxLen;
    }


    // "zxyzxyz"
    // s
    //    e --> understood that we have to make use of counter hashmap
    public int lengthOfLongestSubstring1(String s) {
        if(s.length() == 0) return 0;
        int maxLen = 1;
        int low = 0, high = 1;
        HashMap<Character, Integer> hm = new HashMap<>();
        hm.put(s.charAt(0), 1);

        for(high = 1; high < s.length(); high++) {
            char chH = s.charAt(high);
            hm.put(chH, hm.getOrDefault(chH, 0) + 1);

            while(hm.get(chH) > 1) {
                hm.put(s.charAt(low), hm.get(s.charAt(low))-1);
                if(hm.get(s.charAt(low)) == 0) {
                    hm.remove(hm.get(s.charAt(low)));
                }
                low++;
            }
            maxLen = Math.max(maxLen, high - low + 1);
        }
        return maxLen;
    }
}
