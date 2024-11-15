
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
			String str = sc.next();
			int e = str.length() - 1;
			
			double n = Double.parseDouble(str.substring(0, 3)) / 10;
			n = Math.round(n);
            n  /= 10;
			if(n >= 10) {
				e++; n /= 10;
			}
			
            System.out.println("#" + test_case + " " + n + "*" + 10 + "^" + e);
		}
	}
}