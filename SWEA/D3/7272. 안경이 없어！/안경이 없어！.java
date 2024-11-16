import java.util.*;
import java.io.*;

class Solution {

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String sz = "CEFGHIJKLMNSTUVWXYZ";
        String so = "ADOPQR";
        
        Map<Character, Integer> chars = new HashMap<>();
        for(int i = 0; i < sz.length(); i++) {
        	chars.put(sz.charAt(i), 0);
        }
        for(int i = 0; i < so.length(); i++) {
        	chars.put(so.charAt(i), 1);
        }
        chars.put('B', 2);
        
        for(int test_case = 1; test_case <= T; test_case++) {    
        	
        	String s1 = sc.next();
        	String s2 = sc.next();
        	boolean check = false;
        	if(s1.length() != s2.length()) {
        		System.out.println("#" + test_case + " " + "DIFF");
        		continue;
        	}
        	
        	for(int i = 0; i < s1.length(); i++) {
        		if(chars.get(s1.charAt(i)) != chars.get(s2.charAt(i))) {
        			check = true;
        			break;
        		}
        	}
        	
        	if(check) {
                System.out.println("#" + test_case + " " + "DIFF");
        	}else {
                System.out.println("#" + test_case + " " + "SAME");
        	}
        }
    }

}
