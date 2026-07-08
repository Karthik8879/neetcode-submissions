class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hm = new HashMap<>();
        for(String s : strs) {
            String hS = helper(s);
            if(!hm.containsKey(hS)) {
                hm.put(hS, new ArrayList<>());
            } 
            hm.get(hS).add(s);
        } 

        List<List<String>> finalAns = new ArrayList<>();
        for(HashMap.Entry<String, List<String>> entry : hm.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            finalAns.add(value);
        }
        return finalAns;
    }

    private String helper(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}
