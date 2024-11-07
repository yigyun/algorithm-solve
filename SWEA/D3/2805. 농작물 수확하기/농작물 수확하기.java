import java.util.*;
import java.io.FileInputStream;

class Solution
{
    static int[][] map;
    static int n;
    static int profit;
    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{-1, 1, 0, 0};
    
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			n = sc.nextInt();
            map = new int[n][n];
            profit = 0;
            for(int i = 0; i < n; i++){
            	String str = sc.next();
                char[] chArr = str.toCharArray();
                for(int j = 0; j < n; j++){
                	map[i][j] = chArr[j] - '0';
                }
            }
            bfs();
            
            System.out.println("#" + test_case + " " + profit);
		}
	}
    
    static void bfs(){
    	boolean[][] visited = new boolean[n][n];
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{n/2, n/2}); profit += map[n/2][n/2];
        visited[n/2][n/2] = true;
        int depth = n/2;
        
        while(!que.isEmpty() && depth > 0){
        	int size = que.size();
            for(int i = 0; i < size; i++){
            	int[] node = que.poll();
                for(int dir = 0; dir< 4; dir++){
                	int nx = node[0] + dx[dir];
                    int ny = node[1] + dy[dir];
                    if(!visited[nx][ny]){
                    	visited[nx][ny] = true;
                        que.offer(new int[]{nx, ny});
                        profit += map[nx][ny];
                    }
                }
            }
            depth--;
        }
    }
}