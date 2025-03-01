import java.util.*;

class Solution {
    
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        int n = storage.length;
        int m = storage[0].length();
        int[][] map = new int[n + 2][m + 2];
        
        for(int i = 0; i < n+2; i++){
            Arrays.fill(map[i], -1);
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                map[i+1][j+1] = storage[i].charAt(j) - 'A';
            }
        }
        
        for(int r = 0; r < requests.length; r++){
            int ch = requests[r].charAt(0) - 'A';
            int length = requests[r].length();
            
            if(length >= 2){
                // 모든 ch 변경
                for(int i = 1; i <= n; i++){
                    for(int j = 1; j <= m; j++){
                        if(map[i][j] == ch) map[i][j] = -1;
                    }
                }
            }else{
                Queue<int[]> q = new LinkedList<>();
                boolean[][] visited = new boolean[n+2][m+2];
                q.offer(new int[]{0, 0});
                visited[0][0] = true;
                
                while(!q.isEmpty()){
                    int[] cur = q.poll();
                    int x = cur[0], y = cur[1];
                    
                    for(int dir = 0; dir < 4; dir++){
                        int nx = x + dx[dir];
                        int ny = y + dy[dir];
                        
                        if(isRange(n + 2, m + 2, nx, ny) && !visited[nx][ny]){
                            if(map[nx][ny] == -1){
                                visited[nx][ny] = true;
                                q.offer(new int[]{nx, ny});
                            }else if(map[nx][ny] == ch){
                                map[nx][ny] = -1;
                                visited[nx][ny] = true;
                            }
                        }
                    }
                }
                
            }
        }
        
        
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(map[i][j] != -1) answer++;
            }
        }
        
        return answer;
    }
    
    static boolean isRange(int n, int m, int nx, int ny){
        return !(nx < 0 || nx >= n || ny < 0 || ny >= m);
    }
}