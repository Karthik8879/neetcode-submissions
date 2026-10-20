class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrack(n, 0, 0, sb, res);
        return res;
    }

    void backtrack(int n, int openCnt, int closeCnt, StringBuilder sb, List<String> res) {
        // base case
        if(sb.length() > n*2) {
            return;
        }
        if(sb.length() == n*2) {
            res.add(sb.toString());
            return;
        }

        char[] chars = {'(', ')'};

        for(char ch : chars) {
            if(ch == '(' && openCnt < n) {
                // addition step
                sb.append(ch);
                backtrack(n, openCnt+1, closeCnt, sb, res);
                // backtrack step
                sb.deleteCharAt(sb.length()-1);
            } else if(ch == ')' && closeCnt < openCnt) {
                 // here we have to do this closeCnt < openCnt instead of closeCnt < n because we never want to have closeCnt > openCnt because we want to always have first open brackend and corresponding closing bracket
                 // addition step
                 sb.append(ch);
                 backtrack(n, openCnt, closeCnt+1, sb, res);
                 // backtrack step
                 sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}
