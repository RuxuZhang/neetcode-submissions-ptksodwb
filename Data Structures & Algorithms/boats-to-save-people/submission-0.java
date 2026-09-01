class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        Arrays.sort(people);
        int l = 0;
        int r = n - 1;
        int res = 0;

        while (r > l) {
            if (people[l] + people[r] <= limit) {
                l++;
                r--;
            } else {
                r--;
            }
            res++;
        }

        if (r == l) res++;

        return res;
    }
}