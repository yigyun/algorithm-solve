import java.util.*;
import java.io.*;

class Main{

    static int N;
    static int[][] matrix;
    static boolean[][] visited;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        matrix = new int[N][N];
        Set<Integer> set = new HashSet<>();

        // 입력
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                int num = Integer.parseInt(st.nextToken());
                matrix[i][j] = num;
                set.add(num);
            }
        }

        int max = 1;
        for(int height : set){
            visited = new boolean[N][N];
            int count = 0;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(matrix[i][j] > height && !visited[i][j]){
                        count++;
                        bfs(i, j, height);
                    }
                }
            }
            max = Math.max(max, count);
        }
        System.out.print(max);
    }

    static void bfs(int i, int j, int height){
        Queue<int[]> que = new LinkedList<>();
        visited[i][j] = true;
        que.offer(new int[]{i, j});

        while(!que.isEmpty()){
            int[] temp = que.poll();
            for(int dir = 0; dir < 4; dir++){
                int nx = temp[0] + dx[dir];
                int ny = temp[1] + dy[dir];
                if(!(nx < 0 || nx >= N || ny < 0 || ny >= N)
                        && !visited[nx][ny] && matrix[nx][ny] > height){
                    visited[nx][ny] = true;
                    que.offer(new int[]{nx, ny});
                }
            }
        }
    }
}