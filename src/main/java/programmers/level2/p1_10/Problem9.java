package programmers.level2;
import java.util.*;

public class Problem9 {

    static class Solution {

        // 상하좌우 4방향, 장애물이나 맨끝에 부딪힐때까지 이동하는게 한번
        // 가는길에 있어도 되는거 아님, 정확히 위치에 맞게 가야한다.

        // Queue로 한 단계씩을 모든 방향에 맞게 계속 만들어주면서 level을 신경쓰면 끝.

        static int[] dx = new int[]{-1, 1, 0, 0};
        static int[] dy = new int[]{0, 0, -1, 1};

        public int solution(String[] board) {
            int answer = 0;

            int gx = 0; int gy = 0;
            // 시작 좌표
            int x = 0; int y = 0;
            char[][] matrix = new char[board.length][board[0].length()];
            for(int i = 0; i < board.length; i++){
                matrix[i] = board[i].toCharArray();
            }

            for(int i = 0; i < matrix.length; i++){
                for(int j = 0; j < matrix[0].length; j++){
                    if(matrix[i][j] == 'R'){
                        x = i; y = j;
                    }
                    else if(matrix[i][j] == 'G'){
                        gx = i; gy = j;
                    }
                }
            }

            Queue<int[]> que = new LinkedList<>();
            que.offer(new int[]{x, y});
            boolean[][] visited = new boolean[matrix.length][matrix[0].length];
            visited[x][y] = true;

            int count = 0;
            boolean end = true;
            while(!que.isEmpty()){
                count++;
                int size = que.size();
                for(int i = 0; i < size; i++){
                    int[] temp = que.poll();
                    if(temp[0] == gx && temp[1] == gy){
                        end = false; break;
                    }
                    for(int dir = 0; dir < 4; dir++){
                        int nx = temp[0] + dx[dir];
                        int ny = temp[1] + dy[dir];
                        boolean check = true;
                        while(!(nx < 0 || nx >= matrix.length || ny < 0 || ny >= matrix[0].length)
                                && matrix[nx][ny] != 'D'){
                            nx = nx + dx[dir];
                            ny = ny + dy[dir];
                            check = false;
                        }
                        nx -= dx[dir]; ny -= dy[dir];
                        if(!check) {
                            if(!visited[nx][ny]){
                                visited[nx][ny] = true;
                                que.offer(new int[]{nx, ny});
                            }
                        }
                    }
                }
                if(!end) break;
            }

            if(end) return -1;

            return count-1;
        }
    }
}
