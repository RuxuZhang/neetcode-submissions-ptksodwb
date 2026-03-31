class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char c : tasks) {
            count[c - 'A']++;
        }

        Arrays.sort(count);
        int max = count[25];

        int idle = (max - 1) * n;
        for (int i = 0; i < 25; i++) {
            int cnt = count[i];
            idle -= Math.min(cnt, max - 1);
        }

        if (idle <= 0) {
            return tasks.length;
        } else {
            return idle + tasks.length;
        }
    }
}
