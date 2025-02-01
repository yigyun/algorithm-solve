import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        for(int i = n-1; i >= 0; i--){
            if(k / a[i] > 0){
                count += (k / a[i]);
                k -=  ((k / a[i]) * a[i]);
            }
        }

        System.out.print(count);
    }
}