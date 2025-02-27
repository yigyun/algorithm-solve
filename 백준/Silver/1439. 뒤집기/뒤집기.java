import java.util.*;
import java.io.*;

class Main{

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 연속된 것의 갯수 구하면될듯?
        
        String str = br.readLine();
        int num = -1;
        int c1 = 0;
        int c2 = 0;
        for(char ch : str.toCharArray()){
            if(ch - '0' != num){
                if(ch - '0' == 0){
                    num = 0;
                    c1++;
                }else{
                    num = 1;
                    c2++;
                }
            }
        }
        
        System.out.print(c1 <= c2 ? c1 : c2);
    }
}