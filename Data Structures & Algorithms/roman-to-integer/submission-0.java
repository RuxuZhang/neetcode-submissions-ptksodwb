class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
        );

        Map<Character, Set<Character>> special = Map.of(
            'I', Set.of('V', 'X'),
            'X', Set.of('L', 'C'),
            'C', Set.of('D', 'M')
        );

        int n = s.length();
        int res = 0;
        int i = n - 1;

        while (i >= 0) {
            char c = s.charAt(i);
            if (i < n - 1 && special.containsKey(c) && special.get(c).contains(s.charAt(i + 1))) {
                res -= map.get(c);
            } else {
                res += map.get(c);
            }

            System.out.println(res);

            i--;
        }

        return res;
    }
}