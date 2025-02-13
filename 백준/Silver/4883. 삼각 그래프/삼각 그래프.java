import java.util.*;
import java.io.*;

class Main{

    //좌하, 하, 우하, 우

    static int[] dx = {1, 1, 1, 0}, dy = {-1, 0, 1, 1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int k = 1;
        while(n != 0){
            int[][] map = new int[n][3];
            for(int i = 0; i < n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 3; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int[][] dp = new int[n][3];
            for(int i = 0; i < n; i++){
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }

            dp[0][1] = map[0][1];

            for(int i = 0; i < n; i++){
                for(int j = 0; j < 3; j++){
                    if(i == 0 && j == 0) continue;
                    for(int dir = 0; dir < 4; dir++){
                        int nx = i + dx[dir];
                        int ny = j + dy[dir];
                        if(isRange(n, nx, ny)){
                            dp[nx][ny] = Math.min(dp[nx][ny], dp[i][j] + map[nx][ny]);
                        }
                    }
                }
            }

            sb.append(k).append(". ").append(dp[n-1][1]).append('\n');

            // 끝나고 0이 입력으로 올 때까지
            k++;
            n = Integer.parseInt(br.readLine());
        }

        System.out.print(sb);
    }

    static boolean isRange(int n, int nx, int ny){
        return !(nx < 0 || nx >= n || ny < 0 || ny >= 3);
    }
}