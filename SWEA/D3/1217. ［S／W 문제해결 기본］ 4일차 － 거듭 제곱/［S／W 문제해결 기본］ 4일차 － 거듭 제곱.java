import java.util.Scanner;

class Solution
{
	
	static int n;
	static int m;
	static int result;
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);		
		for(int test_case = 1; test_case <= 10; test_case++)
		{	
			int t = sc.nextInt();
			
			result = 0;
			
			n = sc.nextInt();
			m = sc.nextInt();
			
			dfs(1, n);
			
            System.out.println("#" + test_case + " " + result);
		}
	}
	
	static void dfs(int depth, int sum) {
		if(depth == m) {
			result = sum;
			return;
		}
		
		dfs(depth + 1, sum * n);
	}
}