import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			char[] charArr = sc.next().toCharArray();
            int[] dp = new int[charArr.length];
            int count = 0;
            
            for(int i = 0; i < dp.length - 1; i++){
            	if(dp[i] == (charArr[i] - '0')){ 
                    dp[i+1] = dp[i];
                    continue;
				 }
                dp[i] = charArr[i] - '0';
                count++;
                dp[i+1] = dp[i];
            }
            
            if(dp[charArr.length-1] != (charArr[dp.length-1] - '0')) count++;
            System.out.println("#" + test_case + " " + count);
		}
	}
}