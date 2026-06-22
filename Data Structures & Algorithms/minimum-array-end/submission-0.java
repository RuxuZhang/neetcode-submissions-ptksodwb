class Solution {
    public long minEnd(int n, int x) {
        long res = (long)x;
        long ix = 1;
        long in = 1;

        while (in <= n - 1) {
            if ((x & ix) == 0) {
                if ((in & (n - 1)) != 0) {
                    res |= ix;
                }
                in = in << 1;
            }
            ix = ix << 1;
        }

        return res;
    }
}