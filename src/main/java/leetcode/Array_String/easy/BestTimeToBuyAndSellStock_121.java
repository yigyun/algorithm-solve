package leetcode.Array_String.easy;

class BestTimeToBuyAndSellStock_121 {
    public int maxProfit(int[] prices) {

        int min = prices[0];
        int max = 0;

        for(int i = 1; i < prices.length; i++){
            if(prices[i] < min){
                min = prices[i];
            } else if(prices[i] - min > max){
                max = prices[i] - min;
            }
        }

        return max;
    }
}