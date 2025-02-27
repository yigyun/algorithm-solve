import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int answer = 0;
        int len = info.length;
        
        boolean[][][] dp = new boolean[len][n][m];
        if(info[0][0] < n) dp[0][info[0][0]][0] = true;
        if(info[0][1] < m) dp[0][0][info[0][1]] = true;
        
        for(int i = 1; i < len; i++){
            int a = info[i][0];
            int b = info[i][1];
            for(int j = 0; j < n; j++){
                for(int k = 0; k < m; k++){
                    if(dp[i-1][j][k]){
                        if(j + a < n){
                            dp[i][j+a][k] = true;
                        }
                        
                        if(k + b < m){
                            dp[i][j][k+b] = true;
                        }
                    }
                }
            }
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(dp[len-1][i][j] == true){
                    return i;
                }
            }
        }
        
        return -1;
    }
}