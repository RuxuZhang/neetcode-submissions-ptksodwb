// Merge Sort
class Solution {
    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    private void sort(int[] nums, int l, int r) {
        if (l >= r) return;

        int m = l + (r - l) / 2;
        sort(nums, l, m);
        sort(nums, m + 1, r);
        merge(nums, l, m, r);
    }

    private void merge(int[] nums, int l, int m, int r) {
        List<Integer> tmp = new ArrayList<>();

        int i = l;
        int j = m + 1;
        while (i <= m && j <= r) {
            if (nums[i] <= nums[j]) {
                tmp.add(nums[i]);
                i++;
            } else {
                tmp.add(nums[j]);
                j++;
            }
        }

        while (i <= m) {
            tmp.add(nums[i]);
            i++;
        }

        while (j <= r) {
            tmp.add(nums[j]);
            j++;
        }

        i = l;
        for (int t : tmp) {
            nums[i] = t;
            i++;
        }
    }
}