class WordDictionary {

    class Custom {
        Custom[] children = new Custom[26];
        boolean flag = false;

        Custom() {}

        boolean containsKey(char ch) {
            if(children[ch - 'a'] == null) return false;
            return true;
        }

        Custom get(char ch) {
            return children[ch-'a'];
        }

        void put(char ch, Custom node) {
            children[ch-'a'] = node;
        }

        void setEnd() {
            flag = true;
        }

        boolean isEnd() {
            return flag == true;
        }
    }

    Custom root; // initializing the root variable on global level

    public WordDictionary() {
        root = new Custom();
    }

    public void addWord(String word) {
        Custom curr = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(!curr.containsKey(ch)) {
                curr.put(ch, new Custom());
            }
            curr = curr.get(ch);
        }
        curr.setEnd();
    }

    public boolean search(String word) {
        Custom curr = root;
        return searchHelper(word, 0, curr);
    }

    public boolean searchHelper(String word, int idx, Custom curr) {
        if(idx == word.length()) {
            return curr.isEnd();
        }

        char ch = word.charAt(idx);

        if(ch == '.') {
            for(int i = 0; i < 26; i++) {
                if(curr.children[i] != null) {
                    if(searchHelper(word, idx+1, curr.children[i])) {
                        return true;
                    }
                }
            }
            return false;
        }

        // normal characters
        if(!curr.containsKey(ch)) return false;

        return searchHelper(word, idx+1, curr.get(ch));
    }
}
