import java.util.*;
import java.io.*;

class Solution
{
	static String[] codes = new String[] {
			"0001101", "0011001", "0010011", "0111101", "0100011",
			"0110001", "0101111", "0111011", "0110111", "0001011"};
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		for(int test_case = 1; test_case <= 10; test_case++)
		{	
			int t = sc.nextInt();
			String word = sc.next();
			String str = sc.next();
			int bl = str.length();
			str = str.replaceAll(word, "");
			int al = str.length();
			
			int num = (bl - al) / word.length();
			

            System.out.println("#" + t + " " + num);
		}
	}
	
}