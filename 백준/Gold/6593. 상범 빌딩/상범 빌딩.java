// 일단 설계를 잘해야함 입력을 잘 받아서 넣는게 중요함.
/**
 L 층 R 행 C 열
 '#'은 못가는 칸 1
 비어있는 칸 0
 **/

import java.util.*;
import java.io.*;

class Main{
    static int L;
    static int R;
    static int C;
    static int[][][] matrix;
    static boolean[][][] visited;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    static int sx;
    static int sy;
    static int sh;
    static int gx;
    static int gy;
    static int gh;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();

        while(input != null){
            StringTokenizer st = new StringTokenizer(input);
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            if(L == 0 && R == 0 && C == 0) break;
            matrix = new int[L][R][C];
            visited = new boolean[L][R][C];

            for(int i = 0; i < L; i++){
                for(int j = 0; j < R; j++){
                    String str = br.readLine();
                    for(int k =0; k < C; k++){
                        char ch = str.charAt(k);
                        if(ch == '#')
                            matrix[i][j][k] = 1;
                        else if(ch== 'S'){
                            matrix[i][j][k] = 2;
                            sh = i; sx = j; sy = k;
                        }
                        else if(ch == 'E'){
                            matrix[i][j][k] = 3;
                            gh = i; gx = j; gy = k;
                        }
                    }
                }
                String strs = br.readLine();
            }

            Queue<int[]> que = new LinkedList<>();
            visited[sh][sx][sy] = true;
            que.offer(new int[]{sh, sx, sy});
            boolean find = false;
            int time = 0;
            while(!que.isEmpty()){

                int size = que.size();
                boolean check = false;
                for(int i = 0; i < size; i++){
                    int[] temp = que.poll();
                    if(temp[0] == gh && temp[1] == gx && temp[2] == gy){
                        find = true;
                        break;
                    }

                    // 상하좌우
                    for(int dir = 0; dir < 4; dir++){
                        int nx = temp[1] + dx[dir];
                        int ny = temp[2] + dy[dir];
                        if(!(nx < 0 || nx >= R || ny < 0 || ny >= C)
                                && !visited[temp[0]][nx][ny] && matrix[temp[0]][nx][ny] != 1){
                            visited[temp[0]][nx][ny] = true;
                            que.offer(new int[]{temp[0], nx, ny});
                        }
                    }
                    int nh = temp[0] + 1;
                    if(!(nh < 0 || nh >= L) &&
                    !visited[nh][temp[1]][temp[2]] && matrix[nh][temp[1]][temp[2]] != 1){
                        visited[nh][temp[1]][temp[2]] = true;
                        que.offer(new int[]{nh, temp[1], temp[2]});
                    }
                    nh = temp[0] - 1;
                    if(!(nh < 0 || nh >= L) &&
                    !visited[nh][temp[1]][temp[2]] && matrix[nh][temp[1]][temp[2]] != 1){
                        visited[nh][temp[1]][temp[2]] = true;
                        que.offer(new int[]{nh, temp[1], temp[2]});
                    }
                }
                if(find) break;
                time++;
            }
            if(find) sb.append("Escaped in ").append(time).append(" minute(s).").append('\n');
            else sb.append("Trapped!").append('\n');
            input = br.readLine();
        }

        System.out.println(sb.toString());
    }
}