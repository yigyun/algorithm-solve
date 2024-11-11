
import java.util.*;
import java.io.*;

class Solution
{
	static int count;
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		int FAC = 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2;
		
		for(int test_case = 1; test_case <= T; test_case++)
		{	
			int[] p1 = new int[9];
			int[] p2 = new int[9];
			int[] nums = new int[19];
			for(int i = 0; i < 9; i++) {
				p1[i] = sc.nextInt();
				nums[p1[i]] = 1;
			}
			
			int index = 0;
			count = 0;
			
			for(int i = 1; i <= 18; i++) {
				if(nums[i] == 0) {
					p2[index++] = i;
				}
			}
			boolean[] visited = new boolean[9];
			win(0, 0, 0, p1, p2, visited);
			
            System.out.println("#" + test_case + " " + count + " " + (FAC - count));
		}
	}
	
	static void win(int depth, int s1, int s2, int[] p1, int[] p2, boolean[] visited) {
		if(depth == 9) {
			if(s1 > s2) count++;
			return;
		}
		
		for(int i = 0; i < 9; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			if(p1[depth] - p2[i] > 0) {
				win(depth + 1, s1 + p1[depth] + p2[i], s2, p1, p2, visited);
			}else {
				win(depth + 1, s1, s2 + p1[depth] + p2[i], p1, p2, visited);
			}
			visited[i] = false;
		}
	}
}