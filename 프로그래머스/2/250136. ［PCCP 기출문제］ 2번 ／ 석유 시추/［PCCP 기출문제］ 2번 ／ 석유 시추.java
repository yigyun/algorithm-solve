import java.util.*;
// 12:25
class Solution {
    // n x m
    static int n;
    static int m;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};
    /**
        bfs 돌면서 해당 덩어리 크기 구하면서 지금 포함된 col을 리스트로 표시해둠.
        그 col을 다 돌고 구한 덩어리 크기를 더해줌.
        가장 큰 col 구하면 끝.
    **/
    public int solution(int[][] land) {
        int answer = 0;
        
        n = land.length;
        m = land[0].length;
        int[] cols = new int[m];
        boolean[][] visited = new boolean[n][m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(land[i][j] == 1 && !visited[i][j]){
                    visited[i][j] = true;
                    int size = 0;
                    Queue<int[]> que = new LinkedList<>();
                    que.offer(new int[]{i, j});
                    Set<Integer> col = new HashSet<>();
                    while(!que.isEmpty()){
                        int[] cur = que.poll();
                        col.add(cur[1]);
                        size++;
                        
                        for(int dir = 0; dir < 4; dir++){
                            int nx = cur[0] + dx[dir];
                            int ny = cur[1] + dy[dir];
                            if(isRange(nx, ny) && !visited[nx][ny] && land[nx][ny] == 1){
                                visited[nx][ny] = true;
                                que.offer(new int[]{nx, ny});
                            }
                        }
                    }
                    
                    for(int num : col){
                        cols[num] += size;
                    }
                }
            }
        }
        
        for(int i = 0; i < m; i++){
            answer = Math.max(answer, cols[i]);
        }
        
        return answer;
    }
    
    static boolean isRange(int nx, int ny){
        return !(nx < 0 || nx >= n || ny < 0 || ny >= m);
    }
}