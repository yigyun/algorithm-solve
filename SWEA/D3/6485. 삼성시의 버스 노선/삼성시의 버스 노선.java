
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
			int[][] range = new int[n+1][2];
			
			for(int i = 1; i <= n; i++) {
				range[i][0] = sc.nextInt();
				range[i][1] = sc.nextInt();
			}
			
			Arrays.sort(range, (o1, o2) ->{
				if(o1[0] == o2[0]) return o1[1] - o2[1];
				return o1[0] - o2[0];
			});
			
			int p = sc.nextInt();			
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < p; i++) {
				int num = sc.nextInt();
				int count = 0;
				for(int j = 1; j <= n; j++) {
					if(range[j][0] <= num && num <= range[j][1]) count++;
					else if(range[j][0] > num) break;
				}
				sb.append(count).append(" ");
			}
			
			
            System.out.println("#" + test_case + " " + sb.toString().trim());
		}
	}
}