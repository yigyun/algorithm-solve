package leetcode.graph_general.medium;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    static class Solution {

        static int[] dx = new int[]{0, 0, 1, -1};
        static int[] dy = new int[]{1, -1, 0, 0};
        static boolean[][] visited;
        static int m;
        static int n;

        public int numIslands(char[][] grid) {

            m = grid.length;
            n = grid[0].length;
            visited = new boolean[m][n];
            int result = 0;

            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(!visited[i][j]){
                        if(grid[i][j] == '1'){
                            findGroup(grid, i, j);
                            result++;
                        } else visited[i][j] = true;
                    }
                }
            }

            return result;
        }

        private void findGroup(char[][] grid, int x, int y){
            boolean check = true;
            Queue<int[]> que = new LinkedList<>();
            que.offer(new int[]{x,y});
            visited[x][y] = true;

            while(!que.isEmpty()){
                int[] num = que.poll();
                for(int dir = 0; dir < 4; dir++){
                    int nx = dx[dir] + num[0];
                    int ny = dy[dir] + num[1];
                    if(!(nx < 0 || ny < 0 || nx >= m || ny >= n)){
                        if(grid[nx][ny] == '1' && !visited[nx][ny]){
                            visited[nx][ny] = true;
                            que.add(new int[]{nx,ny});
                        }
                    }
                }
            }
        }
    }
}
