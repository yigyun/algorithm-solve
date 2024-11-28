class Solution {
    
    public int solution(int sticker[]) {
        int n = sticker.length;
        if(n == 1) return sticker[0];
        
        int[] dp = new int[n];
        dp[0] = sticker[0];
        dp[1] = Math.max(sticker[0], sticker[1]);
        for(int i = 2; i < n; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + sticker[i]);
        }
        int case1 = dp[n-2];
        
        
        dp = new int[n];
        dp[1] = sticker[1];
        for(int i = 2; i < n; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + sticker[i]);
        }
        int case2 = dp[n - 1];
        
        return case1 > case2 ? case1 : case2;
    }

}