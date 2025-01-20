import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] chars1 = new int[26];
        int[] chars2 = new int[26];
        
        String str1 = br.readLine();
        String str2 = br.readLine();
        
        for(char ch : str1.toCharArray()){
            chars1[ch - 'a']++;
        }
        
        for(char ch : str2.toCharArray()){
            chars2[ch - 'a']++;
        }
        
        int removes = 0;
        for(int i = 0; i < 26; i++){
            removes += Math.abs(chars1[i] - chars2[i]);
        }
        
        System.out.print(removes);
    }
}