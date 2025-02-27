import java.util.*;
import java.io.*;

/*
    3차원 미로 탐색
    5 x 5 x 5 크기임.
    하얀 칸은 이동 가능 1, 검은 칸은 벽은 0
    판의 회전 시계 방향, 반시계 방향 가능, 뒤집기 불가능
    회전 후 판 5개가 쌓임, 판을 쌓는 순서는 자유

    4방향을 입구로 두면 어차피 회전에 대한 값을 구별할 수 있음.
    기존에 중복을 허용해서 5개 까지 선택하면서 모양을 결정하고 그 모양에서 이동가능한
    입구 및 출구를 찾고 여기서부터 bfs 하면 찾을 수 있음, 최단 경로 찾아서 min 비교
    기본 방향은 6가지 차원 2개 상하좌우 4개

*/

class Main{

    // 좌표, 회전, 좌표, 좌표
    static int[][][][] map;
    static final int SIZE = 5;
    static int min;
    static int[][] visited;

    // 방향
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};


    // 꼭짓점 목록
    static int[][] sps = {{4, 0, 0}, {4, 0, 4}, {4, 4, 0}, {4, 4, 4}};
    static int[][] eps = {{0, 4, 4}, {0, 4, 0}, {0, 0, 4}, {0, 0, 0}};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new int[SIZE][4][SIZE][SIZE];
        min = Integer.MAX_VALUE;

        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < SIZE; k++){
                    map[i][0][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        // 회전만들기
        for(int i = 0; i < SIZE; i++){
            for(int j = 1; j < 4; j++){
                map[i][j] = rotate(map[i][j-1]);
            }
        }

        // 5개의 판에서 회전의 경우의 수
        visited = new int[SIZE][2]; // 0은 어떤 판인지, 1은 회전
        for(int i = 0; i < SIZE; i++){
            Arrays.fill(visited[i], -1);
        }
        bfs(0, 0);

        System.out.print(min == Integer.MAX_VALUE ? -1 : min);
    }

    static void bfs(int idx, int count){
        if(count == SIZE){
            // 여기서 최단경로 찾기
            int[][][] temp = new int[SIZE][SIZE][SIZE];

            for(int i = 0; i < SIZE; i++){
                int layer = visited[i][0];
                int gak = visited[i][1];
                temp[i] = map[layer][gak];
            }

            for(int i = 0; i < 4; i++){
                int[] sp = sps[i];
                int[] ep = eps[i];
                if(temp[sp[0]][sp[1]][sp[2]] == 0 || temp[ep[0]][ep[1]][ep[2]] == 0) continue;
                boolean[][][] visit = new boolean[SIZE][SIZE][SIZE];
                Queue<int[]> q = new LinkedList<>();
                q.offer(new int[]{sp[0], sp[1], sp[2], 0});
                visit[sp[0]][sp[1]][sp[2]] = true;

                while(!q.isEmpty()){
                    int[] cur = q.poll();
                    int x = cur[0], y = cur[1], z = cur[2];

                    if(x == ep[0] && y == ep[1] && z == ep[2]){
                        min = Math.min(min, cur[3]);
                        break;
                    }

                    for(int dir = 0; dir < 6; dir++){
                        int nx = x + dx[dir];
                        int ny = y + dy[dir];
                        int nz = z + dz[dir];
                        if(isRange(nx, ny, nz) && !visit[nx][ny][nz] && temp[nx][ny][nz] != 0){
                            visit[nx][ny][nz] = true;
                            q.offer(new int[]{nx, ny, nz, cur[3] + 1});
                        }
                    }
                }
            }

            return;
        }

        for(int i = 0; i < SIZE; i++){
            if(visited[i][0] == -1) {
                visited[i][0] = idx;
                for (int j = 0; j < 4; j++) {
                    visited[i][1] = j;
                    bfs(idx + 1, count + 1);
                    visited[i][1] = -1;
                }
                visited[i][0] = -1;
            }
        }
    }

    static int[][] rotate(int[][] cmap){
        int[][] temp = new int[SIZE][SIZE];
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                temp[i][j] = cmap[SIZE - 1- j][i];
            }
        }

        return temp;
    }

    static boolean isRange(int nx, int ny, int nz){
        return !(nx < 0 || nx >= SIZE || ny < 0 || ny >= SIZE || nz < 0 || nz >= SIZE);
    }
}