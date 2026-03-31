class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> rowSet = new HashSet<>();
        Set<String> colSet = new HashSet<>();
        Set<String> boxSet = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (Character.isDigit(board[i][j])) {
                    String cur = String.valueOf(board[i][j]);
                    String row = String.valueOf(i) + cur;
                    String col = String.valueOf(j) + cur;
                    String box = String.valueOf(i / 3) + String.valueOf(j / 3) + cur;

                    if (rowSet.contains(row) || colSet.contains(col) || boxSet.contains(box)) {
                        return false;
                    }

                    rowSet.add(row);
                    colSet.add(col);
                    boxSet.add(box);
                }
            }
        }
        
        return true;
    }
}
