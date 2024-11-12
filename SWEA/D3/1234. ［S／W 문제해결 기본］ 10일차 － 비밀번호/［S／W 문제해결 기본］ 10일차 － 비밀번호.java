import java.util.*;
import java.io.*;

class Solution
{
	
	static int max;
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{	
			int N = sc.nextInt();
			Queue<Character> que = new LinkedList<>();
			Stack<Character> stack = new Stack<>();
			StringBuilder sb = new StringBuilder();
			
			char[] charArr = sc.next().toCharArray();
			for(int i = 0; i < N; i++) {
				que.offer(charArr[i]);
			}
			
			while(!que.isEmpty()) {
				char num = que.poll();
				
				if(stack.isEmpty()) {
					stack.push(num);
				}else {
					if(stack.peek() == num) {
						stack.pop();
						continue;
					}else {
						stack.push(num);
					}
				}
			}
			
			while(!stack.isEmpty()) {
				sb.append(stack.pop());
			}
			
            System.out.println("#" + test_case + " " + sb.reverse().toString());
		}
	}	
}