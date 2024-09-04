


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
        int[][] matrix = new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int max = 0;
        int count = 0;
        
        boolean[][] visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!visited[i][j] && matrix[i][j] == 1){
                    count++;
                    visited[i][j] = true;
                    Queue<int[]> que = new LinkedList<>();
                    que.offer(new int[]{i, j});
                    int image = 0;
                    while(!que.isEmpty()){
                        int[] temp = que.poll();
                        image++;
                        for(int dir = 0; dir < 4; dir++){
                            int nx = temp[0] + dx[dir];
                            int ny = temp[1] + dy[dir];
                            if(!(nx < 0 || nx >= n || ny < 0 || ny >= m) && !visited[nx][ny] && matrix[nx][ny] == 1){
                                que.offer(new int[]{nx, ny});
                                visited[nx][ny] = true;
                            }
                        }
                    }
                    max = Math.max(max, image);
                }
            }
        }
        
        System.out.println(count);
        System.out.println(max);
    }
}
