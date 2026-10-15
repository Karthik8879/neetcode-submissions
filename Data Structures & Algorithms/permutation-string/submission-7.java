class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        char[] target = s1.toCharArray();
        Arrays.sort(target);
        String sorted = new String(target);
        for(int i = 0; i < s2.length()-s1.length()+1; i++) {
            char[] wanted = s2.substring(i, i+s1.length()).toCharArray();
            Arrays.sort(wanted);
            if(sorted.equals(new String(wanted))) return true;
        }
        return false;
    }
}
