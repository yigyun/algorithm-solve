import java.util.*;
import java.io.*;

class Main{

    static int N;
    static int M;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    static int[][] map;
    static boolean[][] visited;

    static int max = Integer.MIN_VALUE;
    static int length = Integer.MIN_VALUE;

    // 알맞은 비밀번호를 입력하면 탈출한다.
    /**
     1. 다른방으로 이동할때는 항상 두 방 사이의 최단 경로로 이동한다.
     2. 1번을 만족하는 경로 중 가장 긴 경로의 시작 방과 끝 방에 적힌 숫자 합.

     위 조건 만족 여러개면 시작방과 끝방에 적힌 숫자의 합이 가장 큰 값이 비밀번호
     **/

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxSum = 0;
        int maxDistance = 0;
        boolean foundPath = false;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] != 0){
                    int[][] dis = bfs(i, j);

                    for(int a = 0; a < N; a++){
                        for(int b = 0; b < M; b++){
                            if(dis[a][b] > 0){
                                foundPath = true;
                                int pathLength = dis[a][b] - 1;
                                int pathSum = map[i][j] + map[a][b];

                                if(pathLength > maxDistance){
                                    maxSum = pathSum;
                                    maxDistance = pathLength;
                                }else if(pathLength == maxDistance){
                                    maxSum = Math.max(maxSum, pathSum);
                                }
                            }
                        }
                    }
                }
            }
        }

        if(!foundPath){
            System.out.print(0);
        }else{
            System.out.print(maxSum);
        }

    }

    static int[][] bfs(int x, int y){
        int[][] dist = new int[N][M];
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{x, y});
        dist[x][y] = 1;

        while(!que.isEmpty()){
            int[] cur = que.poll();
            for(int dir = 0; dir < 4; dir++){
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                if(isRange(nx, ny) && map[nx][ny] != 0 && dist[nx][ny] == 0){
                    dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                    que.offer(new int[]{nx, ny});
                }
            }
        }

        return dist;
    }

    static boolean isRange(int nx, int ny){
        return !(nx < 0 || nx >= N || ny < 0 || ny >= M);
    }
}