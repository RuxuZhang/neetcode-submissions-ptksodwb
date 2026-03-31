class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            int h = heights[i];
            int l = i;
            while (l - 1 >= 0 && heights[l - 1] >= h) {
                l--;
            }
            int r = i;
            while (r + 1 < heights.length && heights[r + 1] >= h) {
                r++;
            }
            int area = (r - l + 1) * h;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
