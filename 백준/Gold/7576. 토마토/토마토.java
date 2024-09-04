
import java.util.*;
import java.io.*;

public class Main
{
    
    static final int[] dx = new int[]{-1, 1, 0, 0};
    static final int[] dy = new int[]{0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 입력
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[m][n];
        int mature = 0;
        int notmature = 0;
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
                if(matrix[i][j] == 1) mature++;
                else if(matrix[i][j] == 0) notmature++;
            }
        }
        int day = 0;
        int total = mature + notmature;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> que = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j] && matrix[i][j] == 1){
                    visited[i][j] = true;
                    que.offer(new int[]{i, j});
                }
            }
        }
        
        while(!que.isEmpty()){
            if(mature == total) break;
            day++;
            int size = que.size();
            for(int i = 0; i < size; i++){
                int[] temp = que.poll();
                for(int dir = 0; dir < 4; dir++){
                    int nx = temp[0] + dx[dir];
                    int ny = temp[1] + dy[dir];
                    if(!(nx < 0 || nx >= m || ny < 0 || ny >= n) && !visited[nx][ny] && matrix[nx][ny] == 0){
                        que.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        mature++;
                    }
                }
            }
        }
        
        if(mature != total) System.out.println(-1);
        else System.out.println(day);
    }
}
