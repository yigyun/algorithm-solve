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
			String[] strs = new String[5];
			int max = 0;
			for(int i = 0; i < 5; i++) {
				strs[i] = sc.next();
				max = Math.max(strs[i].length(), max);
			}
			
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < max; i++) {
				for(int j = 0; j < 5; j++) {
					if(strs[j].length() <= i) continue;
					sb.append(strs[j].charAt(i));
				}
			}
			
            System.out.println("#" + test_case + " " + sb.toString());
		}
	}
}