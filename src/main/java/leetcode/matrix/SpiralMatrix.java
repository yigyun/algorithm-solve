package leetcode.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    static class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            int[] dx = new int[]{0, 1, 0, -1};
            int[] dy = new int[]{1, 0, -1, 0};
            boolean[][] visited = new boolean[matrix.length][matrix[0].length];
            List<Integer> result = new ArrayList<>();
            // 우하좌상 순서로 계속 돌아감.
            int dir = 0, x = 0, y = 0;
            int maxX = matrix.length; int maxY = matrix[0].length;

            visited[x][y] = true; result.add(matrix[x][y]);

            while(result.size() != (maxX * maxY)){
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if(!isValid(nx,ny,maxX,maxY) && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    result.add(matrix[nx][ny]);
                    x = nx; y = ny;
                }else{
                    dir = (dir + 1) % 4;
                }
            }
            return result;
        }

        static boolean isValid(int nx, int ny, int maxX, int maxY){
            return nx >= maxX || ny >= maxY || nx < 0 || ny < 0;
        }
    }
}
