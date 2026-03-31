class Solution {
    Map<String, Integer> dp = new HashMap<>();

    public int maxProfit(int[] prices) {
        return dfs(0, true, prices);
    }

    private int dfs(int i, boolean buying, int[] prices) {
        if (i >= prices.length) {
            return 0;
        }

        String key = String.valueOf(i) + String.valueOf(buying);
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        if (buying) {
            int buy = dfs(i + 1, false, prices) - prices[i];
            int cooldown = dfs(i + 1, true, prices);
            dp.put(key, Math.max(buy, cooldown));
        } else {
            int sell = dfs(i + 2, true, prices) + prices[i];
            int cooldown = dfs(i + 1, false, prices);
            dp.put(key, Math.max(sell, cooldown));
        }

        return dp.get(key);
    }
}
