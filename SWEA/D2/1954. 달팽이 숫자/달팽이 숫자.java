
import java.util.*;
import java.io.*;

class Solution {
	
	static int[] dx = new int[] {0, 1, 0, -1};
	static int[] dy = new int[] {1, 0, -1, 0};
	static int n;
	
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++) {    
        	n = sc.nextInt();
        	int[][] array = new int[n][n];
        	StringBuilder sb = new StringBuilder();
        	
        	Queue<int[]> que = new LinkedList<>();
        	que.offer(new int[] {0, 0, 0});
        	int num = 1;
        	while(!que.isEmpty()) {
        		int[] cur = que.poll();
        		array[cur[0]][cur[1]] = num++;
        		int nx = cur[0] + dx[cur[2]];
        		int ny = cur[1] + dy[cur[2]];
        		if(isRange(nx, ny) && array[nx][ny] == 0) {
        			que.offer(new int[] {nx, ny, cur[2]});
        		}else {
        			nx = cur[0] + dx[(cur[2] + 1) % 4];
        			ny = cur[1] + dy[(cur[2] + 1) % 4];
        			if(isRange(nx, ny) && array[nx][ny] == 0) {
        				que.offer(new int[] {nx, ny, (cur[2] + 1) % 4});
        			}
        		}
        	}
        	
        	for(int i = 0; i < n; i++) {
        		for(int j = 0; j < n; j++) {
        			sb.append(array[i][j]).append(" ");
        		}
        		sb.append('\n');
        	}

            System.out.println("#" + test_case);
            System.out.print(sb.toString());
        }
    }
    static boolean isRange(int nx, int ny) {
    	return !(nx < 0 || nx >= n || ny < 0 || ny >= n);
    }
}
