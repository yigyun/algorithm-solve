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
			String n = sc.next(); // 원본 암호문의 수
			int max = Integer.parseInt(n);
			int min = max;
			
			char[] arr = n.toCharArray();
			for(int i = 0; i < arr.length; i++) {
				for(int j = arr.length - 1; j > i; j--) {
					if(i == 0 && arr[j] == '0') continue;
					char temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					String str = new String(arr);
					int num = Integer.parseInt(str);
					max = Math.max(num, max);
					min = Math.min(num, min);
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
			
            System.out.println("#" + test_case + " " + min + " " + max);
		}
	}
}