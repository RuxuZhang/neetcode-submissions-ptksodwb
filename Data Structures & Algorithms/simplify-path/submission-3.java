class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] words = path.split("/");
        for (String word : words) {
            if (word == null || word.length() == 0 || ".".equals(word)) {
                continue;
            }

            if ("..".equals(word)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                continue;
            }

            stack.push(word);
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.insert(0, stack.pop());
            sb.insert(0, "/");
        }
        String res = sb.length() == 0 ? "/" : sb.toString();
        return res;
    }
}