class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int start = 0, end = 0;
        while(end < s.length()) {
            if (end - start + 1 == p.length()) {
                if(helper(s.substring(start, end+1), p)) {
                    res.add(start);
                }
                start++;
            }
            end++;
        }
        return res;
    }

    boolean helper(String s, String p) {
        char[] sArray = s.toCharArray();
        char[] pArray = p.toCharArray();
        Arrays.sort(pArray);
        Arrays.sort(sArray);
        return Arrays.equals(sArray, pArray);
    }
}
