class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> count = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        int tlen = t.length();
        for (int i = 0; i < tlen; i++) {
            count.put(t.charAt(i), count.getOrDefault(t.charAt(i), 0) + 1);
        }

        int match = 0;
        int need = count.size();
        int l = 0;
        String res = "";
        int min = Integer.MAX_VALUE;
        for (int r = 0; r < s.length(); r++) {
            char rc = s.charAt(r);
            window.put(rc, window.getOrDefault(rc, 0) + 1);

            if (count.containsKey(rc) && count.get(rc) == window.get(rc)) {
                match++;
            }

            while(match == need) {
                if (r - l + 1 < min) {
                    min = r - l + 1;
                    res = s.substring(l, r + 1);
                }

                char lc = s.charAt(l);
                window.put(lc, window.getOrDefault(lc, 0) - 1);

                if (count.containsKey(lc) && count.get(lc) == window.get(lc) + 1) {
                    match--;
                }

                l++;
            }
        }

        return res;
    }
}
