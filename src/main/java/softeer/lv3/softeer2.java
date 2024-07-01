package softeer.lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class softeer2 {

    // 유령이 움직이지 않을 수 있음에 유의. 즉 그냥 탈출구 먼저 갈 수 있으면 무조건 유령이 이긴다.

    // 미로 n x m
    static int n;
    static int m;
    static int[][] matrix;
    static int gx;
    static int gy;
    static int nx;
    static int ny;
    static final int[] dx = new int[]{-1, 1, 0, 0};
    static final int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int ghost = 0;
        List<Node> list = new ArrayList<>();
        // . = 0, # = 1, N = 2, D =3, G = 4
        matrix = new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for(int j = 0; j < m; j++){
                if(str.charAt(j) == '.') matrix[i][j] = 0;
                else if(str.charAt(j) == '#') matrix[i][j] = 1;
                else if(str.charAt(j) == 'N') {
                    matrix[i][j] = 2;
                    nx = i; ny = j;
                }
                else if(str.charAt(j) == 'D'){
                    gx = i; gy = j;
                    matrix[i][j] = 3;}
                else{
                    matrix[i][j] = 4;
                    list.add(new Node(i,j));
                }
            }
        }

        boolean check = false;
        // N이 D로가는 최단거리 구하기.
        int nToD = bfs(nx, ny);
        if(nToD == 0) check = true;
        // G가 D로가는 최단거리 구하기. 이거는 몇칸인지만 알면됨.
        for(Node node : list){
            int distance = Math.abs(node.x - gx) + Math.abs(node.y - gy);
            if(distance <= nToD) {
                check = true;
            }
        }
        if(check) System.out.print("No");
        else System.out.print("Yes");
    }

    static class Node{
        int x; int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int bfs(int x, int y){
        int[][] visited = new int[n][m];
        visited[x][y] = 0;
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(x, y));

        while(!que.isEmpty()){
            Node current = que.poll();
            for(int dir = 0; dir < 4; dir++){
                int nxc = current.x + dx[dir];
                int nyc = current.y + dy[dir];
                if((nxc >= 0 && nxc < n && nyc >= 0 && nyc < m) &&
                        matrix[nxc][nyc] != 1 && visited[nxc][nyc] == 0)
                {
                    que.offer(new Node(nxc,nyc));
                    visited[nxc][nyc] = visited[current.x][current.y] + 1;
                }
            }
        }
        return visited[gx][gy];
    }
}
