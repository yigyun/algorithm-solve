import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[] nums = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n+1][n+1];

        for(int i = 1; i <= n; i++){
            dp[i][i] = 1;
        }

        for (int length = 2; length <= n; length++) {
            for (int i = 1; i <= n - length + 1; i++) {
                int j = i + length - 1;
                if (nums[i] == nums[j]) {
                    if (length == 2) {
                        dp[i][j] = 1;
                    } else if (dp[i + 1][j - 1] == 1) {
                        dp[i][j] = 1;
                    }
                }
            }
        }

        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(dp[x][y] == 1) sb.append(1);
            else sb.append(0);
            sb.append('\n');
        }

        System.out.print(sb);
    }
}