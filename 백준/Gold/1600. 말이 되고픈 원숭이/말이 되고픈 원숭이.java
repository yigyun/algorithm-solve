import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.*;

class Main{

    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static int[] dhx = {-1, -2, -1, -2, 1, 2, 1, 2}, dhy = {-2, -1, 2, 1, -2, -1, 2, 1};

    static int k, w, h;
    static int[][] map;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[h][w];
        for(int i = 0; i < h; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < w; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 0,0 시작하고 계속 이동해서 도착하면 끝
        boolean[][][] visited = new boolean[h][w][k+1];
        Queue<int[]> q = new LinkedList<>();
        // x, y, 거리, k 몇번인지
        q.offer(new int[]{0, 0, 0, 0});
        int min = Integer.MAX_VALUE;
        visited[0][0][0] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            if(x == h-1 && y == w-1){
                min = Math.min(min, cur[2]);
                continue;
            }
            
            if(cur[3] < k) {
                for (int dir = 0; dir < 8; dir++) {
                    int nx = x + dhx[dir];
                    int ny = y + dhy[dir];

                    if (isRange(nx, ny) && !visited[nx][ny][cur[3] + 1] && map[nx][ny] != 1) {
                        visited[nx][ny][cur[3] + 1] = true;
                        q.offer(new int[]{nx, ny, cur[2] + 1, cur[3] + 1});
                    }
                }
            }

            for(int dir = 0; dir < 4; dir++){
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if(isRange(nx, ny) && !visited[nx][ny][cur[3]] && map[nx][ny] != 1){
                    visited[nx][ny][cur[3]] = true;
                    q.offer(new int[]{nx, ny, cur[2] + 1, cur[3]});
                }
            }
        }

        System.out.print(min == Integer.MAX_VALUE ? -1 : min);
    }

    static boolean isRange(int nx, int ny){
        return !(nx < 0 || nx >= h || ny < 0 || ny >= w);
    }
}