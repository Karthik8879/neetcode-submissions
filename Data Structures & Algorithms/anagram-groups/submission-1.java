class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hm = new HashMap<>();
        List<List<String>> res = new ArrayList<>();

        for(String s : strs) {
            String hs = helper(s);
            if(!hm.containsKey(hs)) {
                hm.put(hs, new ArrayList<>());
            }
            hm.get(hs).add(s);
        }

        for(HashMap.Entry<String, List<String>> entry : hm.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            res.add(value);
        }
        return res;
    }

    private String helper(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}
