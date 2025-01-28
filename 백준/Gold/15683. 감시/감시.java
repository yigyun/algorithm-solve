import java.util.*;
import java.io.*;

class Main{

    static int n;
    static int m;
    static int result;

    static int[] dx = new int[]{-1, 1, 0, 0}, dy = new int[]{0, 0, -1, 1};

    static List<int[]>[] dirs;

    // cctv는 벽을 통과 못하고, cctv 끼리는 통과가 가능하다.
    // 90도 회전이 가능하다.
    // 목표는 사각 지대의 최소
    // cctv는 최대 8개이다. 즉 재귀 가능
    static List<CCTV> cctvs;
    static List<int[]> walls;

    // cctv는 총 5종류이고 방향은 4개임 물론 1번, 3번, 4번은 4개
    // 2번은 두개, 5번은 회전없음.
    static class CCTV{
        int dir;
        int type;
        int x, y;
        CCTV(int x, int y, int type, int dir){
            this.x = x;
            this.y = y;
            this.type = type;
            this.dir = dir;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        cctvs = new ArrayList<>();
        walls = new ArrayList<>();
        dirs = new ArrayList[6];

        for(int i = 1; i <= 5; i++){
            dirs[i] = new ArrayList<>();
        }

        init();

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                int num = Integer.parseInt(st.nextToken());
                if(num == 6) walls.add(new int[]{i,j});
                else if(num != 0) cctvs.add(new CCTV(i, j, num, 0));
            }
        }

        result = Integer.MAX_VALUE;

        find(0);

        System.out.print(result);
    }

    static void find(int index){
        if(index == cctvs.size()){
            // 여기에 맵 + 같은 크기 하나 만들어서 사각지대 크기 계산
            bfs();
            return;
        }
        CCTV cur = cctvs.get(index);
        if(cur.type == 1 || cur.type == 3 || cur.type == 4){
            // 여기는 for문 dir을 4까지
            for(int i = 0; i < 4; i++){
                cur.dir = (cur.dir + 1) % 4;
                find(index + 1);
            }
        }else if(cur.type == 2){
            // 여기는 for문 2개까지
            for(int i = 0; i < 2; i++){
                cur.dir = (cur.dir + 1) % 2;
                find(index + 1);
            }
        }else{
            // 여기는 5번이라서 그냥 하면 끝.
            find(index + 1);
        }
    }

    static void bfs(){
        // 현재 cctv 목록들을 다룬다
        int[][] board = new int[n][m];

        // 벽을 넣어준다.
        for(int i = 0; i < walls.size(); i++){
            int[] cur = walls.get(i);
            board[cur[0]][cur[1]] = 6;
        }

        // CCTV 별로 자신의 감지 공간을 만든다.
        for(int i = 0; i < cctvs.size(); i++){
            CCTV cur = cctvs.get(i);
            int x = cur.x, y = cur.y, dir = cur.dir, type =cur.type;
            Queue<int[]> que = new LinkedList<>();
            board[x][y] = 7;
            int[] types = dirs[type].get(dir);

            for(int d = 0; d < 4; d++){
                if(types[d] == 1){
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if(isRange(nx, ny) && board[nx][ny] != 6){
                        board[nx][ny] = 7;
                        que.offer(new int[]{nx, ny, d});
                    }
                }
            }

            while(!que.isEmpty()){
                int[] node = que.poll();

                int nx = node[0] + dx[node[2]];
                int ny = node[1] + dy[node[2]];
                if(isRange(nx, ny) && board[nx][ny] != 6){
                    board[nx][ny] = 7;
                    que.offer(new int[]{nx, ny, node[2]});
                }
            }

        }
        int count = 0;
        for(int a = 0; a < n; a++){
            for(int b = 0; b < m; b++){
                if(board[a][b] == 0) count++;
            }
        }
        result = Math.min(result, count);
    }

    static void prints(int[][] board){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean isRange(int nx, int ny){
        return !(nx < 0 || nx >= n || ny < 0 || ny >= m);
    }

    static void init(){
        // dirs 방향별로 채우는함수 // 상하좌우 기준임.
        dirs[1].add(new int[]{0, 0, 0, 1});
        dirs[1].add(new int[]{0, 1, 0, 0});
        dirs[1].add(new int[]{0, 0, 1, 0});
        dirs[1].add(new int[]{1, 0, 0, 0});

        dirs[2].add(new int[]{0, 0, 1, 1});
        dirs[2].add(new int[]{1, 1, 0, 0});

        dirs[3].add(new int[]{1, 0, 0, 1});
        dirs[3].add(new int[]{0, 1, 0, 1});
        dirs[3].add(new int[]{0, 1, 1, 0});
        dirs[3].add(new int[]{1, 0, 1, 0});

        dirs[4].add(new int[]{1, 0, 1, 1});
        dirs[4].add(new int[]{1, 1, 0, 1});
        dirs[4].add(new int[]{0, 1, 1, 1});
        dirs[4].add(new int[]{1, 1, 1, 0});

        dirs[5].add(new int[]{1, 1, 1, 1});
    }
}