/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.*;
import java.io.*;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		for(int test_case = 1; test_case <= 10; test_case++)
		{
            StringBuilder sb = new StringBuilder();
            int N = sc.nextInt();
			int[] bds = new int[N];
            for(int i = 0; i < N; i++){
            	bds[i] = sc.nextInt();
            }
            int result = 0;
            for(int i = 2; i < N-2; i++){
                result += findBu(bds, i);
            }
            
            sb.append("#").append(test_case).append(" ").append(result).append('\n');
       	 	System.out.print(sb.toString());
		}
	}
    
    static int findBu(int[] bds, int index){
        int min = bds[index];
    	for(int i = -2; i <= 2; i++){
        	if(i == 0) continue;
            if(bds[index] - bds[index + i] <= 0) return 0;
            min = Math.min(min, bds[index] - bds[index + i]);
        }
        return min;
    }
}