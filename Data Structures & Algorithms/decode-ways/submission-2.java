class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }

        int[] dp = new int[s.length()];
        dp[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            int oneDigit = s.charAt(i) - '0';
            int twoDigits = Integer.valueOf(s.substring(i - 1, i + 1));

            if (oneDigit == 0 && (twoDigits > 26 || twoDigits == 0)) {
                return 0;
            }

            if (twoDigits > 26 || twoDigits < 10) {
                dp[i] = dp[i - 1];
            } else if (twoDigits == 10 || twoDigits == 20) {
                dp[i] = i == 1 ? 1 : dp[i - 2];
            } else {
                dp[i] = i == 1 ? 2 : dp[i - 1] + dp[i - 2];
            }
        }

        return dp[s.length() - 1];
    }
}
