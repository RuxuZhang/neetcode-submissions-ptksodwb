class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            if (Character.isDigit(tokens[i].charAt(0)) || (tokens[i].charAt(0) == '-' && tokens[i].length() > 1)) {
                stack.push(Integer.valueOf(tokens[i]));
            } else {
                String operator = tokens[i];
                int b = stack.pop();
                int f = stack.pop();
                int res = b = switch (operator) {
                    case "+" -> f + b;
                    case "-" -> f - b;
                    case "*" -> f * b;
                    case "/" -> f / b;
                    default -> 1;
                };
                stack.push(res);
            }
        }

        return stack.peek();
    }
}
