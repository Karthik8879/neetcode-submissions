class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(!rowHelper(board, i) || !colHelper(board, j)) {
                    return false;
                }
            }
        }

        for(int i = 0; i < 9; i+=3) {
            for(int j = 0; j < 9; j+=3) {
                if (!gridHelper(board, i, j)) {
                    return false;
                }            
            }
        }

        return true;
    }

    private boolean rowHelper(char[][] board, int row) {
        HashSet<Character> hs = new HashSet<>();
        for(int j = 0; j < 9; j++) {
            if(board[row][j] == '.') continue;
            if(hs.contains(board[row][j])) return false;
            hs.add(board[row][j]);
        }
        return true;
    }

    private boolean colHelper(char[][] board, int col) {
        HashSet<Character> hs = new HashSet<>();
        for(int i = 0; i < 9; i++) {
            if(board[i][col] == '.') continue;
            if(hs.contains(board[i][col])) return false;
            hs.add(board[i][col]);
        }
        return true;
    }

    private boolean gridHelper(char[][] board, int row, int col) {
        HashSet<Character> hs = new HashSet<>();
        for(int i = row; i < row+3; i++) {
            for(int j = col; j < col+3; j++) {
                if(board[i][j] == '.') continue;
                if(hs.contains(board[i][j])) return false;
                hs.add(board[i][j]);
            }
        }
        return true;
    }
}
