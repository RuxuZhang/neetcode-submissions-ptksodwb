class Node {
    Map<Character, Node> children = new HashMap<>();
    boolean isEnd = false;
}

class WordDictionary {

    Node root;

    public WordDictionary() {
        root = new Node();
    }

    public WordDictionary(Node n) {
        root = n;
    }

    public void addWord(String word) {
        Node p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!p.children.keySet().contains(c)) {
                p.children.put(c, new Node());
            }

            p = p.children.get(c);

            if (i == word.length() - 1) {
                p.isEnd = true;
            }
        }
    }

    public boolean search(String word) {
        Node p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (Node n : p.children.values()) {
                    WordDictionary dic = new WordDictionary(n);
                    boolean b = dic.search(word.substring(i + 1, word.length()));
                    if (b) {
                        return b;
                    }
                }
                return false;
            } else if (!p.children.keySet().contains(c)) {
                return false;
            }
            p = p.children.get(c);
        }
        return p.isEnd;
    }
}
