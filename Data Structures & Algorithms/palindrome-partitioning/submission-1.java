class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        backtrack(s, 0, temp, res);
        return res;
    }

    void backtrack(String s, int start, List<String> temp, List<List<String>> res) {
        // base case
        if(start == s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = start; i < s.length(); i++) {
            String sub = s.substring(start, i+1);
            // we are going to be doing operation only in case we are going to be having a palindrome as the sub
            if(!isPalindrome(sub)) continue;
            // keept step
            temp.add(sub);
            backtrack(s, i+1, temp, res);
            // backtrack step
            temp.remove(temp.size()-1);
        }
    }

    boolean isPalindrome(String s) {
        int low = 0, high = s.length()-1;
        while(low <= high) {
            if(s.charAt(low) != s.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}
