class Solution {
    public String minWindow(String s, String t) {
        // base case
        if(s.length() == 0) return "";
        if(t.length() > s.length()) return "";

        HashMap<Character, Integer> hm1 = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            hm1.put(t.charAt(i), hm1.getOrDefault(t.charAt(i), 0) + 1);
        }

        int minLen = Integer.MAX_VALUE;
        int required = hm1.size();
        int formed = 0;
        HashMap<Character, Integer> hm2 = new HashMap<>();
        int low = 0;
        int high = 0;
        String ans = "";
        
        while(high < s.length()) {
            // input into the hashmap
            if(hm1.containsKey(s.charAt(high))) {
                hm2.put(s.charAt(high), hm2.getOrDefault(s.charAt(high), 0) + 1);
                if(hm1.get(s.charAt(high)).intValue() == hm2.get(s.charAt(high)).intValue()) {
                    formed++;
                }
            }

            // firing case
            while(required == formed) {
                // storing the result
                if((high - low + 1) <= minLen) {
                    ans = s.substring(low, high+1);
                    minLen = (high - low + 1);
                }

                // updating the lower to low++;
                if(hm1.containsKey(s.charAt(low))) {
                    // checking if hm1 values and hm2 values are still in sync
                    if(hm1.get(s.charAt(low)).intValue() == hm2.get(s.charAt(low)).intValue()) {
                        formed--;
                    }
                    hm2.put(s.charAt(low), hm2.get(s.charAt(low))-1);
                    if(hm2.get(s.charAt(low)) == 0) {
                        hm2.remove(s.charAt(low));
                    }
                }
                low++;
            }
            high++;
        }
        return ans;
    }
}
