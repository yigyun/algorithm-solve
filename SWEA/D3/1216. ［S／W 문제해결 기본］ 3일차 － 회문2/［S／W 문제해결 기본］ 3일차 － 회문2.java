
import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		for(int test_case = 1; test_case <= 10; test_case++)
		{	
			int t = sc.nextInt();
			
			char[][] charArr = new char[100][100];
			
			for(int i = 0; i < 100; i++) {
				charArr[i] = sc.next().toCharArray();
			}
			
			int max = 1;
			
			
			for(int k = 100; k >= 2; k--) {
				boolean found = false;
				
				for(int i = 0; i < 100; i++) {
					for(int j = 0; j < 100 - k; j++) {
						if(match(charArr, i, j, k, true)) {
							max = k;
							found = true;
							break;
						}
					}
					if(found) break;
				}
				
				if(!found) {
					for(int i = 0; i < 100; i++) {
						for(int j = 0; j < 100 - k; j++) {
							if(match(charArr, j, i, k, false)) {
								max = k;
								found = true;
								break;
							}
						}
						if(found) break;
					}
				}
				if(found) break;
			}
			
            System.out.println("#" + t + " " + max);
		}
	}
	
	static boolean match(char[][] charArr, int r, int c, int len, boolean isRow) {
		int end = len - 1;
		for(int i = 0; i <= end / 2; i++) {
			if(isRow) {
				if(charArr[r][c + i] != charArr[r][c + end - i]) {
					return false;
				}
			} else {
				if(charArr[r + i][c] != charArr[r + end - i][c]) {
					return false;
				}
			}
		}
		return true;
		
	}
}