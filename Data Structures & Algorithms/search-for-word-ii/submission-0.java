class Solution {

    // Prepare Trie with 1. Custom class 2. Insert 3. Search
    // Perform DFS on grid to search each word exists in Grid or not

    class Custom{
        Custom[] children = new Custom[26];
        boolean isEnd = false;
        String word = null; // here as soon as we have isEnd = true we can add that word for faster search

        Custom() {}

        void insert(String word) {
            Custom curr = root;
            for(int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if(curr.children[ch - 'a'] == null) {
                    curr.children[ch - 'a'] = new Custom();
                }
                curr = curr.children[ch - 'a'];
            }
            curr.isEnd = true;
            curr.word = word;
        }

        boolean search(String word) {
            Custom curr = root;
            for(int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if(curr.children[ch - 'a'] == null) {
                    return false;
                }
                curr = curr.children[ch - 'a'];
            }
            return curr.isEnd;
        }

    }

    // Calling Root in Global level
    Custom root;

    Solution() {
        root = new Custom(); // initialization inside of constructor as well
    }

    public List<String> findWords(char[][] board, String[] words) {
        int n = board.length;
        int m = board[0].length;

        List<String> res = new ArrayList<>();

        // populating the trie DS
        for(String word : words) {
            root.insert(word);
        }

        // Performing DFS
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                dfs(board, i, j, root, res, n, m);
            }
        }

        return res;
    }

    void dfs(char[][] board, int r, int c, Custom curr, List<String> res, int n, int m) {
        // boundry check
        if(r < 0 || c < 0 || r >= n || c >= m) {
            return;
        }

        char ch = board[r][c];

        // check if already visited ch
        if(ch == '#') {
            return;
        }

        // check whether ch exists in the trie or not
        if(curr.children[ch - 'a'] == null) {
            return;
        }

        // move to the next trie node
        curr = curr.children[ch - 'a'];

        // if complete word is found
        if(curr.isEnd) {
            res.add(curr.word);
            curr.isEnd = false; // so that we do not add the word again
        }

        board[r][c] = '#'; // mark the cell as visited

        // do this for all of the directions
        dfs(board, r+1, c, curr, res, n, m);
        dfs(board, r, c+1, curr, res, n, m);
        dfs(board, r-1, c, curr, res, n, m);
        dfs(board, r, c-1, curr, res, n, m);

        // backtrack and restore original character
        board[r][c] = ch;
     }
}
