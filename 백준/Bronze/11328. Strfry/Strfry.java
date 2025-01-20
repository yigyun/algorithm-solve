import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        for(int t = 0; t < n; t++){
            st = new StringTokenizer(br.readLine());
            int[] chars = new int[26];
            for(char ch : st.nextToken().toCharArray()){
                chars[ch - 'a']++;
            }

            for(char ch : st.nextToken().toCharArray()){
                chars[ch - 'a']--;
            }
            boolean check = true;
            for(int i = 0; i < 26; i++){
                if(chars[i] != 0){
                    check = false; break;
                }
            }
            if(check) sb.append("Possible"); else sb.append("Impossible");
            sb.append('\n');
        }

        System.out.print(sb);


    }
}