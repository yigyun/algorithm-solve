import java.util.*;
import java.io.*;

class Main{

    static int h;
    static int w;
    static int[][] matrix;
    static boolean[][] visited;
    static int[] dx = new int[]{-1,1,0,0};
    static int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < t; i++){
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            visited = new boolean[h][w];
            matrix = new int[h][w];
            Queue<int[]> que = new LinkedList<>();
            int x = 0; int y = 0;
            for(int a = 0; a < h; a++){
                String str = (br.readLine());
                for(int j = 0; j < w; j++){
                    if(str.charAt(j) == '*'){
                        matrix[a][j] = -1;
                        que.offer(new int[]{a,j});
                        visited[a][j] = true;
                    }else if(str.charAt(j) == '@'){
                        matrix[a][j] = 1;
                        x = a; y = j;
                    }else if(str.charAt(j) == '#'){
                        matrix[a][j] = -2;
                    }
                }
            }
            que.offer(new int[]{x, y});
            visited[x][y] = true;
            int result = 0;
            while(!que.isEmpty()){
                int[] temp = que.poll();
                boolean find = false;
                for(int dir = 0; dir < 4; dir++){
                    int nx = temp[0] + dx[dir];
                    int ny = temp[1] + dy[dir];
                    if(matrix[temp[0]][temp[1]] > 0){
                        // 사람이고 범위 넘어가면
                        if(nx < 0 || nx >= h || ny < 0 || ny >= w){
                            result = matrix[temp[0]][temp[1]] + 1;
                            find = true;
                            break;
                        }else if(!visited[nx][ny] && matrix[nx][ny] == 0){
                            que.offer(new int[]{nx, ny});
                            visited[nx][ny] = true;
                            matrix[nx][ny] = matrix[temp[0]][temp[1]] + 1;
                        }
                    }else{
                        // 불의 이동
                        if(!(nx < 0 || nx >= h || ny < 0 || ny >= w) && !visited[nx][ny] && matrix[nx][ny] == 0 && matrix[temp[0]][temp[1]] == -1){
                            que.offer(new int[]{nx,ny});
                            visited[nx][ny] = true;
                            matrix[nx][ny] = -1;
                        }
                    }
                }
                if(find) break;
            }
            System.out.println(result == 0 ? "IMPOSSIBLE" : result-1);
        }
    }
}