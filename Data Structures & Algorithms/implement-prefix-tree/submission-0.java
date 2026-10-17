class PrefixTree {

    class Custom {
        Custom[] children = new Custom[26];
        boolean flag = false;

        Custom() {}

        public boolean containsKey(char ch) {
            if(children[ch - 'a'] != null) return true;
            return false;
        }

        public Custom get(char ch) {
            return children[ch - 'a'];
        }

        public void put(char ch, Custom node) {
            children[ch - 'a'] = node;
        }

        public void setEnd() {
            flag = true;
        }

        public boolean isEnd() {
            return flag;
        }


    }

    Custom root;

    public PrefixTree() {
        root = new Custom(); // we are making the custom node over here
    }


    public void insert(String word) {
        // calling the root node
        Custom curr = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(!curr.containsKey(ch)) {
                curr.put(ch, new Custom());
            }
            curr = curr.get(ch); // iterating through the reference going next to next reference
        }
        curr.setEnd();
    }

    public boolean search(String word) {
        Custom curr = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(!curr.containsKey(ch)) return false;
            curr = curr.get(ch); // iterating through the reference going next and next
        }
        return curr.isEnd();
    }

    public boolean startsWith(String prefix) {
        Custom curr = root;
        for(int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if(!curr.containsKey(ch)) return false;
            curr = curr.get(ch);
        }
        return true; // if we have reached end of prefix -> we have satisfied startsWith case
    }
}
