
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
			StringTokenizer st = new StringTokenizer(sc.next(), "SDHC", true);
			boolean[][] cards = new boolean[4][14];
			// S = 0, D = 1, H = 1, C = 1
			boolean check = false;
			while(st.hasMoreTokens()) {
				String s = st.nextToken();
				int number = Integer.parseInt(st.nextToken());
				if(s.equals("S")) {
					if(cards[0][number]) { check = true; break;}
					cards[0][number] = true;
				}else if(s.equals("D")) {
					if(cards[1][number]) { check = true; break;}
					cards[1][number] = true;
				}else if(s.equals("H")) {
					if(cards[2][number]) { check = true; break;}
					cards[2][number] = true;
				}else {
					if(cards[3][number]) { check = true; break;}
					cards[3][number] = true;
				}
			}
			
			if(check) System.out.println("#" + test_case + " " +"ERROR");
			else {
				StringBuilder sb = new StringBuilder();
				for(int i = 0; i < 4; i++) {
					int count = 0;
					for(int j = 1; j < 14; j++) {
						if(!cards[i][j]) count++;
					}
					sb.append(count).append(" ");
				}
				System.out.println("#" + test_case + " " + sb.toString().trim());
			}
		}
	}
}