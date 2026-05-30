class Solution {
    public String multiply(String num1, String num2) {
        String res = "0";
        int zero = 0;

        if ("0".equals(num1) || "0".equals(num2)) {
            return res;
        }

        for (int i = num2.length() - 1; i >= 0; i--) {
            String mul = mul(num1, num2.charAt(i), zero);
            res = add(res, mul);
            zero++;
        }

        return res;
    }

    private String mul(String num1, char c2, int zero) {
        StringBuilder sb = new StringBuilder("");
        int n2 = c2 - '0';
        int carry = 0;

        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            int m = n1 * n2 + carry;
            sb.append(String.valueOf(m % 10));
            carry = m / 10;
        }

        if (carry != 0) {
            sb.append(String.valueOf(carry));
        }

        sb = sb.reverse();
        for (int i = 0; i < zero; i++) {
            sb.append("0");
        }

        return sb.toString();
    }

    private String add(String s1, String s2) {
        StringBuilder sb = new StringBuilder("");

        int i1 = s1.length() - 1;
        int i2 = s2.length() - 1;
        int carry = 0;

        while (i1 >= 0 && i2 >= 0) {
            int sum = (s1.charAt(i1) - '0') + (s2.charAt(i2) - '0') + carry;
            sb.append(String.valueOf(sum % 10));
            carry = sum / 10;
            i1--;
            i2--;
        }

        String s = i1 >= 0 ? s1 : s2;
        for (int i = Math.max(i1, i2); i >= 0; i--) {
            int sum = (s.charAt(i) - '0') + carry;
            sb.append(String.valueOf(sum % 10));
            carry = sum / 10;
        }

        if (carry != 0) {
            sb.append(String.valueOf(carry));
        }

        return sb.reverse().toString();
    }
}
