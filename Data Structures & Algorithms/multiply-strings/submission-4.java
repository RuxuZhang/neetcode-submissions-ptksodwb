class Solution {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        int len1 = num1.length();
        int len2 = num2.length();
        int[] array = new int[len1 + len2 - 1];

        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();

        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                int n1 = num1.charAt(i) - '0';
                int n2 = num2.charAt(j) - '0';
                array[i + j] += n1 * n2;
            }
        }

        StringBuilder sb = new StringBuilder("");
        int carry = 0;
        for (int i = 0; i < len1 + len2 - 1; i++) {
            int sum = array[i] + carry;
            sb.append(String.valueOf(sum % 10));
            carry = sum / 10;
        }

        if (carry != 0) {
            sb.append(String.valueOf(carry));
        }

        return sb.reverse().toString();
    }
}
