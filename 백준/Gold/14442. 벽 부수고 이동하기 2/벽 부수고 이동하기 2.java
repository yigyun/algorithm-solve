import java.util.*;
import java.io.*;

class Main{

    static int n, m, k;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    static class Node{
        int x, y, dis, c;
        Node(int x, int y, int dis, int c){
            this.x = x;
            this.y = y;
            this.dis = dis;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int min = Integer.MAX_VALUE;

        map = new int[n][m];
        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }

        boolean[][][] visited= new boolean[n][m][k + 1];
        Queue<Node> que = new LinkedList<>();
        // x, y, 거리, 부순 횟수
        que.offer(new Node(0, 0, 1, 0));
        visited[0][0][0] = true;

        while(!que.isEmpty()){
            Node cur = que.poll();
            if(cur.x == n-1 && cur.y == m-1 && cur.c <= k){
                min = Math.min(min, cur.dis);
                continue;
            }

            for(int dir = 0; dir < 4; dir++){
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if(isRange(nx, ny)){
                    if(map[nx][ny] == 1 && cur.c < k && !visited[nx][ny][cur.c + 1]){
                        que.offer(new Node(nx, ny, cur.dis + 1, cur.c + 1));
                        visited[nx][ny][cur.c + 1] = true;
                    }else if(map[nx][ny] == 0 && !visited[nx][ny][cur.c]){
                        que.offer(new Node(nx, ny, cur.dis + 1, cur.c));
                        visited[nx][ny][cur.c] = true;
                    }
                }
            }
        }

        System.out.print(min == Integer.MAX_VALUE ? -1 : min);
    }

    static boolean isRange(int nx, int ny){
        return !(nx < 0 || nx >= n || ny < 0 || ny >= m);
    }
}