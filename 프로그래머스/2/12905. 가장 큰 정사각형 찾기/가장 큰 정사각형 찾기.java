import java.util.*;

class Solution{
    
    static int n;
    static int m;
    
    public int solution(int [][]board)
    {
        int answer = 0;
        n = board.length;
        m = board[0].length;
        int[][] dp = new int[n][m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 1){
                    if(i == 0 || j == 0){
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                    }
                    answer = Math.max(dp[i][j], answer);
                }
            }
        }

        return answer * answer;
    }

}