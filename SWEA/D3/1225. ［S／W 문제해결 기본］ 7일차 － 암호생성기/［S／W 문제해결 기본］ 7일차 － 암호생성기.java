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
			
			Queue<Integer> que = new LinkedList<>();
			
			for(int i = 0; i < 8; i++) {
				que.add(sc.nextInt());
			}
			
			boolean check = true;
			while(check) {
				for(int i = 1; i <= 5; i++) {
					int num = que.poll();
					if(num - i <= 0) {
						que.offer(0);
						check = false;
						break;
					}
					que.offer(num-i);
				}
			}
			StringBuilder sb = new StringBuilder();
			while(!que.isEmpty()) {
				sb.append(que.poll()).append(" ");
			}
			
            System.out.println("#" + test_case + " " + sb.toString());
		}
	}
}