class Solution {
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        
        int nn = Math.abs(n);
        double res = 1;

        while (nn != 0) {
            if (nn % 2 == 1) {
                res *= x;
            }

            x *= x;
            nn = nn / 2;
        }
        
        return n >= 0 ? res : 1 / res;
    }
}
