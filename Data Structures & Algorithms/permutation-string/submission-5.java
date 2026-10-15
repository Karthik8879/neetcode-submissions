class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // base case
        if(s1.length() > s2.length()) return false;
        HashMap<Character, Integer> hm1 = new HashMap<>();
        for(int i = 0; i < s1.length(); i++) {
            hm1.put(s1.charAt(i), hm1.getOrDefault(s1.charAt(i), 0) + 1);
        }
        
        HashMap<Character, Integer> hm2 = new HashMap<>();
        int low = 0, high = 0;

        for(high = 0; high < s1.length(); high++) {
            if(hm1.containsKey(s2.charAt(high))) {
                hm2.put(s2.charAt(high), hm2.getOrDefault(s2.charAt(high), 0) + 1);
            }
        }

         if (hm1.equals(hm2)) return true;

        while(high < s2.length()) {
            if(hm1.containsKey(s2.charAt(high))) {
                hm2.put(s2.charAt(high), hm2.getOrDefault(s2.charAt(high), 0) + 1);
            }
            if(hm1.containsKey(s2.charAt(low))) {
                hm2.put(s2.charAt(low), hm2.get(s2.charAt(low))-1);
                if(hm2.get(s2.charAt(low)) == 0) {
                    hm2.remove(s2.charAt(low));
                }
            }
            low++;
            high++;
            if(hm1.equals(hm2)) return true;
        }

        return false;
    }
}
