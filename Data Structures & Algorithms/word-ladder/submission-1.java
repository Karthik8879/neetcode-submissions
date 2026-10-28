class Solution {
    class Custom{
        String word = "";
        int level = 0;
        Custom(String word, int level) {
            this.word = word;
            this.level = level;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> hs = new HashSet<>(wordList);
        if(!hs.contains(endWord)) {
            return 0;
        }
        return bfs(beginWord, endWord, hs);
    }

    int bfs(String beginWord, String endWord, Set<String> hs) {
        Queue<Custom> q = new LinkedList<>();
        q.offer(new Custom(beginWord, 1));
        hs.remove(beginWord);

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                Custom custom = q.poll();
                String word = custom.word;
                int level = custom.level;
                if(word.equals(endWord)) {
                    return level;
                }
                char[] letters = word.toCharArray();
                // just looping through the letters array
                for(int pos = 0; pos < letters.length; pos++) {
                    char original = letters[pos];
                    for(char ch = 'a'; ch <= 'z'; ch++) {
                        if(ch == original) {
                            continue;
                        }
                        letters[pos] = ch;
                        String nextWord = new String(letters);
                        if(hs.contains(nextWord)) {
                            hs.remove(nextWord);
                            q.offer(new Custom(nextWord, level+1));
                        }
                    }
                    // restore the original character again before we are going to be moving to the next character
                    letters[pos] = original;
                }
            }
        }
        return 0; // where transformation is not possible to reach result wrt the given words in wordList
    }
}
