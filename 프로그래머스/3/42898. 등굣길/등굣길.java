class Solution {
    
    static int[] dx = {1, 0}, dy = {0, 1};
    
    public int solution(int n, int m, int[][] puddles) {
        int answer = 0;
        
        int[][] map = new int[m][n];
        map[0][0] = 1;
        
        for(int i = 0; i < puddles.length; i++){
            int x = puddles[i][1] - 1;
            int y = puddles[i][0] - 1;
            map[x][y] = -1;
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] == -1) continue;
                for(int dir = 0; dir < 2; dir++){
                    int nx = i + dx[dir];
                    int ny = j + dy[dir];
                    if(isRange(m, n, nx, ny) && map[nx][ny] != -1){
                        map[nx][ny] = (map[nx][ny] + map[i][j]) % 1000000007;
                    }
                }
            }
        }
        
        return map[m-1][n-1];
    }
    
    static boolean isRange(int m, int n, int nx, int ny){
        return !(nx < 0 || nx >= m || ny < 0 || ny >= n);
    }
    
}