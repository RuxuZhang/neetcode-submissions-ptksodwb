class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> orderMap = new HashMap<>();
        char[] orders = order.toCharArray();
        for (int i = 0; i < orders.length; i++) {
            orderMap.put(orders[i], i);
        }

        Comparator<String> comparator = (w1, w2) -> {
            int min = Math.min(w1.length(), w2.length());
            for (int i = 0; i < min; i++) {
                if (w1.charAt(i) != w2.charAt(i)) {
                    return orderMap.get(w1.charAt(i)) - orderMap.get(w2.charAt(i));
                }
            }
            return w1.length() - w2.length();
        };

        String[] sortedWords = words.clone();
        Arrays.sort(sortedWords, comparator);

        for (int i = 0; i < words.length; i++) {
            if (!sortedWords[i].equals(words[i])) {
                return false;
            }
        }

        return true;
    }
}