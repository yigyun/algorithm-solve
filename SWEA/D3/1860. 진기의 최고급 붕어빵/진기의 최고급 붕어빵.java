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
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			
			
			// 현재 시점 붕어빵 먹은 사람 수
			// 시점에 가능한 붕어빵의 수 두고 풀면 끝?
			
			int[] persons = new int[n];
			for(int i = 0; i < n; i++) {
				persons[i] = sc.nextInt();
			}
			Arrays.sort(persons);
			
			int eated = 0; boolean check = true;
			
			for(int i = 0; i < n; i++) {
				int bread = (persons[i] / m) * k;
				if(bread - eated > 0) eated++;
				else { 
					check = false;
					break;
				}
			}
			
            if(check) {
                System.out.println("#" + test_case + " Possible");
            }else {
            	System.out.println("#" + test_case + " Impossible");
            }
		}
	}
}