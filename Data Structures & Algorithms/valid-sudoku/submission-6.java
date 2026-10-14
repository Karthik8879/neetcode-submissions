class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] grids = new HashSet[9];

        // populating each and every cell with hashset
        for(int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            grids[i] = new HashSet<>();
        }

        for(int r = 0; r < 9; r++) {
            for(int c = 0; c < 9; c++) {

                char ch = board[r][c];

                if(board[r][c] == '.') continue;

                int boxIdx = (r/3) * 3 + (c/3);

                if (rows[r].contains(ch) ||
                    cols[c].contains(ch) ||
                    grids[boxIdx].contains(ch)) {
                    return false;
                }

                rows[r].add(board[r][c]);
                cols[c].add(board[r][c]);
                grids[boxIdx].add(board[r][c]);
            }
        }
        return true;
    }
}
