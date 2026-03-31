class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) {
            return false;
        }

        Arrays.sort(hand);
        boolean[] visited = new boolean[n];
        int i = 0;
        int next = -1;
        while (i < n) {
            int prev = -1;
            int k = 0;
            while (k < groupSize) {
                if (i >= n) {
                    return false;
                }
                if (visited[i]) {
                    i++;
                    continue;
                }
                if (prev != -1 && hand[i] < prev + 1) {
                    if (next == -1) {
                        next = i;
                    }
                    i++;
                    continue;
                }
                if (prev != -1 && hand[i] > prev + 1) {
                    return false;
                }
                visited[i] = true;
                prev = hand[i];
                i++;
                k++;
            }

            i = next == -1 ? i : next;
            next = -1;
        }

        return true;
    }
}
