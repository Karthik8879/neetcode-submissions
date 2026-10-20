class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        List<StringBuilder> temp = new ArrayList<>();
        // initialize the board with .
        for(int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++) {
                sb.append('.');
            }
            temp.add(sb);
        }
        int row = 0;
        backtrack(n, row, temp, res);
        return res;
    }

    void backtrack(int n, int row, List<StringBuilder> temp, List<List<String>> res) {
        // base case
        if(row == n) {
            List<String> solution = new ArrayList<>();
            for(StringBuilder sb : temp) {
                solution.add(sb.toString());
            }
            res.add(solution);
            return;
        }

        // loop through all columns
        for(int col = 0; col < n; col++) {
            if(isSafe(row, col, temp)) {
                // take step
                temp.get(row).setCharAt(col, 'Q');
                backtrack(n, row+1, temp, res);
                // backtrack step
                temp.get(row).setCharAt(col, '.');
            }
        }
    }

    boolean isSafe(int row, int col, List<StringBuilder> temp) {
        for(int prevRow = 0; prevRow < row; prevRow++) {
            int prevCol = temp.get(prevRow).indexOf("Q");
            // same col
            if(prevCol == col) {
                return false;
            }
            // Same diagonal
            if(Math.abs(prevRow - row) == Math.abs(prevCol - col)) {
                return false;
            }
        }
        return true;
    }
}
