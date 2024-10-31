import java.util.*;

class Solution {
    
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    static int n;
    static int m;
    
    static int answer;
    
    public int solution(int[][] maps) {
        answer = -1;  
        bfs(maps);
        return answer == -1 ? answer : answer + 1;
    }
    
    static void bfs(int[][] maps){
        n = maps.length;
        m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{0, 0, 0});
        visited[0][0] = true;
        
        while(!que.isEmpty()){
            int[] cur = que.poll();
            
            if(cur[0] == n - 1 && cur[1] == m - 1){
                answer = cur[2];
                break;
            }
            
            for(int dir = 0; dir < 4; dir++){
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];
                if(isRange(nx, ny) && maps[nx][ny] != 0 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    que.offer(new int[]{nx, ny, cur[2] + 1});
                }
            }
        }
    }
    
    static boolean isRange(int nx, int ny){
        return !(nx < 0 || nx >= n || ny < 0 || ny >= m);
    }
}