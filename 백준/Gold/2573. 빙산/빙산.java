import java.util.*;
import java.io.*;

class Main{

    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    static class Ice{
        int x; int y;
        Ice(int x, int y){
            this.x = x; this.y = y;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        Set<Ice> iceburg = new HashSet<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] != 0) iceburg.add(new Ice(i, j));
            }
        }
        int time = 0;

        while(true) {
            time++;
            Set<Ice> newIceburg = new HashSet<>();
            int[][] newMap = new int[N][M];

            for (Ice ice : iceburg) {
                int seaCount = 0;
                for (int dir = 0; dir < 4; dir++) {
                    int nx = ice.x + dx[dir];
                    int ny = ice.y + dy[dir];
                    if (!(nx < 0 || nx >= N || ny < 0 || ny >= M) && map[nx][ny] == 0) {
                        seaCount++;
                    }
                }
                newMap[ice.x][ice.y] = Math.max(0, map[ice.x][ice.y] - seaCount);
                if (newMap[ice.x][ice.y] > 0) {
                    newIceburg.add(new Ice(ice.x, ice.y));
                }
            }

            if (newIceburg.isEmpty()) {
                System.out.println(0);
                return;
            }

            map = newMap;
            iceburg = newIceburg;

            if (isSeparated(iceburg)) {
                System.out.println(time);
                return;
            }
        }
    }
    static boolean isSeparated(Set<Ice> iceburg) {
        visited = new boolean[N][M];
        Iterator<Ice> it = iceburg.iterator();
        Ice start = it.next();
        Queue<Ice> queue = new LinkedList<>();
        queue.add(start);
        visited[start.x][start.y] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            Ice ice = queue.poll();
            count++;
            for (int dir = 0; dir < 4; dir++) {
                int nx = ice.x + dx[dir];
                int ny = ice.y + dy[dir];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && map[nx][ny] > 0) {
                    visited[nx][ny] = true;
                    queue.add(new Ice(nx, ny));
                }
            }
        }

        return count != iceburg.size();
    }
}

