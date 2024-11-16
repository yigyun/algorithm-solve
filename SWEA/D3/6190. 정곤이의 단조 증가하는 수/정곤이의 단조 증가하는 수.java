
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
			int[] nums = new int[n];
			for(int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
			}
			int max = -1;
			for(int i = 0; i < n; i++) {
				for(int j = i + 1; j < n; j++) {
					int num = nums[i] * nums[j];
					if(find(num)) max = Math.max(max, num);
				}
			}
			System.out.println("#" + test_case + " " + max);
		}
	}
	
	static boolean find(int num) {
		int d = num % 10;
		num /= 10;
		
		while(num > 0) {
			int cur = num % 10;
			if(cur > d) return false;
			d = cur;
			num /= 10;
		}
		
		return true;
	}
}