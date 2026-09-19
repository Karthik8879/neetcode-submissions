class Solution {

    // hm -> keySet(), valueSet(), entrySet()

    // key  : value
    // "act"  : ["act", "cat"]
    // "opts" : ["pots", "tops", "stop"]
    // "aht"  : ["hat"]

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hm = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            String key = helper(strs[i]); // aht
            if(!hm.containsKey(key)) {
                hm.put(key, new ArrayList<>());
            }
            hm.get(key).add(strs[i]);
        }

        List<List<String>> res = new ArrayList<>();

        for(HashMap.Entry<String, List<String>> entry : hm.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            res.add(value);
        }
        return res;
    }

    private String helper(String s) {
        char[] arr = s.toCharArray();
        // "act" -> ['a', 'c', 't']
        Arrays.sort(arr);
        return new String(arr); // "act"
    }


    public List<List<String>> groupAnagrams1(String[] strs) {
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

    private String helper1(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}
