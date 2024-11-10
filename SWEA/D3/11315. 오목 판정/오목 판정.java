
import java.util.*;
import java.io.*;

class Solution
{
	static int[] dx = new int[] {1, 0, 1, 1};
	static int[] dy = new int[] {0, 1, -1, 1};
	static int n;
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{	
			n = sc.nextInt();
			char[][] charArr = new char[n][n];
			for(int i = 0; i < n; i++) {
				charArr[i] = sc.next().toCharArray();
			}
			
			boolean[][] visited = new boolean[n][n];
			boolean check = false;
			for(int i = 0; i < n; i++) {
				check = false;
				for(int j = 0; j < n; j++) {
					if(charArr[i][j] == 'o') {
						for(int dir = 0; dir < 4; dir++) {
							if(stone(charArr, i, j, dir) >= 5) {
								check = true;
								break;
							}
						}
					}
					if(check) break;
				}
				if(check) break;
			}
			
			if(check) System.out.println("#" + test_case + " " + "YES");
			else
            System.out.println("#" + test_case + " " + "NO");
		}
	}
	
	static int stone(char[][] charArr, int x, int y, int dir) {
		int count = 0;
		int nx = x;
		int ny = y;
		while(isRange(nx, ny) && charArr[nx][ny] == 'o') {
			count++;
			nx += dx[dir];
			ny += dy[dir];
		}
		
		return count;
	}
	
	static boolean isRange(int nx, int ny) {
		return !(nx < 0 || nx >= n || ny < 0 || ny >= n);
	}
}