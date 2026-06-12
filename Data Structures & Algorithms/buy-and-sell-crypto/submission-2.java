class Solution {
    public int maxProfit(int[] prices) {
        int left = 0;
        int right = left + 1;
        int maxProfit = Integer.MIN_VALUE;
        while(left < right && right < prices.length) {
            int buy = prices[left];
            int sell = prices[right];
            int profit = sell - buy;
            if(profit < 0) {
                left = right;
                right++;
            } else {
                right++;
            }
            maxProfit = Math.max(profit, maxProfit);
        }
        return maxProfit < 0 ? 0 : maxProfit;
    }
}
