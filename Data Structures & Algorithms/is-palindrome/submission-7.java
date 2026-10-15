class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            // populate sb with the cleaned format
            if(Character.isLetterOrDigit(s.charAt(i))) {
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        String str = sb.toString();
        String reverse = sb.reverse().toString();
        return str.equals(reverse);
    }
}
