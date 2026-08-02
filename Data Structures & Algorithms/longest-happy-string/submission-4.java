class Solution {
    // Greedy greedy
    public String longestDiverseString(int a, int b, int c) {
        int[] count = {a, b, c};
        StringBuilder sb = new StringBuilder();

        while (count[0] > 0 || count[1] > 0 || count[2] > 0) {
            int maxIndex = getMaxIndex(count, -1);
            char maxChar = (char) ('a' + maxIndex);
            int len = sb.length();
            if (len >= 2 && sb.charAt(len - 1) == maxChar && sb.charAt(len - 2) == maxChar) {
                maxIndex = getMaxIndex(count, maxIndex);   // exclude the blocked one
                if (maxIndex == -1) break;                  // nothing else available
                maxChar = (char) ('a' + maxIndex);
            }

            if (count[maxIndex] == 0) {
                break;
            }

            sb.append(maxChar);
            count[maxIndex] -= 1;
        }

        return sb.toString();
    }

    private int getMaxIndex(int[] count, int excludeIndex) {
        int best = -1;
        for (int i = 0; i < count.length; i++) {
            if (i == excludeIndex) continue;
            if (count[i] > 0 && (best == -1 || count[i] > count[best])) {
                best = i;
            }
        }
        return best;
    }
}