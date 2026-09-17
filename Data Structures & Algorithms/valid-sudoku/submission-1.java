class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = i; j < board[0].length; j++) {
                if(!helperRow(board, i) || !helperCol(board, j)) return false;
            }
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!helperGrid(board, i, j)) {
                    return false;
                }
            }
        }
        return true;

    }

    private boolean helperRow(char[][] board, int row) {
        // for row we should not have repeat values from 1 to 9
        HashSet<Character> hs = new HashSet<>();
        for(int j = 0; j < 9; j++) {
            char ch = board[row][j];
            if(ch == '.') continue;
            if(!hs.contains(ch)) hs.add(ch);
            else return false;
        }
        return true;
    }

    private boolean helperCol(char[][] board, int col) {
        // for col we should not have repeat values from 1 to 9
        HashSet<Character> hs = new HashSet<>();
        for(int i = 0; i < 9; i++) {
            char ch = board[i][col];
            if(ch == '.') continue;
            if(!hs.contains(ch)) hs.add(ch);
            else return false;
        }
        return true;

    }

    private boolean helperGrid(char[][] board, int row, int col) {
        // for 3X3 grid we should not have repeat values from 1 to 9
        HashSet<Character> hs = new HashSet<>();
        for(int i = row; i < row+3; i++) {
            for(int j = col; j < col+3; j++) {
                char ch = board[i][j];
                if(ch == '.') continue;
                if(!hs.contains(ch)) hs.add(ch);
                else return false;
            }
        }
        return true;
    } 
}
