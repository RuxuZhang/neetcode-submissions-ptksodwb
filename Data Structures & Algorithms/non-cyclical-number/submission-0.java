class Solution {
    public boolean isHappy(int n) {

        Set<Integer> seen = new HashSet<>();

        while (n != 1) {
            int sum = 0;
            while (n != 0) {
                int d = n % 10;
                n = n / 10;
                sum += d * d;
            }

            n = sum;

            if (seen.contains(n)) {
                return false;
            } else {
                seen.add(n);
            }
        }
        
        return true;
    }
}
