import java.util.*;
import java.io.*;

class Solution
{	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
//		int T = Integer.parseInt(br.readLine());		
		for(int test_case = 1; test_case <= 10; test_case++)
		{	
			int N = sc.nextInt(); // 원본 암호문의 수

			List<Integer> password = new ArrayList<>();
			for(int i = 0; i < N; i++) {
				password.add(sc.nextInt());
			}
			
			int command = sc.nextInt();
			sc.nextLine();
			
			String[] commands = sc.nextLine().split("I ");
			for(String com : commands) {
				if(com.isEmpty()) continue;
				
				String[] strs = com.trim().split(" ");
				int x = Integer.parseInt(strs[0]);
				int k = Integer.parseInt(strs[1]);
				for(int i = 0; i < k; i++) {
					int num = Integer.parseInt(strs[i + 2]);
					password.add(x + i, num);
				}
			}
			
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < 10; i++) {
				sb.append(password.get(i)).append(" ");
			}
			
            System.out.println("#" + test_case + " " + sb.toString().trim());
		}
	}
}