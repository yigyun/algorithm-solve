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
			int n = sc.nextInt(); // 원본 암호문의 수
			// 1아니면 0의 값을 갖는다
			// 일월화수목금토 순서다
			int[] days = new int[7];
			// 수업이 하루는 적어도 열린다
			int total = 0;
			for(int i = 0; i < 7; i++) {
				days[i] = sc.nextInt();
				total += days[i];
			}
			
			int classes = n % total == 0 ? ((n / total) - 1) : (n / total);
			int day = classes * 7;
			classes *= total;
						
			int result = Integer.MAX_VALUE;
			
			for(int i = 0; i < 7; i++) {
				if(days[i] == 0) continue;
				int tempd = day + 1;
				int tempc = classes + 1;
				for(int j = i + 1; j < i + 7; j++) {
					if(tempc == n) {
						result = Math.min(result, tempd);
						break;
					}
					if(days[j % 7] == 1) tempc++;
					tempd++;
				}
			}
			
            System.out.println("#" + test_case + " " + result);
		}
	}
}