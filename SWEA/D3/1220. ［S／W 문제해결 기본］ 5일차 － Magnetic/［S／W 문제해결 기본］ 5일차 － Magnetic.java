import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		for(int test_case = 1; test_case <= 10; test_case++)
		{	
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int[][] map = new int[100][100];
            
            for(int i = 0; i < 100; i++) {
            	st = new StringTokenizer(br.readLine());
            	for(int j = 0; j < 100; j++) {
            		map[i][j] = Integer.parseInt(st.nextToken());
            	}
            }
            
            
            int count = 0;
            
            for(int i = 0; i < 100; i++) {
            	boolean found = false;
            	
            	for(int j = 0; j < 100; j++) {
            		if(map[j][i] == 1) {
            			found = true;
            		}else if(map[j][i] == 2){
            			if(found) {
            				count++;
            				found = false;
            			}
            		}
            	}
            }
            
            System.out.println("#" + test_case + " " +count);
		}
	}
}