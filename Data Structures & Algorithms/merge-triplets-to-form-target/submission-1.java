class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        Set<Integer> match = new HashSet<>();
        int n = target.length;

        for (int[] tri : triplets) {
            if (tri[0] > target[0] || tri[1] > target[1] || tri[2] > target[2]) {
                continue;
            }
            for (int i = 0; i < 3; i++) {
                if (tri[i] == target[i]) {
                    match.add(i);
                }
            }
        }

        return match.size() == 3;
    }
}
