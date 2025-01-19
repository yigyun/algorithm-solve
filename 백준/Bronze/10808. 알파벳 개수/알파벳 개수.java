import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
    
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int[] alpha = new int[26];
        for(char ch : str.toCharArray()){
            int num = ch - 'a';
            alpha[num]++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++){
            sb.append(alpha[i]).append(" ");
        }
        System.out.print(sb);
    }
}