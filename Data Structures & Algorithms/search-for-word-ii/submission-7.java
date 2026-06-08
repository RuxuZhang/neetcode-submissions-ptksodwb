class Node {
    Map<Character, Node> children = new HashMap<>();
    boolean isEnd = false;
    int index = -1;
}

class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word, int i) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            cur.children.putIfAbsent(c, new Node());
            cur = cur.children.get(c);
        }
        cur.isEnd = true;
        cur.index = i;
    }
}

class Solution {
    int n;
    int m;
    int[][] visit;
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    Set<String> ans = new HashSet<>();

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (int i = 0; i < words.length; i++) {
            trie.insert(words[i], i);
        }

        n = board.length;
        m = board[0].length;
        visit = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(board, i, j, trie.root, words);
            }
        }

        return new ArrayList<>(ans);
    }

    private void dfs(char[][] board, int i, int j, Node node, String[] words) {
        if (i < 0 || i >= n || j < 0 || j >= m || node == null || visit[i][j] == 1) {
            return;
        }

        char c = board[i][j];
        visit[i][j] = 1;
        Node next = node.children.get(c);

        if (next != null && next.isEnd == true) {
            ans.add(words[next.index]);
        }

        for (int[] dir : directions) {
            dfs(board, i + dir[0], j + dir[1], next, words);
        }
        visit[i][j] = 0;
    }
}
