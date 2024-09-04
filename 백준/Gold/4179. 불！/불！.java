
import java.util.*;
import java.io.*;

public class Main
{

    static final int[] dx = new int[]{-1, 1, 0, 0};
    static final int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int time = Integer.MAX_VALUE;

        int[][] jihun = new int[R][C];
        int[][] fire = new int[R][C];

        Queue<int[]> fque = new LinkedList<>();
        Queue<int[]> jque = new LinkedList<>();
        boolean[][] visited = new boolean[R][C];

        for(int i = 0; i < R; i++){
            char[] carray = br.readLine().toCharArray();
            for(int j = 0; j < C; j++){
                if(carray[j] == '#'){
                    jihun[i][j] = -1; fire[i][j] = -1;
                }else if(carray[j] == 'J'){
                    jihun[i][j] = 1;
                    jque.offer(new int[]{i,j});
                    visited[i][j] = true;
                }else if(carray[j] == 'F'){
                    fire[i][j] = 1;
                    fque.offer(new int[]{i, j});
                }
            }
        }

        while(!jque.isEmpty()){
            int[] temp = jque.poll();
            int number = jihun[temp[0]][temp[1]];
            for(int dir = 0; dir < 4; dir++){
                int nx = temp[0] + dx[dir];
                int ny = temp[1] + dy[dir];
                if (nx >= 0 && nx < R && ny >= 0 && ny < C && !visited[nx][ny] && jihun[nx][ny] == 0) {
                    jque.offer(new int[]{nx,ny});
                    jihun[nx][ny] = number+1;
                    visited[nx][ny] = true;
                }
            }
        }

        visited = new boolean[R][C];
        while (!fque.isEmpty()) {
            int size = fque.size();
            for(int i = 0; i < size; i++) {
                int[] temp = fque.poll();
                int number = fire[temp[0]][temp[1]];
                for (int dir = 0; dir < 4; dir++) {
                    int nx = temp[0] + dx[dir];
                    int ny = temp[1] + dy[dir];
                    if (nx >= 0 && nx < R && ny >= 0 && ny < C && !visited[nx][ny] && fire[nx][ny] == 0) {
                        fque.offer(new int[]{nx, ny});
                        fire[nx][ny] = number + 1;
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (i == 0 || i == R - 1 || j == 0 || j == C - 1) {
                    if (jihun[i][j] > 0) {
                        if (jihun[i][j] < fire[i][j] || fire[i][j] == 0) {
                            time = Math.min(time, jihun[i][j]);
                        }
                    }
                }
            }
        }

        if(time == Integer.MAX_VALUE) System.out.print("IMPOSSIBLE");
        else System.out.print(time);
    }
}