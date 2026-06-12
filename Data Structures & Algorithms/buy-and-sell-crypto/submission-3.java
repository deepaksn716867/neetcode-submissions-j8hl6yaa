class Solution {
    public int maxProfit(int[] prices) {
        int left = 0;
        int right = left + 1;
        int maxProfit = 0;
        while(left < right && right < prices.length) {
            int buy = prices[left];
            int sell = prices[right];
            int profit = sell - buy;
            if(profit < 0) {
                left = right;
            } else {
                maxProfit = Math.max(profit, maxProfit);
            }
            right++;
            
        }
        return maxProfit;
    }
}
