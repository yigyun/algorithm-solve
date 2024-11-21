import java.util.*;

class Solution {
    
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[] answer = new int[2];

        
        boolean[][] visited = new boolean[m][n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(picture[i][j] != 0 && !visited[i][j]){
                    maxSizeOfOneArea = Math.max(findArea(visited, i, j, picture, m, n), maxSizeOfOneArea);
                    numberOfArea++;
                }
            }
        }
        
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        
        return answer;
    }
    
    static int findArea(boolean[][] visited, int x, int y, int[][] picture, int m, int n){
        Queue<int[]> que = new LinkedList<>();
        int num = picture[x][y];
        int size = 0;
        visited[x][y] = true;
        que.offer(new int[]{x, y});
        
        while(!que.isEmpty()){
            int[] cur = que.poll();
            size++;
            for(int dir = 0; dir < 4; dir++){
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];
                if(isRange(nx, ny, m, n) && !visited[nx][ny] && picture[nx][ny] == num){
                    visited[nx][ny] = true;
                    que.offer(new int[]{nx, ny});
                }
            }
        }
        return size;
    }
    
    static boolean isRange(int nx, int ny, int m, int n){
        return !(nx < 0 || nx >= m || ny < 0 || ny >= n);
    }
}