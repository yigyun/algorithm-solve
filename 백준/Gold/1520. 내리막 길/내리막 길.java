import java.util.*;
import java.io.*;

class Main{

    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static int n, m;
    static int[][] dp, map;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[m][n];
        dp = new int[m][n];
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }


        System.out.print(dfs(0, 0));
    }

    static int dfs(int x, int y){
        if(x == m - 1 && y == n - 1){
            return 1;
        }
        
        if(dp[x][y] != -1){
            return dp[x][y];
        }
        
        dp[x][y] = 0;
        for(int dir = 0; dir < 4; dir++){
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if(isRange(nx, ny) && map[x][y] > map[nx][ny]){
                dp[x][y] += dfs(nx, ny);
            }
        }
        
        return dp[x][y];
    }
    
    static boolean isRange(int nx, int ny){
        return !(nx < 0 || nx >= m || ny < 0 || ny >= n);
    }
}