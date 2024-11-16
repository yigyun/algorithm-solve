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
			int k = sc.nextInt();
			boolean[] works = new boolean[n+1];
			
			for(int i = 0; i < k; i++) {
				works[sc.nextInt()] = true;
			}
			
			StringBuilder sb = new StringBuilder();
			for(int i = 1; i <= n; i++) {
				if(!works[i]) sb.append(i).append(" ");
			}
			
            System.out.println("#" + test_case + " " + sb.toString().trim());
		}
	}
}