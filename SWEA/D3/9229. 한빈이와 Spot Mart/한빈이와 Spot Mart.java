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
			int m = sc.nextInt();
			
			int[] snacks = new int[n];
			for(int i = 0; i < n; i++) {
				snacks[i] = sc.nextInt();
			}
			
			Arrays.sort(snacks);
			
			int max = -1;
			
			for(int i = n-1; i > 0; i--) {
				for(int j = i-1; j >= 0; j--) {
					int num = snacks[i] + snacks[j];
					if(num > max) {
						if(num <= m) max = num;
					}else break;
				}
			}
			
            System.out.println("#" + test_case + " " + max);
		}
	}
}