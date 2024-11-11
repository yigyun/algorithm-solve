import java.util.*;
import java.io.*;

class Solution
{
	static int h;
	static int w;
	static int[] tank;
	static int[] dx = new int[] {0, -1, 0, 1};
	static int[] dy = new int[] {-1, 0, 1, 0};
	static char[] chars = new char[] {'<' , '^', '>', 'v'};
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
				
		for(int test_case = 1; test_case <= T; test_case++)
		{	
			h = sc.nextInt();
			w = sc.nextInt();
			StringBuilder sb = new StringBuilder();
			char[][] map = new char[h][w];
			tank = new int[3];
			for(int i = 0; i < h; i++) {
				map[i] = sc.next().toCharArray();
				for(int j = 0; j < w; j++) {
					if(map[i][j] == '.' || map[i][j] == '*' || map[i][j] == '#' || map[i][j] =='-') continue;
					tank = position(map[i][j], i, j);
				}
			}
			int N = sc.nextInt();
			char[] orders = sc.next().toCharArray();
			for(int i = 0; i < orders.length; i++) {
				if(orders[i] =='S') {
					shoot(map);
					continue;
				}else if(orders[i] =='L') {
					tank[2] = 0;
				}else if(orders[i] == 'U') {
					tank[2] = 1;
				}else if(orders[i] == 'R') {
					tank[2] = 2;
				}else if(orders[i] == 'D') {
					tank[2] = 3;
				}
				move(map);
			}
			
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					sb.append(map[i][j]);
				}
				sb.append('\n');
			}
			
			
            System.out.print("#" + test_case + " " + sb.toString());
		}
	}
	
	static void move(char[][] map) {
		int nx = tank[0] + dx[tank[2]];
		int ny = tank[1] + dy[tank[2]];
		if(isRange(nx, ny) && map[nx][ny] == '.') {
			map[tank[0]][tank[1]] = '.';
			map[nx][ny] = chars[tank[2]];
			tank[0] = nx; tank[1] = ny;
		}else {
			map[tank[0]][tank[1]] = chars[tank[2]];
		}
	}
	
	static void shoot(char[][] map) {
		int px = tank[0] + dx[tank[2]];
		int py = tank[1] + dy[tank[2]];
		
		while(isRange(px, py)) {
			if(map[px][py] == '*') {
				map[px][py] = '.';
				break;
			}else if(map[px][py] == '#') {
				break;
			}
			px += dx[tank[2]];
			py += dy[tank[2]];
		}
	}
	
	static int[] position(char ch, int x, int y) {
		if(ch == '<') return new int[] {x, y, 0};
		if(ch == '>') return new int[] {x, y, 2};
		if(ch == '^') return new int[] {x, y, 1};
		return new int[] {x, y, 3};
	}
	
	
	static boolean isRange(int nx, int ny) {
		return !(nx < 0 || nx >= h || ny < 0 || ny >= w);
	}
}