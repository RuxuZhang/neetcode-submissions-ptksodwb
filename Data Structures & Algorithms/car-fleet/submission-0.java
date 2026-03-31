class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pairs = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            pairs[i] = new int[]{position[i], speed[i]};
        }
        Arrays.sort(pairs, (a, b) -> b[0] - a[0]);

        int fleet = 0;
        double prevTime = 0;

        for (int i = 0; i < position.length; i++) {
            int l = target - pairs[i][0];
            int s = pairs[i][1];
            double t = (double) l / s;
            if (t > prevTime) {
                fleet++;
                prevTime = t;
            }
        }

        return fleet;
    }
}
