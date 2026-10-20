class Solution {
    int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // global level
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(backtrack(board, word, new StringBuilder(), i, j, n, m)){
                    return true;
                }
            }
        }
        return false;
    }

    boolean backtrack(char[][] board, String word, StringBuilder sb, int r, int c, int n, int m) {
        // base case
        // boundry value check
        if(r < 0 || c < 0 || r >= n || c >= m) {
            return false;
        }

        // 1 more base case
        if(sb.length() > word.length()) {
            return false;
        }

        // saving the ch so that we can backtrack it later
        char ch = board[r][c];

        boolean found = false;

        // we need to add ch into the sb before we are making the visit 
        sb.append(ch);

        // if we have found the word then we have to immediately return true
        if(sb.toString().equals(word)) {
            return true;
        }
        // marking as visited
        board[r][c] = '#';

        for(int[] dir : DIRS) {
            int newRow = r + dir[0];
            int newCol = c + dir[1];
            if(backtrack(board, word, sb, newRow, newCol, n, m)) {
                found = true;
                break;
            }
        }

        // we have to remove word from sb as well in case of backtracking step
        sb.deleteCharAt(sb.length()-1);
        // backtrack step
        board[r][c] = ch;

        return found;
    }
}
