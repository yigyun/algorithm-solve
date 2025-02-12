import java.util.*;
import java.io.*;

class Main{

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n+1][10];

        for(int i = 0; i < 10; i++){
            dp[1][i] = 1;
        }

        for(int i = 2; i <= n; i++){
            dp[i][9] = 1;
            for(int j = 8; j >= 0; j--){
                dp[i][j] = (dp[i][j + 1] + dp[i-1][j]) % 10007;
            }
        }

        int sum = 0;
        for(int i = 0; i < 10; i++){
            sum = (sum + dp[n][i]) % 10007;
        }

        System.out.println(sum);
    }
}