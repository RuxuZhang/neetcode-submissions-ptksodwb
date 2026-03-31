class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] price = new int[n];
        Arrays.fill(price, -1);
        price[src] = 0;

        for (int i = 0; i <= k; i++) {
            int[] curPrice = price.clone();

            for (int[] flight : flights) {
                int start = flight[0];
                int end = flight[1];
                int p = flight[2];

                if (price[start] != -1) {
                    curPrice[end] = curPrice[end] == -1 ? 
                    price[start] + p : 
                    Math.min(price[start] + p, curPrice[end]);
                }
            }

            price = curPrice;
        }

        return price[dst];
    }
}
