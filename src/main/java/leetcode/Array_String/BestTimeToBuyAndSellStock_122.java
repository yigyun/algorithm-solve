package leetcode.Array_String;

class BestTimeToBuyAndSellStock_122 {
    public int maxProfit(int[] prices) {

        int max = 0;
        int min = prices[0];
        int profit = 0;

        for(int i = 1; i < prices.length; i++){
            if(prices[i] < min){
                min = prices[i];
            } else if(prices[i] - min > max){
                max = prices[i] - min;
                if(i < prices.length-1 && prices[i] >= prices[i+1]){
                    min = prices[i+1];
                    profit += max;
                    max = 0;
                } else if(i == prices.length-1){
                    profit += max;
                }
            }
        }

        return profit;
    }
}