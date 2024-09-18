import java.util.*;
import java.io.*;

class Main{

    static int M;
    static int N;
    static int K;
    static int[][] matrix;
    static boolean[][] visited;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        matrix = new int[M][N];

        for(int input = 0; input < K; input++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for(int x = y1; x < y2; x++){
                for(int y = x1; y < x2; y++){
                    matrix[x][y] = 1;
                }
            }
        }

        List<Integer> resultList = new ArrayList<>();
        int count = 0;
        visited = new boolean[M][N];
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j] && matrix[i][j] == 0){
                    resultList.add(bfs(i, j));
                    count++;
                }
            }
        }

        System.out.println(count);
        Collections.sort(resultList);
        StringBuilder sb = new StringBuilder();
        for(int num : resultList){
            sb.append(num).append(" ");
        }
        System.out.print(sb.toString());
    }

    static int bfs(int x, int y){
        Queue<int[]> que = new LinkedList<>();
        visited[x][y] = true;
        que.offer(new int[]{x,y});
        int count = 0;
        while(!que.isEmpty()){
            int[] temp = que.poll();
            count++;
            for(int dir = 0; dir < 4; dir++){
                int nx = temp[0] + dx[dir];
                int ny = temp[1] + dy[dir];
                if(!(nx < 0 || nx >= M || ny < 0 || ny >= N) && !visited[nx][ny] && matrix[nx][ny] == 0){
                    que.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }

        return count;
    }
}