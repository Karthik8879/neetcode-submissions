class Solution {
    HashMap<Character, String> hm; // GLOBAL variable

    Solution() { // initialize it inside of the constructor
        hm = new HashMap<>();
        hm.put('2', "abc");
        hm.put('3', "def");
        hm.put('4', "ghi");
        hm.put('5', "jkl");
        hm.put('6', "mno");
        hm.put('7', "pqrs");
        hm.put('8', "tuv");
        hm.put('9', "wxyz");
    }
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        // base case
        if(digits.length() == 0) {
            return res;
        }
        StringBuilder tempSb = new StringBuilder();
        int start = 0;
        backtrack(digits, start, tempSb, res);
        return res;
    }

    void backtrack(String digits, int start, StringBuilder sb, List<String> res) {
        // base case
        if(sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }

        // getting characters from hm
        String letters = hm.get(digits.charAt(start));

        int maxLen = letters.length();

        // here we are starting from 0 always because we are having to find all of the permutations again and again
        for(int i = 0; i < maxLen; i++) {
            // take step
            sb.append(letters.charAt(i));
            backtrack(digits, start+1, sb, res);
            // backtrack step
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
