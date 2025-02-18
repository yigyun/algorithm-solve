import java.util.*;
import java.io.*;

class Main{

    static int n, m, k;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int min = Integer.MAX_VALUE;

        map = new int[n][m];
        visited = new boolean[n][m][k + 1];

        for(int i = 0; i < n ; i++){
            String str = br.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }

        Queue<int[]> que = new LinkedList<>();
        visited[0][0][0] = true;
        que.offer(new int[]{0, 0, 1, 0, 0});
        while(!que.isEmpty()){
            int[] cur = que.poll();

            int x = cur[0], y = cur[1], dis = cur[2], count = cur[3], day = cur[4];
            if (x == n - 1 && y == m - 1) {
                min = Math.min(min, dis);
                continue;
            }

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (isRange(nx, ny)) {
                    if (map[nx][ny] == 1 && count < k && !visited[nx][ny][count + 1]) {
                        if(day % 2 == 0) {
                            visited[nx][ny][count + 1] = true;
                            que.offer(new int[]{nx, ny, dis + 1, count + 1, (day + 1) % 2});
                        }else{
                            que.offer(new int[]{x, y, dis+1, count, (day + 1) % 2});
                        }
                    } else if (map[nx][ny] == 0 && !visited[nx][ny][count]) {
                        visited[nx][ny][count] = true;
                        que.offer(new int[]{nx, ny, dis + 1, count, (day + 1) % 2});
                    }
                }
            }
        }

        System.out.print(min == Integer.MAX_VALUE ? -1 : min);
    }

    static boolean isRange(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}