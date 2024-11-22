
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();
            char[][] board = new char[n][n];
            for(int i = 0; i <n; i++){
               	board[i] = sc.next().toCharArray();
            }
            int[][] dp = new int[n][n];
            int count = 0;
            int size = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(board[i][j] == '#'){
                        count++;
                    	if(i == 0 || j == 0) dp[i][j] = 1;
                        else{
                       		dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                        }
                    }
                    size = Math.max(size, dp[i][j]);
                }
            }
			if(size * size == count) System.out.println("#" + test_case + " " + "yes");
            else System.out.println("#" + test_case + " " + "no");
		}
	}
}