class Solution {
    public String minWindow(String s, String t) {
        if (t.length() == 0 || s.length() == 0) return "";
        HashMap<Character, Integer> hm1 = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            hm1.put(t.charAt(i), hm1.getOrDefault(t.charAt(i), 0) + 1);
        }

        int low = 0, high = 0;
        int unique_ele = hm1.size();
        int towards_unique_ele = 0;
        int[] ans = {-1, 0, 0};
        int minLen = Integer.MAX_VALUE;

        HashMap<Character, Integer> hm2 = new HashMap<>();

        while(high < s.length()) {
            // populating the hm2
            hm2.put(s.charAt(high), hm2.getOrDefault(s.charAt(high), 0) + 1);
            if(hm1.containsKey(s.charAt(high))) {
                if(hm2.get(s.charAt(high)).intValue() == hm1.get(s.charAt(high)).intValue()) {
                    towards_unique_ele++;
                }
            }

            // firing case
            while(high < s.length() && unique_ele == towards_unique_ele) {
                if(ans[0] == -1 || ans[0] > high - low + 1) {
                    ans[0] = high - low + 1;
                    ans[1] = low;
                    ans[2] = high;
                }
                hm2.put(s.charAt(low), hm2.get(s.charAt(low))-1);
                if(hm1.containsKey(s.charAt(low))) {
                    if(hm2.get(s.charAt(low)).intValue() < hm1.get(s.charAt(low)).intValue()) {
                        towards_unique_ele--;
                    }
                }
                if(hm2.get(s.charAt(low)) == 0) {
                    hm2.remove(s.charAt(low));
                }
                low++;
            }
            high++;
        }
        if(ans[0] == -1) return "";
        return s.substring(ans[1], ans[2]+1);
    }
}
