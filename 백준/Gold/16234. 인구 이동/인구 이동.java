import java.util.*;
import java.io.*;

/**
 N x N(50 x 50)
 a[r][c]에 사람이 x명 산다.

 인구이동하기
 두 나라의 인구 차이가 L명 이상, R명 이하라면 둘은 국경선을 서로 열어 준다.

 인구이동이 없으면 닫는다.
 **/

class Main{

    static int[][] map;
    static boolean[][] visited;
    static int N;
    static int L;
    static int R;

    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean check = true;
        int day = 0;

        while(true){
            check = false;
            visited = new boolean[N][N];

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(!visited[i][j]){
                        visited[i][j] = true;
                        Queue<int[]> que = new LinkedList<>();
                        que.offer(new int[]{i, j});
                        List<int[]> route = new ArrayList<>();
                        route.add(new int[]{i, j});
                        int count = map[i][j];

                        while(!que.isEmpty()){
                            int[] current = que.poll();
                            for(int dir = 0; dir < 4; dir++){
                                int nx = current[0] + dx[dir];
                                int ny = current[1] + dy[dir];
                                if(isRange(nx, ny) && !visited[nx][ny] && isFed(current, nx, ny)){
                                    visited[nx][ny] = true;
                                    que.offer(new int[]{nx, ny});
                                    count += map[nx][ny];
                                    route.add(new int[]{nx, ny});
                                }
                            }
                        }

                        if(route.size() > 1) {
                            check = true;
                            int num = count / route.size();
                            for (int[] node : route) {
                                map[node[0]][node[1]] = num;
                            }
                        }
                    }
                }
            }

            if (!check) {
                break;
            }
            day++;
        }

        System.out.print(day);
    }

    static boolean isFed(int[] node, int x, int y){
        int num = Math.abs(map[node[0]][node[1]] - map[x][y]);
        return (num >= L && num <= R);
    }

    static boolean isRange(int nx, int ny){
        return !(nx < 0 || ny < 0 || nx >= N || ny >= N);
    }
}