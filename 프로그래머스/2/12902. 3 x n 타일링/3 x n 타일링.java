class Solution {
    public int solution(int n) {
        int answer = 0;
        int MOD = 1000000007;
        long[] dp = new long[n+1];
        dp[0] = 1;
        dp[2] = 3;
        
        for(int i = 4; i <= n; i+=2){
            dp[i] = (dp[i-2] * 3) % MOD;
            
            for(int j = 4; j <= i; j += 2){
                dp[i] = (dp[i] + dp[i - j] * 2) % MOD;
            }
        }
        
        return (int)dp[n];
    }
}