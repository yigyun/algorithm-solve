import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    
    static int max;
    public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			String num = sc.next();
            int count = sc.nextInt();
            char[] numArr = num.toCharArray();
  			max = 0;
            findMax(numArr, count, 0);
            System.out.println("#" + test_case + " " + max);
		}
	}
                               
    static void findMax(char[] numArr, int count, int start){
        if(count == 0){
        	max = Math.max(max, Integer.parseInt(new String(numArr)));
            return;
        }
    	int len = numArr.length;
		for(int i = start; i < len - 1; i++){
        	for(int j = i + 1; j < len; j++){
            	swap(numArr, i, j);
                findMax(numArr, count - 1, i);
                swap(numArr, i, j);
            }
        }
    }
    
   static void swap(char[] numAr, int i, int j){
   		char temp = numAr[i];
       numAr[i] = numAr[j];
       numAr[j] = temp;
   }
}