class Solution {
    public int maxProfit(int[] prices) {
        // in this prb we can buy and sell the stock multiple time but the case is that we should hold the one condition either buy or sell

        int max_profit = 0;
        for(int i =1;i<prices.length;i++){
            if(prices[i] > prices[i-1]) max_profit+= prices[i] - prices[i-1];
        }
        return max_profit; 
    }
}