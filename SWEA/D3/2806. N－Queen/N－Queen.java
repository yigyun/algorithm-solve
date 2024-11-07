import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    static int count;
    static boolean[] col;
    static boolean[] diag1;
    static boolean[] diag2;
    static int N;
    
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
            col = new boolean[N];
            diag1 = new boolean[2 * N - 1]; // 이거는 //// 이렇게임
            diag2 = new boolean[2 * N - 1]; // 이거는 \\\\ 반대방향
            
            boolean[][] map = new boolean[N][N];
            count = 0;
            findQ(map, 0, 0, N);
			System.out.println("#" + test_case + " " + count);
		}
	}
    
    static void findQ(boolean[][] map, int index, int depth, int limit){
    		if(depth == limit){
            	count++;
                return;
            }
        
        	for(int i = 0; i < col.length; i++){
            	if(col[i] || diag1[index+i] || diag2[i - index + N - 1]) continue;
                map[index][i] = true;
                col[i] = true; diag1[index+i] = true; diag2[i - index + N - 1] = true;
                findQ(map, index+1, depth + 1, limit);
                map[index][i] = false;
                col[i] = false; diag1[index + i] = false; diag2[i-index+N - 1] = false;
            }
    }
}