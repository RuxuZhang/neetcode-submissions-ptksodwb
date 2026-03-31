class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            if (recursion(gas, cost, i, 0, 0)) {
                return i;
            }
        }
        return -1;
    }

    private boolean recursion(int[] gas, int[] cost, int i, int left, int step) {
        if (step == gas.length && left >= 0) {
            return true;
        }

        int newLeft = left + gas[i] - cost[i];
        if (newLeft < 0) {
            return false;
        }

        return recursion(gas, cost, i + 1 == gas.length ? 0 : i + 1, newLeft, step + 1);
    }
}
