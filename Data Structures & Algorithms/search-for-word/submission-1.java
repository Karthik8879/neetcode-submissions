class Solution {

    int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    class Trie{
        Trie[] children = new Trie[52]; // here we are doing 52 instead of 26 because here we are considering both lower case and upper case characters
        boolean isEnd = false;

        Trie() {}
    }

    // functions on insertion and search wrt Trie
    void insert(String word) {
        Trie curr = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int idx = getIndex(ch);
            if(curr.children[idx] == null) {
                curr.children[idx] = new Trie();
            }
            curr = curr.children[idx];
        }
        curr.isEnd = true;
    }

    boolean search(String word) {
        Trie curr = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int idx = getIndex(ch);
            if(curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.isEnd;
    }

    int getIndex(char ch) {
        if(ch >= 'A' && ch <= 'Z') {
            return ch - 'A';
        } else {
            return ch - 'a';
        }
    }

    // root level initialization
    Trie root;

    Solution() {
        root = new Trie();
    }

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        insert(word); // populating trie
        // for 2d array we have to make use of the 2 loops
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(backtrack(board, word, root, i, j, n, m)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean backtrack(char[][] board, String word, Trie curr, int r, int c, int n, int m) {
        // base case
        // boundry checks
        if(r < 0 || c < 0 || r >= n || c >= m) {
            return false;
        }

        if(board[r][c] == '#') {
            return false;
        }

        char ch = board[r][c];
        int idx = getIndex(ch);
        boolean found = false;

        // we need to have ch as a part of the trie
        if(curr.children[idx] == null) {
            return false; // we can do this straign away
        }

        // we are moving to the next reference of the trie
        curr = curr.children[idx];

        // if we found the complete word
        if(curr.isEnd) {
            return true; // we have to return true because we have found the complete word
        }

        // here is where we are starting to do our problem
        board[r][c] = '#';

        for(int[] dir : DIRS) {
            int newRow = r + dir[0];
            int newCol = c + dir[1];
            if(backtrack(board, word, curr, newRow, newCol, n, m)) {
                found = true;
                break;
            }
        }
        // backtracking step
        board[r][c] = ch;
        return found;
    }
}
