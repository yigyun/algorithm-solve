import java.util.*;
import java.io.*;

class Main{

    static int[] dx0 = {0, -1, -1}, dy0 = {-2, -2, -1}, dx1 = {0, 1, 1}, dy1 = {-2, -2, -1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int time = 0; time < t; time++){
            int n = Integer.parseInt(br.readLine());
            int[][] nums = new int[2][n+1];
            int[][] dp = new int[2][n+1];
            int max = 0;

            for(int i = 0; i < 2; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 1; j <= n; j++){
                    nums[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][1] = nums[0][1];
            dp[1][1] = nums[1][1];

            for(int i = 2; i <= n; i++){
                dp[0][i] = Math.max(dp[1][i-2], dp[1][i-1]) + nums[0][i];
                dp[1][i] = Math.max(dp[0][i-2], dp[0][i-1]) + nums[1][i];
            }

            max = Math.max(dp[0][n], dp[1][n]);

            sb.append(max).append('\n');
        }

        System.out.print(sb);
    }
}
