
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
			StringBuilder sb = new StringBuilder();
			int point = n % 2 == 0 ? n / 2 : (n / 2) + 1;
			int hol = 0; int jack = 1;
			String[] strs = new String[n];
			for(int i = 0; i < n; i++) {
				if(i < point) {
					strs[hol] = sc.next(); hol+=2;
				}else {
					strs[jack] = sc.next(); jack +=2;
				}
			}
			
			for(int i = 0; i < n; i++) {
				sb.append(strs[i]).append(" ");
			}
			
			
            System.out.println("#" + test_case + " " + sb.toString().trim());
		}
	}
}