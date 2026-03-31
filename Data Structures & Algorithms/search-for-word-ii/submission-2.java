class Node {
    Map<Character, Node> children = new HashMap<>();
    boolean isEnd = false;
}

class Solution {
    Node root = new Node();
    List<String> ans = new ArrayList<>();
    int[][] visited;

    public List<String> findWords(char[][] board, String[] words) {
        for (String word : words) {
            addWord(word);
        }
        
        visited = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, "");
            }
        }

        return ans;
    }

    private void addWord(String word) {
        Node p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            p.children.putIfAbsent(c, new Node());
            p = p.children.get(c);
        }
        p.isEnd = true;
    }

    private void dfs(char[][] board, int i, int j, Node node, String word) {
        char c = board[i][j];

        if (!node.children.keySet().contains(c)) {
            return;
        }

        word += c;
        node = node.children.get(c);
        visited[i][j] = 1;

        if (node.isEnd && !ans.contains(word)) {
            ans.add(word);
        }

        if (i - 1 >= 0 && visited[i - 1][j] == 0) dfs(board, i - 1, j, node, word);
        if (i + 1 < board.length && visited[i + 1][j] == 0) dfs(board, i + 1, j, node, word);
        if (j - 1 >= 0 && visited[i][j - 1] == 0) dfs(board, i, j - 1, node, word);
        if (j + 1 < board[0].length && visited[i][j + 1] == 0) dfs(board, i, j + 1, node, word);

        visited[i][j] = 0;
    }
}
