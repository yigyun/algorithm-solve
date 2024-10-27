import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[triangle.length][];
        for(int i = 0; i < triangle.length; i++){
            dp[i] = Arrays.copyOf(triangle[i], triangle[i].length);
        }
        
        int max = 0;
        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j < dp[i].length; j++){
                if(j < dp[i-1].length)
                    dp[i][j] = Math.max(dp[i][j], triangle[i-1][j] + triangle[i][j]);
                if(j - 1 >= 0)
                    dp[i][j] = Math.max(dp[i][j], triangle[i-1][j-1] + triangle[i][j]);
            }
            for(int j = 0; j < dp[i].length; j++){
                triangle[i][j] = dp[i][j];
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}