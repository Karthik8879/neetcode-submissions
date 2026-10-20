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
        backtrack(digits, 0, tempSb, res);
        return res;
    }

    void backtrack(String digits, int start, StringBuilder tempSb, List<String> res) {
        // base case
        if(tempSb.length() == digits.length()) {
            res.add(tempSb.toString());
            return;
        }

        // fetching letter wrt the digits
        String letters = hm.get(digits.charAt(start));

        for(int i = 0; i < letters.length(); i++) {
            // take step
            tempSb.append(letters.charAt(i));
            backtrack(digits, start+1, tempSb, res);
            // backtrack step
            tempSb.deleteCharAt(tempSb.length()-1);
        }
    }
}
