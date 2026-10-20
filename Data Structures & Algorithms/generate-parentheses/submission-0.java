class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrack(n, 0, 0, sb, res);
        return res;
    }

    void backtrack(int n, int openCnt, int closeCnt, StringBuilder sb, List<String> res) {
        // base case
        if(sb.length() > n*2) return;
        if(sb.length() == n*2) {
            res.add(sb.toString());
            return;
        }

        char[] choices = {'(', ')'};

        for(char ch : choices) {
            if(ch == '(' && openCnt < n) {
                // addition step
                sb.append(ch);
                backtrack(n, openCnt+1, closeCnt, sb, res);
                // backtrack
                sb.deleteCharAt(sb.length()-1);
            } else if(ch == ')' && closeCnt < openCnt) {
                // addition step
                sb.append(ch);
                backtrack(n, openCnt, closeCnt+1, sb, res);
                // backtrack
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}
