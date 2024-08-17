package programmers.level2;
import java.util.*;

public class Problem10 {

// 벽은 통과 x 통로된 칸 이동 o
// 레버칸으로 이동해서 레버 당기고 미로를 빠져나가는 문으로 이동 출구 칸도 지나갈수있음.

    static class Solution {

        static int[] dx = new int[]{-1, 1, 0, 0};
        static int[] dy = new int[]{0, 0, 1, -1};
        static int n;
        static int m;

        public int solution(String[] maps) {
            int answer = 0;
            // 1번 레버까지 이동
            // 2번 레버에서 문까지 이동을 분리해ㅓ 짜면 쉬울듯
            char[][] matrix = new char[maps.length][maps[0].length()];
            n = matrix.length;
            m = matrix[0].length;
            // 시작위치, 레버위치와 목표 위치 찾기
            int sx = 0; int sy = 0;
            int lx = 0; int ly = 0;
            int gx = 0; int gy = 0;

            for(int i = 0; i < matrix.length; i++){
                matrix[i] = maps[i].toCharArray();
                for(int j = 0; j < matrix[0].length; j++){
                    if(matrix[i][j] == 'L'){
                        lx = i; ly = j;
                    }else if(matrix[i][j] == 'E'){
                        gx = i; gy = j;
                    }else if(matrix[i][j] == 'S'){
                        sx = i; sy = j;
                    }
                }
            }

            // 레버로 이동하기
            int lev = bfs(matrix, sx, sy, lx, ly);
            if(lev == -1) return -1;
            System.out.println(lev);
            // 목적지로 이동하기
            int goal = bfs(matrix, lx, ly, gx, gy);
            if(goal == -1) return -1;
            System.out.println(goal);
            return lev + goal;
        }

        private int bfs(char[][] matrix, int sx, int sy, int gx, int gy){
            boolean[][] visited = new boolean[n][m];
            Queue<int[]> que = new LinkedList<>();
            visited[sx][sy] = true;
            que.offer(new int[]{sx, sy});
            int count = 0;

            while(!que.isEmpty()){
                count++;
                int size = que.size();
                for(int i = 0; i < size; i++){
                    int[] temp = que.poll();
                    for(int dir = 0; dir < 4; dir++){
                        int nx = temp[0] + dx[dir];
                        int ny = temp[1] + dy[dir];
                        if(!(nx < 0 || nx >= n || ny < 0 || ny >= m) && matrix[nx][ny] != 'X' && !visited[nx][ny]){
                            visited[nx][ny] = true;
                            que.offer(new int[]{nx, ny});
                            if(nx == gx && ny == gy) return count;
                        }
                    }
                }
            }

            return -1;
        }

    }
}
