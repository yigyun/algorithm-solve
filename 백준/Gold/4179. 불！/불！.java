import java.util.*;
import java.io.*;

class Main{

    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static int n, m;
    static int[][] fboard;
    static char[][] board;
    static int[][] jboard;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int result = Integer.MAX_VALUE;

        fboard = new int[n][m];
        board = new char[n][m];
        jboard = new int[n][m];
        Queue<int[]> fque = new LinkedList<>();
        Queue<int[]> jque = new LinkedList<>();

        for(int i = 0; i < n; i++){
            Arrays.fill(fboard[i], -1);
            Arrays.fill(jboard[i], -1);
        }

        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = 0; j < m; j++){
                board[i][j] = str.charAt(j);
                if(board[i][j] == 'J'){
                    jque.offer(new int[]{i, j});
                    jboard[i][j] = 0;
                }else if(board[i][j] == 'F'){
                    fque.offer(new int[]{i, j});
                    fboard[i][j] = 0;
                }
            }
        }

        // 불의 시간을 표현한다.
        while(!fque.isEmpty()){
            int[] cur = fque.poll();
            int x = cur[0], y = cur[1];

            for(int dir = 0; dir < 4; dir++){
                int nx = x+ dx[dir];
                int ny = y + dy[dir];

                if(isRange(nx, ny) && fboard[nx][ny] < 0 && board[nx][ny] != '#'){
                    fboard[nx][ny] = fboard[x][y] + 1;
                    fque.offer(new int[]{nx, ny});
                }
            }
        }

        // 지훈이가 움직인다
        while(!jque.isEmpty()){
            int[] cur = jque.poll();
            int x = cur[0], y = cur[1];
            for(int dir = 0; dir < 4; dir++){
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if(!isRange(nx, ny)){
                    System.out.print(jboard[x][y] + 1);
                    return;
                }


                if(isRange(nx, ny) && jboard[nx][ny] < 0 && board[nx][ny] != '#'){
                    if(fboard[nx][ny] != -1 && fboard[nx][ny] <= jboard[x][y] + 1) continue;
                    jboard[nx][ny] = jboard[x][y] + 1;
                    jque.offer(new int[]{nx, ny});
                }
            }
        }


        System.out.print("IMPOSSIBLE");
    }

    static boolean isRange(int nx, int ny){
        return !(nx < 0 || nx >= n || ny < 0 || ny >= m);
    }
}