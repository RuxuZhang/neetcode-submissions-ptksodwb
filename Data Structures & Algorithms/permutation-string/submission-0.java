class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }

        int match = 0;
        for (int i = 0; i < 26; i++) {
            if (count1[i] == count2[i]) {
                match++;
            }
        }

        int l = 0;
        for (int r = s1.length(); r < s2.length(); r++) {
            if (match == 26) {
                return true;
            }

            int ri = s2.charAt(r) - 'a';
            count2[ri]++;

            if (count1[ri] == count2[ri]) {
                match++;
            } else if (count1[ri] == count2[ri] - 1) {
                match--;
            }

            int li = s2.charAt(l) - 'a';
            count2[li]--;

            if (count1[li] == count2[li]) {
                match++;
            } else if (count1[li] == count2[li] + 1) {
                match--;
            }

            l++;
        }

        return match == 26;
    }
}
