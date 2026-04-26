class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE,
            maxProfit = 0;

        for (int price : prices) {
            if (minPrice > price) {
                minPrice = price;
            } else {
                int profit = price - minPrice;
                maxProfit = Math.max(maxProfit, profit);
            }
        }

        return maxProfit;
    }
}