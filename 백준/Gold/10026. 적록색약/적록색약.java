import java.util.*;
import java.io.*;

public class Main{

    static final int[] dx = new int[]{-1, 1, 0, 0};
    static final int[] dy = new int[]{0, 0, -1, 1};
    static int N;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        char[][] matrix = new char[N][N];
        for(int i = 0; i < N; i++){
            matrix[i] = br.readLine().toCharArray();
        }
        int result1 = 0;
        int result2 = 0;

        boolean[][] visited = new boolean[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j]){
                    visited[i][j] = true;
                    char ch = matrix[i][j];
                    Queue<int[]> que = new LinkedList<>();
                    que.offer(new int[]{i, j});
                    while(!que.isEmpty()){
                        int[] temp = que.poll();
                        for(int dir = 0; dir < 4; dir++){
                            int nx = temp[0] + dx[dir];
                            int ny = temp[1] + dy[dir];
                            if(isRange(nx, ny) && !visited[nx][ny] && matrix[nx][ny] == ch){
                                visited[nx][ny] = true;
                                que.offer(new int[]{nx, ny});
                            }
                        }
                    }
                    result1++;
                }
            }
        }

        visited = new boolean[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j]){
                    visited[i][j] = true;
                    char ch = matrix[i][j];
                    Queue<int[]> que = new LinkedList<>();
                    que.offer(new int[]{i, j});
                    while(!que.isEmpty()){
                        int[] temp = que.poll();
                        for(int dir = 0; dir < 4; dir++){
                            int nx = temp[0] + dx[dir];
                            int ny = temp[1] + dy[dir];
                            if(isRange(nx, ny) && !visited[nx][ny]){
                                if(ch == 'R' || ch == 'G'){
                                    if(matrix[nx][ny] == 'R' || matrix[nx][ny] == 'G'){
                                        visited[nx][ny] = true;
                                        que.offer(new int[]{nx, ny});
                                    }
                                }else if(ch == matrix[nx][ny]){
                                    visited[nx][ny] = true;
                                    que.offer(new int[]{nx, ny});
                                }
                            }
                        }
                    }
                    result2++;
                }
            }
        }

        System.out.println(result1 + " " + result2);

    }

    static boolean isRange(int x, int y){
        return !(x < 0 || x >= N || y < 0 || y >= N);
    }
}