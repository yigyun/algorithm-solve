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
        N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < str.length(); j++){
                if(str.charAt(j) == '1'){
                    matrix[i][j] = 1;
                }
            }
        }

        List<Integer> resultList = new ArrayList<>();
        int count = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j] && matrix[i][j] == 1){
                    resultList.add(bfs(i, j));
                    count++;
                }
            }
        }

        Collections.sort(resultList);
        System.out.println(count);
        for(int num : resultList){
            System.out.println(num);
        }
    }

    static int bfs(int x, int y){
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{x, y});
        visited[x][y] = true;
        int count = 0;

        while(!que.isEmpty()){
            int[] temp = que.poll();
            count++;
            for(int dir = 0; dir < 4; dir++){
                int nx = temp[0] + dx[dir];
                int ny = temp[1] + dy[dir];
                if(!(nx < 0 || nx >= N || ny < 0 || ny >= N) && !visited[nx][ny] && matrix[nx][ny] == 1){
                    que.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }

        return count;
    }
}