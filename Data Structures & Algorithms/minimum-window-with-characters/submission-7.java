class Solution {
    public String minWindow(String s, String t) {
        // base case
        if (t.length() == 0 || s.length() < t.length()) {
            return "";
        }

        HashMap<Character, Integer> hm1 = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            hm1.put(t.charAt(i), hm1.getOrDefault(t.charAt(i), 0) + 1);
        }

        int minLen = Integer.MAX_VALUE;
        String ans = "";
        HashMap<Character, Integer> hm2 = new HashMap<>();
        int low = 0;
        int high = 0;
        int formed = 0;
        int required = hm1.size();

        while(high < s.length()) {
            if(hm1.containsKey(s.charAt(high))) {
                hm2.put(s.charAt(high), hm2.getOrDefault(s.charAt(high), 0) + 1);
                if(hm1.get(s.charAt(high)).intValue() == hm2.get(s.charAt(high)).intValue()) {
                    formed++;
                }
            }
            // firing case
            while(formed == required) {
                // saving the result
                if((high - low + 1) <= minLen) {
                    minLen = high - low + 1;
                    ans = s.substring(low, high+1);
                }
                // fire the lower values
                if(hm1.containsKey(s.charAt(low))) {
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
