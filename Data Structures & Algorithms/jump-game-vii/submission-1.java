class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        if (s.charAt(n - 1) == '1') {
            return false;
        }

        boolean[] dp = new boolean[n];
        dp[n - 1] = true;

        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                continue;
            }

            for (int j = i + minJump; j <= Math.min(n - 1, i + maxJump); j++) {
                dp[i] |= dp[j];
            }
        }

        return dp[0];
    }
}