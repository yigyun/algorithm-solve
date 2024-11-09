import java.util.*;
import java.io.*;

class Solution
{
	static int n;
	static int[] dx = new int[] {-1, 1, 0, 0, 1, 1, -1, -1};
	static int[] dy = new int[] {0, 0, -1, 1, 1, -1, 1, -1};
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{	
			n = sc.nextInt();
			int m = sc.nextInt();
			
			int[][] arr = new int[n][n];
			arr[n/2][n/2] = 2; arr[n/2-1][n/2-1] = 2;
			arr[n/2-1][n/2] = 1; arr[n/2][n/2-1] = 1;
			
			
			for(int i = 0; i < m; i++) {
				int x = sc.nextInt() - 1;
				int y = sc.nextInt() - 1;
				int stone = sc.nextInt();
				place(x, y, stone, arr);
			}
			
			int b = 0;
			int w = 0;
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(arr[i][j] == 1) b++;
					else if(arr[i][j] == 2) w++;
				}
			}
			
            System.out.println("#" + test_case + " " + b + " " + w);
		}
	}
	
	static class Node{
		int x; int y;
		List<int[]> list;
		int dir;
		Node(int x, int y, int dir, List<int[]> list){
			this.x = x;
			this.y = y;
			this.list = list;
			this.dir = dir;
		}
	}
	
	static void place(int x, int y, int stone, int[][] arr) {
		if(arr[x][y] != 0) return;
		int fs = stone == 1 ? 2 : 1;
		boolean[][] visited = new boolean[n][n];
		arr[x][y] = stone;
		visited[x][y] = true;
		Queue<Node> que = new LinkedList<>();
		for(int dir = 0; dir < 8; dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			if(isRange(nx, ny) && arr[nx][ny] == fs) {
				List<int[]> list = new ArrayList<>();
				list.add(new int[] {nx, ny});
				que.offer(new Node(nx, ny, dir, list));
			}
		}
		
		while(!que.isEmpty()) {
			Node cur = que.poll();
			if(arr[cur.x][cur.y] == 0) continue;
			if(arr[cur.x][cur.y] == stone) {
				for(int[] node : cur.list) {
					arr[node[0]][node[1]] = stone;
				}
				continue;
			}
			cur.x += dx[cur.dir];
			cur.y += dy[cur.dir];
			if(isRange(cur.x, cur.y)) {
				cur.list.add(new int[] {cur.x, cur.y});
				que.offer(cur);
			}
		}
	}
	
	static boolean isRange(int nx, int ny) {
		return !(nx < 0 || nx >= n || ny < 0 || ny >= n);
	}
}