class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> hmP = new HashMap<>();
        for(int i = 0; i < p.length(); i++) {
            hmP.put(p.charAt(i), hmP.getOrDefault(p.charAt(i), 0) + 1);
        }

        int start = 0, end = 0;
        int n = s.length();
        List<Integer> res = new ArrayList<>();
        HashMap<Character, Integer> hmS = new HashMap<>();
        while(end < n) {
            hmS.put(s.charAt(end), hmS.getOrDefault(s.charAt(end), 0) + 1);
            if((end - start + 1) > p.length()) {
                hmS.put(s.charAt(start), hmS.get(s.charAt(start))-1);
                if(hmS.get(s.charAt(start)) == 0) {
                    hmS.remove(s.charAt(start));
                }
                start++;
            }
            if(end - start + 1 == p.length()) {
                if(hmS.equals(hmP)) {
                    res.add(start);
                }
            }
            end++;
        }
        return res;
    }
}
