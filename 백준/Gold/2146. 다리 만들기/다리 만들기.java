import java.util.*;
import java.io.*;

class Main{

    static int n;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;
    static List<Team> teams;
    static int min;

    static class Team{
        List<int[]> lists;
        Team(int x, int y){
            lists = new ArrayList<>();
            lists.add(new int[]{x, y});
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new boolean[n][n];
        min = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 그룹화하기
        int team = 1;
        teams = new ArrayList<>();
        teams.add(new Team(0, 0));
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] != 0 && !visited[i][j]){
                    bfs(i, j, team++);
                }
            }
        }
        team -= 1;
        // 나랑 다른 번호까지의 거리 찾기
        for(int t = team; t >= 1; t--){
            find(t);
        }

        System.out.println(min);
    }

    static void find(int t){
        Queue<int[]> q = new LinkedList<>();
        boolean[][] temp = new boolean[n][n];

        for(int[] cur : teams.get(t).lists){
            q.offer(new int[]{cur[0], cur[1], 0});
            temp[cur[0]][cur[1]] = true;
        }

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int dir = 0; dir < 4; dir++){
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                if(isRange(nx, ny) && !temp[nx][ny] && map[nx][ny] != t){
                    if(map[nx][ny] == 0){
                        temp[nx][ny] = true;
                        q.offer(new int[]{nx, ny, cur[2] + 1});
                    }else{
                        min = Math.min(min, cur[2]);
                    }
                }
            }
        }
    }

    static void bfs(int x, int y, int team){
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{x, y});
        visited[x][y] = true;
        map[x][y] = team;
        teams.add(new Team(x, y));

        while(!que.isEmpty()){
            int[] cur = que.poll();

            for(int dir = 0; dir < 4; dir++){
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                if(isRange(nx, ny) && !visited[nx][ny] && map[nx][ny] == 1){
                    visited[nx][ny] = true;
                    map[nx][ny] = team;
                    que.offer(new int[]{nx, ny});
                    teams.get(team).lists.add(new int[]{nx, ny});
                }
            }
        }
    }

    static boolean isRange(int nx, int ny){
        return !(nx < 0 || nx >= n || ny < 0 || ny >= n);
    }
}