class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];

        int maxf = 0;
        int l = 0;
        int res = 0;

        for (int r = 0; r < s.length(); r++) {
            char rc = s.charAt(r);
            freq[rc - 'A']++;
            maxf = Math.max(maxf, freq[rc - 'A']);

            while (r - l + 1 - maxf > k) {
                freq[s.charAt(l) - 'A']--;
                l++;
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
