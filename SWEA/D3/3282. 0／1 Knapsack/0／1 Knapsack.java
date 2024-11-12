import java.util.*;
import java.io.*;

class Solution
{
	
	static int max;
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{	
			int N = sc.nextInt();
			int K = sc.nextInt();
			max = 0;
			
			int[][] num = new int[N][2];
			for(int i = 0; i < N; i++) {
				num[i][0] = sc.nextInt();
				num[i][1] = sc.nextInt();
			}
			
			Arrays.sort(num, (o1, o2) -> {
				if(o1[1] == o2[1]) return o1[0] - o2[0];
				return o2[1] - o1[1];
			});
			
			int[] dp = new int[K + 1];
			for(int i = 0; i < N; i++) {
				for(int j = K; j >= num[i][0]; j--) {
					dp[j] = Math.max(dp[j], dp[j - num[i][0]] + num[i][1]);
				}
			}
			
            System.out.println("#" + test_case + " " + dp[K]);
		}
	}	
}