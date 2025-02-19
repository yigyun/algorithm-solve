import java.util.*;
import java.io.*;

class Main{

    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static List<int[]>[][] switchs;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n + 1][n + 1];
        visited = new boolean[n + 1][n + 1];
        switchs = new ArrayList[n + 1][n + 1];
        int count = 0;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                switchs[i][j] = new ArrayList<>();
            }
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            switchs[x][y].add(new int[]{a, b});
        }

        map[1][1] = 1;
        visited[1][1] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{1, 1});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            // 스위치 켜기
            for(int[] on : switchs[x][y]){
                if(map[on[0]][on[1]] == 0){
                    map[on[0]][on[1]] = 1;

                    for(int dir = 0; dir < 4; dir++){
                        int nx = on[0] + dx[dir];
                        int ny = on[1] + dy[dir];

                        if(isRange(nx, ny) && visited[nx][ny]){
                            visited[on[0]][on[1]] = true;
                            q.offer(new int[]{on[0], on[1]});
                        }
                    }
                }
            }

            for(int dir = 0; dir < 4; dir++){
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if(isRange(nx, ny) && !visited[nx][ny] && map[nx][ny] == 1){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(map[i][j] == 1) count++;
            }
        }

        System.out.print(count);
    }

    static boolean isRange(int x, int y){
        return x >= 1 && x <= n && y >= 1 && y <= n;
    }
}