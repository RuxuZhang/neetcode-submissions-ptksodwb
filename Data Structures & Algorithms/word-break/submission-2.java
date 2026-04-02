class Node {
    Map<Character, Node> children = new HashMap<>();
    boolean isEnd = false;
}

class Trie {
    Node root = new Node();

    public void insert(String s) {
        if (s.length() <= 0) {
            return;
        }

        Node p = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            p.children.putIfAbsent(c, new Node());
            p = p.children.get(c);
        }

        p.isEnd = true;
    }

    public boolean search(String s) {
        Node p = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!p.children.keySet().contains(c)) {
                return false;
            }
            p = p.children.get(c);
        }
        return p.isEnd;
    }
}

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();
        for (String word : wordDict) {
            trie.insert(word);
        }

        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[n] = true;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (trie.search(s.substring(i, j + 1)) && dp[j + 1]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[0];
    }
}
