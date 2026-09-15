class WordDictionary {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    public void addWord(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }

        current.isEnd = true;
    }
    public boolean search(String word) {
        return dfs(word, 0, root);
    }
    private boolean dfs(String word, int index, TrieNode node) {
        if (index == word.length()) {
            return node.isEnd;
        }
        char c = word.charAt(index);
        if (c != '.') {
            int childIndex = c - 'a';
            if (node.children[childIndex] == null) {
                return false;
            }
            //
            return dfs(word, index + 1, node.children[childIndex]);
        }
        for (TrieNode child : node.children) {
            if (child != null && dfs(word, index + 1, child)) {
                return true;
            }
        }

        return false;
    }
}
