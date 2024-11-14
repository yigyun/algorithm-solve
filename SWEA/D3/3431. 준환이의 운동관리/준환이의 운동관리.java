
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
			int L = sc.nextInt();
			int U = sc.nextInt();
			int X = sc.nextInt();
			
			if(L <= X && X <= U) X = 0;
			else if(X < L) X = L - X;
			else X = -1;
			
            System.out.println("#" + test_case + " " + X);
		}
	}
}