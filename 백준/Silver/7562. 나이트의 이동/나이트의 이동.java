import java.util.*;
import java.io.*;

class Main{

    static int[][] matrix;
    static boolean[][] visited;
    static int l;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < t; i++){
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            matrix = new int[l][l];
            visited = new boolean[l][l];
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int gx = Integer.parseInt(st.nextToken());
            int gy = Integer.parseInt(st.nextToken());
            sb.append(bfs(x, y, gx, gy)).append("\n");
        }
        System.out.println(sb.toString());
    }

    static int[] dx = new int[]{1, 2, 1, 2, -1, -1, -2, -2};
    static int[] dy = new int[]{2, 1, -2, -1, -2, 2, 1, -1};

    static int bfs(int x, int y, int gx, int gy){
        Queue<int[]> que = new LinkedList<>();
        visited[x][y] = true;
        que.offer(new int[]{x, y});
        int count = 0;
        while(!que.isEmpty()){
            boolean find = false;
            int size = que.size();
            for(int i = 0; i < size; i++){
                int[] temp = que.poll();
                if(temp[0] == gx && temp[1] == gy){
                    find = true;
                    break;
                }
                for(int dir = 0; dir < 8; dir++){
                    int nx = temp[0] + dx[dir];
                    int ny = temp[1] + dy[dir];
                    if(!(nx < 0 || nx >= l || ny < 0 || ny >= l) && !visited[nx][ny]){
                        que.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
            if(find) break;
            count++;
        }
        return count;
    }
}