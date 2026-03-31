class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(String s, int i, List<String> cur, List<List<String>> res) {
        if (i >= s.length()) {
            res.add(new ArrayList<>(cur));
        }

        for (int j = i; j < s.length(); j++) {
            String sub = s.substring(i, j + 1);
            if (isPalin(sub)) {
                cur.add(sub);
                backtrack(s, j + 1, cur, res);
                cur.remove(cur.size() - 1);
            }
        }
    }

    private boolean isPalin(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
