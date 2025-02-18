import java.util.*;
import java.io.*;

class Main{
    /*
        규칙
        1. 각 플레이어는 하나 이상의 성을 가진다.
        2. 한 칸 위에 성이 두 개 이상일 수 없다.
        3. 라운드 마다 플레이어 순서대로 성은 확장한다.
        4. 자신이 가지고 있는 성을 비어있는 칸으로 확장시킨다.
            Si만큼 이동 가능한 모든 칸에 성을 동시에 만든다.
        5. 상하좌우만 가능
        6. 벽이나 다른 플레이어의 성이 있는 곳으로는 이동할 수 없다.
        7. 모든 플레이어가 확장 불가능하면 게임이 끝난다.
    */

    static int n, m, p;
    static int[][] map;
    static boolean[][] visited;
    static Player[] pls;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    static class Player{
        int score;
        int count;
        List<int[]> lists;
        Player(int score){
            lists = new ArrayList<>();
            this.score = score;
            count = 0;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited= new boolean[n][m];
        pls = new Player[p+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= p; i++){
            pls[i] = new Player(Integer.parseInt(st.nextToken()));
        }

        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = 0; j < m; j++){
                if(str.charAt(j) == '#')
                    map[i][j] = -1;
                else if(str.charAt(j) == '.')
                    map[i][j] = 0;
                else {
                    int num = str.charAt(j) - '0';
                    map[i][j] = num;
                    pls[num].lists.add(new int[]{i, j});
                    pls[num].count++;
                }
            }
        }

        while(true){
            int num = 0;

            for(int i = 1; i <= p; i++){
                num += expand(i);
            }

            if(num == 0) break;
        }
        for (int i = 1; i <= p; i++) {
            System.out.print(pls[i].count + " ");
        }
    }

    // 여기 지금 바꿀 부분이 일단 동시에 Si 범위가 바뀌는거라서
    // 성을 넘거나 벽을 넘어도 일

    static int expand(int num){
        Player pl = pls[num];
        boolean check = false;
        Queue<int[]> que = new LinkedList<>();
        for(int[] node : pl.lists){
            que.offer(new int[]{node[0], node[1], 0});
        }
        List<int[]> next = new ArrayList<>();

        while(!que.isEmpty()){
            int[] cur = que.poll();

            if(cur[2] == pl.score){
                next.add(new int[]{cur[0], cur[1]});
                continue;}

            for(int dir = 0; dir < 4; dir++){
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                if(isRange(nx, ny) && !visited[nx][ny] && map[nx][ny] == 0){
                    visited[nx][ny] = true;
                    que.offer(new int[]{nx, ny, cur[2] + 1});
                    //next.add(new int[]{nx, ny});
                    map[nx][ny] = num;
                    pl.count++;
                    check = true;
                }
            }
        }

        pl.lists = next;

        return check ? 1 : 0;
    }

    static boolean isRange(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}