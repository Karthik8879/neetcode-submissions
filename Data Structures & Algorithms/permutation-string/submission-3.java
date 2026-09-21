class Solution {

    public boolean checkInclusion(String s1, String s2) {
        // base case
        if(s1.length() > s2.length()) return false;

        HashMap<Character, Integer> hm1 = new HashMap<>();
        for(int i = 0; i < s1.length(); i++) {
            hm1.put(s1.charAt(i), hm1.getOrDefault(s1.charAt(i), 0) + 1);
        }

        HashMap<Character, Integer> hm2 = new HashMap<>();
        // populating till we are going to be reaching the length of s1
        for(int i = 0; i < s1.length(); i++) {
            hm2.put(s2.charAt(i), hm2.getOrDefault(s2.charAt(i), 0) + 1);
        }

        // if they are equal
        if(hm1.equals(hm2)) return true;

        int low = 0;
        int high = s1.length();

        while(high < s2.length()) {
            hm2.put(s2.charAt(low), hm2.get(s2.charAt(low))-1);
            if(hm2.get(s2.charAt(low)) == 0) hm2.remove(s2.charAt(low));
            low++;
            hm2.put(s2.charAt(high), hm2.getOrDefault(s2.charAt(high), 0) + 1);
            if(hm1.equals(hm2)) return true;
            high++;
        }
        return false;
    }

    public boolean checkInclusion2(String s1, String s2) {
        // base case
        if(s2.length() < s1.length()) return false;

        HashMap<Character, Integer> hm1 = new HashMap<>();
        for(int i = 0; i < s1.length(); i++) {
            hm1.put(s1.charAt(i), hm1.getOrDefault(s1.charAt(i), 0) + 1);
        }

        HashMap<Character, Integer> hm2 = new HashMap<>();
        // loop till the length of s1 and populate the hm2 
        for(int i = 0; i < s1.length(); i++) {
            hm2.put(s2.charAt(i), hm2.getOrDefault(s2.charAt(i), 0) + 1);
        }

        if(hm1.equals(hm2)) return true;

        int low = 0;
        int high = s1.length()-1;

        while(high < s2.length()-1) {
            hm2.put(s2.charAt(low), hm2.get(s2.charAt(low))-1);
            if(hm2.get(s2.charAt(low)) == 0) hm2.remove(s2.charAt(low));
            low++;
            high++;
            hm2.put(s2.charAt(high), hm2.getOrDefault(s2.charAt(high), 0) + 1);
            if(hm1.equals(hm2)) return true;
        }
        return false;
    }

    public boolean checkInclusion1(String s1, String s2) {
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
