import java.util.*;
import java.io.*;

class Solution
{	
	
	static Scanner sc;
	
	public static void main(String args[]) throws Exception
	{
		sc = new Scanner(System.in);
//		int T = sc.nextInt();		
		for(int test_case = 1; test_case <= 10; test_case++)
		{	
			int n = sc.nextInt(); sc.nextLine();
			
			List<Integer> list = new ArrayList<>();
			for(int i = 0; i < n; i++) {
				int num = sc.nextInt();
				list.add(num);
			}
			sc.nextLine();
			
			int m = sc.nextInt(); sc.nextLine();
			StringTokenizer st = new StringTokenizer(sc.nextLine(), "IDA", true);
			for(int i = 0; i < m; i++) {
				String order = st.nextToken();
				StringTokenizer detail = new StringTokenizer(st.nextToken(), " ");
				if(order.equals("I")) {
					plus(list, detail);
				}else if(order.equals("D")) {
					remove(list, detail);
				}else {
					int e = Integer.parseInt(detail.nextToken());
					for(int j = 0; j < e; j++) {
						int num = Integer.parseInt(detail.nextToken());
						list.add(num);
					}
				}
			}
			
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < 10; i++) {
				sb.append(list.get(i)).append(" ");
			}
			
            System.out.println("#" + test_case + " " + sb.toString().trim());
		}
	}
	
	static void plus(List<Integer> list, StringTokenizer det) {
		int s = Integer.parseInt(det.nextToken());
		int e = Integer.parseInt(det.nextToken());
		
		for(int i = 0; i < e; i++) {
			int num = Integer.parseInt(det.nextToken());
			list.add(s + i, num);
		}
	}
	
	static void remove(List<Integer> list, StringTokenizer det) {
		int s = Integer.parseInt(det.nextToken());
		int e = Integer.parseInt(det.nextToken());
		
		for(int i = 0; i < e; i++) {
			list.remove(s + i);
		}
	}
}