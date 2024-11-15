
import java.util.*;
import java.io.*;

class Solution
{
	static int[] price;
	static int[] weight;
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{	
			int n = sc.nextInt();
			int m = sc.nextInt();
			int total = 0; // 총 합
			price = new int[n]; // 각 주차 공간 단위 가격
			PriorityQueue<Integer> que = new PriorityQueue<>();
			for(int i = 0; i < n; i++) {
				price[i] = sc.nextInt();
				que.offer(i);
			}
			weight = new int[m]; // 각 차의 무게
			for(int i = 0; i < m; i++) {
				weight[i] = sc.nextInt();
			}

			Queue<Integer> in = new LinkedList<>();
			int[] place = new int[m];
			
			for(int i = 0; i < (2*m); i++) {
				int op = sc.nextInt();
				if(op < 0) {
					int id = -op;
					id--;
					
					que.offer(place[id]);
					place[id] = 0;
					if(!in.isEmpty()) {
						int num = in.poll();
						int p = que.poll();
						place[num] = p;
						total += (weight[num] * price[p]);
					}
				}else {
					int id = op - 1;
					if(que.isEmpty()) {
						in.add(id);
					}else {
						int p = que.poll();
						place[id] = p;
						total += (weight[id] * price[p]);
					}
				}
			}
			
			
			
            System.out.println("#" + test_case + " " + total);
		}
	}
}