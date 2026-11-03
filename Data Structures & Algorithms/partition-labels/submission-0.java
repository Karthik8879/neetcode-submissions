class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
        }

        int start = 0;
        int end = 0;
        List<Integer> res = new ArrayList<>();

        HashSet<Character> hs = new HashSet<>();
        while(end < s.length()) {
            hs.add(s.charAt(end));
            hm.put(s.charAt(end), hm.get(s.charAt(end))-1);
            if(hm.get(s.charAt(end)) == 0) {
                hm.remove(s.charAt(end));
                hs.remove(s.charAt(end));
            }
            if(hs.isEmpty()) {
                res.add(end-start+1);
                start = end+1;
            }
            end++;
        }
        return res;
    }
}
