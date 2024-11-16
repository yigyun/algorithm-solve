import java.util.*;
import java.io.*;

class Solution
{	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{	
			int n = sc.nextInt();
			int q = sc.nextInt();
			int[] nums = new int[n+1];
			for(int i = 1; i <= q; i++) {
				int l = sc.nextInt();
				int r = sc.nextInt();
				for(int j = l; j <= r; j++) {
					nums[j] = i;
				}
			}
			
			StringBuilder sb = new StringBuilder();
			for(int i = 1; i <= n; i++) {
				sb.append(nums[i]).append(" ");
			}
			
			System.out.println("#" + test_case + " " + sb.toString().trim());
		}
	}
}