class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            int[] array = new int[26];
            char[] chars = str.toCharArray();
            for (char c : chars) {
                array[c - 'a']++;
            }
            String key = Arrays.toString(array);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
