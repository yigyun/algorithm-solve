package softeer.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class softeer10 {
    static int[][] matrix;
    static boolean[][] visited;
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{1, -1, 0, 0};
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        matrix = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for(int j = 0; j < N; j++){
                matrix[i][j] = Integer.parseInt(str.substring(j, j+1));
            }
        }

        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j] && matrix[i][j] == 1){
                    result.add(bfs(i, j));
                }
            }
        }

        System.out.println(result.size());

        Collections.sort(result);

        for(int num : result){
            System.out.println(num);
        }
    }

    static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int bfs(int x, int y){
        Queue<Node> que = new LinkedList<>();
        visited[x][y] = true;
        que.add(new Node(x, y));
        int count = 1;

        while(!que.isEmpty()){
            Node node = que.poll();
            for(int dir = 0; dir < 4; dir++){
                int nx = node.x + dx[dir];
                int ny = node.y + dy[dir];
                if(!valid(nx,ny) && !visited[nx][ny] && matrix[nx][ny] == 1){
                    que.add(new Node(nx, ny));
                    visited[nx][ny] = true;
                    count++;
                }
            }
        }

        return count;
    }

    static boolean valid(int nx, int ny){
        return (N <= nx || nx < 0 || ny >= N || ny < 0);
    }
}
