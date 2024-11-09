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
            int size = 100;
            
            int[][] map = new int[size][size];
            int max = 0;
            for(int i = 0; i < size; i++) {
            	st = new StringTokenizer(br.readLine());
            	for(int j = 0; j < size; j++) {
            		map[i][j] = Integer.parseInt(st.nextToken());
            	}
            }
            int diag1 = 0;
            int diag2 = 0;
            
            for(int i = 0; i < size; i++) {
            	int col = 0;
            	int row = 0;
            	for(int j = 0; j < size; j++) {
            		if(i == j) diag1 += map[i][j];
            		if(i + j == size-1) { 
            			diag2 += map[i][j];
            		}
            		col += map[j][i];
            		row += map[i][j];
            	}
            	max = Math.max(max, Math.max(col, row));
            }
            max = Math.max(max,  Math.max(diag1, diag2));
            
            System.out.println("#" + test_case + " " + max);
		}
	}
}