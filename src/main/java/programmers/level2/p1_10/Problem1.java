package programmers.level2;

import java.util.*;

public class Problem1 {

    static class Solution {

        static int[] dx = new int[]{-1, 1, 0, 0};
        static int[] dy = new int[]{0, 0, 1, -1};

        public int solution(int[][] land) {
            int answer = 0;
            int n = land.length;
            int m = land[0].length;

            int[] total = new int[m];
            boolean[][] visited = new boolean[n][m];
            int group = 2;
            Map<Integer, Integer> column = new HashMap<>();

            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(land[i][j] == 1 && !visited[i][j]){
                        Queue<int[]> que = new LinkedList<>();
                        que.add(new int[]{i, j});
                        land[i][j] = group;
                        int count = 1;
                        while(!que.isEmpty()){
                            int[] coordi = que.poll();
                            for(int dir = 0; dir < 4; dir++){
                                int nx = coordi[0] + dx[dir];
                                int ny = coordi[1] + dy[dir];
                                if(!(nx < 0 || nx >= n || ny < 0 || ny >= m) && land[nx][ny] == 1){
                                    visited[nx][ny] = true;
                                    que.offer(new int[]{nx, ny});
                                    land[nx][ny] = group;
                                    count++;
                                }
                            }
                        }
                        column.put(group, count);
                        group++;
                    }
                }
            }

            // group은 2번 - 4번임
            for(int i = 0; i < m; i++){
                Set<Integer> set = new HashSet<>();
                for(int j = 0; j < n; j++){
                    if(land[j][i] != 0){
                        set.add(land[j][i]);
                    }
                }
                int sum = 0;
                for(int gr : set){
                    sum += column.get(gr);
                }
                answer = Math.max(answer, sum);
            }

            return answer;
        }
    }
}
