import java.util.*;
import java.io.*;

/*
    R x C 격자판
    각 칸에 있는 미세먼지 양을 모니터링
    항상 1열에 공기청정기가 있다.
    크기는 두 행을 차지한다.

    1번 미세먼지 확장
    1-1 인접한 네 방향으로 확산
    1-2 인접한 방향 공기 청정기 또는 칸이 없으면 확산 x
    1-3 양은 현재 칸의 /5 이곻 소수점은 버린다
    1-4 현재 칸에 남은 미세먼지 양은 현재양 - (확산수 x 확산양)이다.

    2번 공기청정기 동작

    2개의 행인데 위쪽은 반시계방향 순환, 아래쪽은 시계방향 바람
    한칸씩 미세먼지가 이동한다.

*/

class Main{

    static int r,c,t;
    static int[][] map;
    static int ux, uy; // 공기청정기 위쪽 바람
    static int dx, dy; // 공기청정기 아래쪽 바람

    static int[] udx = {0, -1, 0, 1}, udy = {1, 0, -1, 0}; // 반시계
    static int[] ddx = {0, 1, 0, -1}, ddy = {1, 0, -1, 0}; // 시계

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        map = new int[r][c];
        boolean check = false;
        for(int i = 0; i < r; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < c; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(!check && map[i][j] == -1){
                    check = true;
                    ux = i; uy = j;
                    dx = i + 1; dy = j;
                }
            }
        }

        for(int tc = 0; tc < t; tc++){
            // spread
            spread();

            // move
            move();
        }

        int answer = 0;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(map[i][j] > 0) answer += map[i][j];
            }
        }

        System.out.print(answer);
    }

    static void move(){
        upper();
        lower();
    }

    static void upper(){
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{ux, uy, 0, 0}); // 좌표 x, y, dir, 값;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            int nx = cur[0] + udx[cur[2]];
            int ny = cur[1] + udy[cur[2]];

            if(isRange(nx, ny) && map[nx][ny] != -1){
                q.offer(new int[]{nx, ny, cur[2], map[nx][ny]});
                map[nx][ny] = cur[3];
            }else{
                if(!isRange(nx, ny)){
                    q.offer(new int[]{cur[0], cur[1], (cur[2] + 1) % 4, cur[3]});
                }else{
                    break;
                }
            }
        }
    }

    static void lower(){
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{dx, dy, 0, 0}); // 좌표 x, y, dir, 값;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            int nx = cur[0] + ddx[cur[2]];
            int ny = cur[1] + ddy[cur[2]];

            if(isRange(nx, ny) && map[nx][ny] != -1){
                q.offer(new int[]{nx, ny, cur[2], map[nx][ny]});
                map[nx][ny] = cur[3];
            }else{
                if(!isRange(nx, ny)){
                    q.offer(new int[]{cur[0], cur[1], (cur[2] + 1) % 4, cur[3]});
                }else{
                    break;
                }
            }
        }
    }

    static void spread(){
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(map[i][j] != 0 && map[i][j] != -1){
                    q.offer(new int[]{i, j, map[i][j]});
                }
            }
        }

        while(!q.isEmpty()){
            int[] cur = q.poll();

            int count = 0;

            for(int dir = 0; dir < 4; dir++){
                int nx = cur[0] + ddx[dir];
                int ny = cur[1] + ddy[dir];

                if(isRange(nx, ny) && map[nx][ny] != -1){
                    count++;
                    map[nx][ny] += (cur[2] / 5);
                }
            }

            map[cur[0]][cur[1]] -= (count * (cur[2] / 5));
        }
    }

    static boolean isRange(int nx, int ny){
        return !(nx < 0 || nx >= r || ny < 0 || ny >= c);
    }
}