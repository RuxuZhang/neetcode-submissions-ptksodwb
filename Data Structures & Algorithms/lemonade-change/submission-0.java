class Solution {
    public boolean lemonadeChange(int[] bills) {
        int ten = 0;
        int five = 0;

        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                five--;
                ten++;
            } else if (ten > 0) {
                ten--;
                five--;
            } else {
                five -= 3;
            }

            if (five < 0) {
                return false;
            }
        }

        return true;
    }
}