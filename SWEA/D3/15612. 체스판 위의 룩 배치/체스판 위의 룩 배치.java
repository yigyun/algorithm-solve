import java.util.*;
import java.io.*;

class Solution {

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {    
        	
        	int[] rows = new int[8];
        	int[] cols = new int[8];
        	
        	for(int i = 0; i < 8; i++) {
        		String str = sc.next();
        		for(int j = 0; j < 8; j++) {
        			if(str.charAt(j) == 'O') {
        				rows[i]++;
        				cols[j]++;
        			}
        		}
        	}
        	boolean check = false;
        	for(int i = 0; i < 8; i++) {
        		if(rows[i] > 1 || rows[i] == 0) check = true;
        		if(cols[i] > 1 || cols[i] == 0) check = true;
        	}
        	
        	if(check)
        		System.out.println("#" + test_case + " " + "no");
        	else
        		System.out.println("#" + test_case + " " + "yes");
        	
        }
    }
}
