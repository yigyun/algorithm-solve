import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[][] dp = new long[N + 1][10];
        long MOD = 1000000000;

        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for(int i = 2; i <= N; i++){
            for(int j = 0; j <= 9; j++){
                if(j > 0){
                    dp[i][j] += dp[i-1][j-1];
                }

                if(j < 9){
                    dp[i][j] += dp[i-1][j+1];
                }
                dp[i][j] %= MOD;
            }
        }

        long result = 0;
        for (int i = 0; i <= 9; i++) {
            result += dp[N][i];
        }
        result %= MOD;

        System.out.println(result);
    }
}