class Node {
    Map<Character, Node> children = new HashMap<>();
    boolean isEnd = false;
}

class PrefixTree {

    Node root;

    public PrefixTree() {
         root = new Node();
    }

    public void insert(String word) {
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
            if (!p.children.keySet().contains(c)) {
                return false;
            }
            p = p.children.get(c);
        }
        return p.isEnd;
    }

    public boolean startsWith(String prefix) {
        Node p = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!p.children.keySet().contains(c)) {
                return false;
            }
            p = p.children.get(c);
        }
        return true;
    }
}
