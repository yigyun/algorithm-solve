import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int t = 0; t < tc; t++){
            int n = Integer.parseInt(br.readLine());
            int[] nums = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(st.nextToken());
            }

            int m = Integer.parseInt(br.readLine());
            int[] dp = new int[10001];

            for(int i = 0; i < n; i++){
                int coin = nums[i];
                dp[coin] += 1;
                for(int j = coin + 1; j <= m; j++){
                    dp[j] += dp[j - coin];
                }
            }

            sb.append(dp[m]).append('\n');
        }

        System.out.print(sb);
    }
}