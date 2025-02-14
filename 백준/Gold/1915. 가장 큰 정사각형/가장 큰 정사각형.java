import java.util.*;
import java.io.*;

class Main{
    // 하, 우, 우하
    static int[] dx = {1, 0, 1}, dy = {0, 1, 1};
    static int n, m, max;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 입력
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        max = 0;

        int[][] map = new int[n][m];

        for(int i = 0; i < n; i++){
            String str = (br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }

        // dp
        int[][] dp = new int[n][m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 0) continue;
                if(i == 0 || j == 0) dp[i][j] = 1;
                else {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                }
                max = Math.max(max, dp[i][j]);
            }
        }

        System.out.print(max * max);
    }

    static boolean isRange(int nx, int ny){
        return !(nx < 0 || nx >= n || ny < 0 || ny >= m);
    }
}