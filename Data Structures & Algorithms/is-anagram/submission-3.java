class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] arr = new int[26];
         
        // loop through arr and fill in the numbers
        for(int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            arr[charS-'a']++;
            arr[charT-'a']--;
        }

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != 0) return false;
        }

        return true;
    }
}
