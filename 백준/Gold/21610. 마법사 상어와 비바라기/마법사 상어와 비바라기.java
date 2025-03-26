import java.util.*;
import java.io.*;

class Main {

    static int n, m;
    static int[][] map;
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] diagx = {-1, -1, 1, 1};
    static int[] diagy = {-1, 1, -1, 1};
    static Queue<int[]> cloud;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cloud = new LinkedList<>();
        cloud.add(new int[]{n - 1, 0});
        cloud.add(new int[]{n - 1, 1});
        cloud.add(new int[]{n - 2, 0});
        cloud.add(new int[]{n - 2, 1});

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            boolean[][] visited = new boolean[n][n];
            int d = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken()) % n;

            List<int[]> movedClouds = new ArrayList<>();

            int cloudSize = cloud.size();
            for (int j = 0; j < cloudSize; j++) {
                int[] cur = cloud.poll();
                int x = cur[0];
                int y = cur[1];
                x = (x + dx[d] * s + n) % n;
                y = (y + dy[d] * s + n) % n;

                movedClouds.add(new int[]{x, y});
                map[x][y]++;
                visited[x][y] = true;
            }

            boolean[][] added = new boolean[n][n];
            List<int[]> positions = new ArrayList<>();
            for (int[] pos : movedClouds) {
                int x = pos[0];
                int y = pos[1];
                if (!added[x][y]) {
                    added[x][y] = true;
                    positions.add(new int[]{x, y});
                }
            }

            for (int[] pos : positions) {
                int x = pos[0];
                int y = pos[1];
                int cnt = 0;
                for (int dir = 0; dir < 4; dir++) {
                    int nx = x + diagx[dir];
                    int ny = y + diagy[dir];
                    if (isRange(nx, ny) && map[nx][ny] > 0) {
                        cnt++;
                    }
                }
                map[x][y] += cnt;
            }

            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    if (!visited[x][y] && map[x][y] >= 2) {
                        cloud.add(new int[]{x, y});
                        map[x][y] -= 2;
                    }
                }
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result += map[i][j];
            }
        }
        System.out.println(result);
    }

    static boolean isRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}