import java.util.*;
import java.io.*;

class Main{

    static int N; // 행
    static int M; // 열
    static int[][] map;
    static boolean[][][] visited;

    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 최단경로를 계산해서 가고 이때 맵에서 우, 하 이 두개가 우선순위임.
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M][2];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                if(str.charAt(j) == '1'){
                    map[i][j] = 1;
                }
            }
        }

        int result = Integer.MAX_VALUE;
        // bfs
        // 큐에 들어가는 값 x, y, 1의 수, 거리
        Queue<int[]> que = new LinkedList<>();
        visited[0][0][0] = true;
        que.offer(new int[]{0, 0, 0, 1});

        while(!que.isEmpty()){
            int[] temp = que.poll();
            int x = temp[0]; int y = temp[1];
            int count = temp[2]; int distance = temp[3];
            if(x == N-1 && y == M-1){
                result = distance;
                break;
            }
            for(int dir = 0; dir < 4; dir++){
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if(!(nx < 0 || nx >= N || ny < 0 || ny >= M)){
                    if(map[nx][ny] == 1 && count == 0 && !visited[nx][ny][1]){
                        visited[nx][ny][1] = true;
                        que.offer(new int[]{nx, ny, 1, distance+1});
                    }else if(map[nx][ny] == 0 && !visited[nx][ny][count]){
                        visited[nx][ny][count] = true;
                        que.offer(new int[]{nx, ny, count, distance+1});
                    }
                }
            }
        }

        if(result == Integer.MAX_VALUE){
            result = -1;
        }

        System.out.println(result);
    }
}