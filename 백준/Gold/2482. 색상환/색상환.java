import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int[][] dp = new int[n+1][k+1];

        for(int i = 0; i <= n; i++){
            dp[i][1] = i;
            dp[i][0] = 1;
        }

        for(int i = 2; i <= n; i++){
            for(int j = 2; j <= k; j++){
                dp[i][j] = (dp[i-1][j] + dp[i-2][j-1]) % 1000000003;
            }
        }
        int result = (dp[n - 1][k] + dp[n - 3][k - 1]) % 1000000003;
        System.out.print(result);
    }
}