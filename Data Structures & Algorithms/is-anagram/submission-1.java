class Solution {

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] sArray = new int[26];
        for(int i = 0; i < s.length(); i++) {
            sArray[s.charAt(i) - 'a']++;
            sArray[t.charAt(i) - 'a']--;
        }
        for(int ele : sArray) {
            if(ele != 0) return false;
        }
        return true;
    }

    public boolean isAnagramBetter(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] sArray = new int[26];

        for(char ch : s.toCharArray()) {
            sArray[ch - 'a'] += 1;
        }

        for(char ch : t.toCharArray()) {
            sArray[ch - 'a'] -= 1;
        }

        for(int ele : sArray) {
            if(ele != 0) return false;
        }
        return true;
    }

    public boolean isAnagramBruteforce(String s, String t) {
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Arrays.sort(sArray);
        Arrays.sort(tArray);

        return Arrays.equals(sArray, tArray);
    }
}
