import java.util.*;

// 최단 경로의 개수
class Solution {
    
    static int[] dx = new int[]{0, 1};
    static int[] dy = new int[]{1, 0};
    
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int MOD = 1000000007;
        
        int[][] dp = new int[n][m];
        
        for(int i = 0; i < puddles.length; i++){
            int x = puddles[i][1] - 1;
            int y = puddles[i][0] - 1;
            dp[x][y] = -1;
        }
        
        dp[0][0] = 1;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(dp[i][j] == -1){
                    dp[i][j] = 0;
                    continue;
                }
                
                if(i > 0){
                    dp[i][j] = (dp[i][j] + dp[i-1][j]) % MOD;
                }
                if(j > 0){
                    dp[i][j] = (dp[i][j] + dp[i][j-1]) % MOD;
                }
            }
        }
        
        return dp[n-1][m-1];
    }

}