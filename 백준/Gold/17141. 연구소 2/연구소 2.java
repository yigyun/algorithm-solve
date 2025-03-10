import java.util.*;
import java.io.*;

class Main{

    /*
        바이러스가 최대 10개니까
        바이러스 List에 좌표담고 m개 만큼 선택한걸로 맵돌면끝.
    */
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    static int n, m;
    static int[][] map; // 입력받은 맵 1은 벽 0은 빈칸 2는 바이러스 가능한 위치
    static int min; // 결과(최소 시간)
    static List<int[]> virus;
    static boolean[] choice;
    static int total;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        virus = new ArrayList<>();
        min = Integer.MAX_VALUE;
        total = 0;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    virus.add(new int[]{i, j});
                }
                if(map[i][j] != 1) total++;
            }
        }

        choice = new boolean[virus.size()];

        find(0, 0);

        System.out.print(min == Integer.MAX_VALUE ? -1 : min);
    }

    static void find(int idx, int c){
        if(c == m){
            Queue<int[]> q = new LinkedList<>();
            boolean[][] visited = new boolean[n][n];
            int sec = 0;
            int cnt = 0;

            for(int i = 0; i < virus.size(); i++){
                if(choice[i]){
                    int[] cur = virus.get(i);
                    q.offer(new int[]{cur[0], cur[1], 0});
                    visited[cur[0]][cur[1]] = true;
                }
            }

            while(!q.isEmpty()){
                int[] cur = q.poll();
                cnt++;
                sec = Math.max(sec, cur[2]);
                for(int dir = 0; dir < 4; dir++){
                    int nx = cur[0] + dx[dir];
                    int ny = cur[1] + dy[dir];
                    if(isRange(nx, ny) && !visited[nx][ny] && map[nx][ny] != 1){
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny, cur[2] + 1});
                    }
                }
            }

            if(cnt == total)
                min = Math.min(min, sec);

            return;
        }

        for(int i = idx; i < virus.size(); i++){
            if(!choice[i]){
                choice[i] = true;
                find(i + 1, c + 1);
                choice[i] = false;
            }
        }
    }

    static boolean isRange(int nx, int ny){
        return !(nx < 0 || nx >= n || ny < 0 || ny >= n);
    }
}