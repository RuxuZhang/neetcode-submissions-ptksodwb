class Solution {

    Map<Character, Character> map = Map.of(
        '(', ')',
        '[', ']',
        '{', '}'
    );

    public boolean isValid(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (stack.isEmpty()) {
                return false;
            } else {
                char p = stack.pop();
                if (map.get(p) != c) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
}
