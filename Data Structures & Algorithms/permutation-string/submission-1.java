class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        HashMap<Character, Integer> hm1 = new HashMap<>();
        HashMap<Character, Integer> hm2 = new HashMap<>();
        // hm2.put(s2.charAt(0), 1);

        for(int i = 0; i < s1.length(); i++) {
            hm1.put(s1.charAt(i), hm1.getOrDefault(s1.charAt(i), 0) + 1);
        }

        int low = 0, high = 0;
        while(high < s2.length()) {
            char chH = s2.charAt(high);
            // insert into hm2
            hm2.put(chH, hm2.getOrDefault(chH, 0) + 1);

            // check for condition if both req is same
            while(high - low + 1 > s1.length()) {
                // remove
                hm2.put(s2.charAt(low), hm2.get(s2.charAt(low))-1);
                if(hm2.get(s2.charAt(low)) == 0) {
                    hm2.remove(s2.charAt(low));
                }
                low++;
            }
            if (high - low + 1 == s1.length()
                    && hm1.equals(hm2)) {
                return true;
            }
            high++;
        }
        return false;
    }
}
