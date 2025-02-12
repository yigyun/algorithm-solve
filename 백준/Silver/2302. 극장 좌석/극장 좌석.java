import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];
        dp[0] = -1;
        int result = 1;

        for(int i = 0; i < m; i++){
            int num = Integer.parseInt(br.readLine());
            dp[num] = -1;
        }

        for(int i = 1; i <= n; i++){
            if(dp[i] == -1) {
                continue;
            }

            if(dp[i-1] == -1){
                dp[i] = 1;
            }else if(dp[i-1] == 1){
                dp[i] = 2;
            }else{
                dp[i] = dp[i-1] + dp[i-2];
            }
        }

        for(int i = 1; i <= n; i++){
            if(dp[i] == -1 && dp[i-1] != -1){
                result *= dp[i-1];
            }else if(i == n && dp[i] != -1){
                result *= dp[i];
            }

        }

        System.out.print(result);

    }
}