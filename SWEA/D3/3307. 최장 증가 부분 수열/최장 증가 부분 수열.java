import java.util.*;
import java.io.*;

class Solution
{	
	
	static Scanner sc;
	static int n;
	static int max;
	
	public static void main(String args[]) throws Exception
	{
		sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{	
			n = sc.nextInt(); sc.nextLine();
			int[] nums = new int[n];
			for(int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
			}
			int[] dp = new int[n];
			Arrays.fill(dp, 1);
			max = 1;
			
			for(int i = 1; i < n; i++) {
				for(int j = 0; j < i; j++) {
					if(nums[i] > nums[j])
						dp[i] = Math.max(dp[i], dp[j] + 1);
				}
				max = Math.max(dp[i], max);
			}
			
			
            System.out.println("#" + test_case + " " + max);
		}
	}
}