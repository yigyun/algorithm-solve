import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];
        for(int i = 0; i < n; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[k+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i = 0; i < n; i++){
            int coin = coins[i];
            for(int j = coin; j <= k; j++){
                if(dp[j - coin] == Integer.MAX_VALUE) continue;
                dp[j] = Math.min(dp[j] , dp[j - coin] + 1);
            }
        }

        System.out.print(dp[k] == Integer.MAX_VALUE ? -1 : dp[k]);
    }
}