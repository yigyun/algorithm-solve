import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 홀수는 아예 구현이 안되네
        int n = Integer.parseInt(br.readLine());

        if(n % 2 != 0) {
            System.out.print(0);
            return;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[2] = 3;

        for(int i = 4; i <= n; i+=2){
            dp[i] = dp[i-2] * 3;
            for(int j = i - 4; j >= 0; j -= 2){
                dp[i] += dp[j] * 2;
            }
        }

        System.out.print(dp[n]);
    }
}