/**

xyxxyzb

x, [0, 3]
y, [1, 4]
z, [5, 5]
b, [6, 6]


*/

class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        Map<Character, Integer> lastIndex = new HashMap<>();

        for (int i = 0; i < n; i++) {
            lastIndex.put(s.charAt(i), i);
        }

        int size = 0, end = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            size++;
            end = Math.max(end, lastIndex.get(s.charAt(i)));

            if (i == end) {
                res.add(size);
                size = 0;
            }
        }

        return res;
    }
}
