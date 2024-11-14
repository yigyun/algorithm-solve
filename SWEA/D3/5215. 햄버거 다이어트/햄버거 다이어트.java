import java.util.*;
import java.io.*;

class Solution
{	
	
	static Scanner sc;
	
	public static void main(String args[]) throws Exception
	{
		sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{	
			int N = sc.nextInt();
			int L = sc.nextInt();
			int[] score = new int[N];
			int[] cal = new int[N];
			int[] dp = new int[L + 1];
			
			for(int i = 0; i < N; i++) {
				score[i] = sc.nextInt();
				cal[i] = sc.nextInt();
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = L; j >= cal[i]; j--) {
					dp[j] = Math.max(dp[j], dp[j - cal[i]] + score[i]);
				}
			}
			
            System.out.println("#" + test_case + " " + dp[L]);
		}
	}
}