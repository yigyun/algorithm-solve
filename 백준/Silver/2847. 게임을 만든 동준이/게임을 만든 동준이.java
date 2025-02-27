import java.util.*;
import java.io.*;

class Main{

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] points = new int[n];
        for(int i = 0; i < n; i++){
            points[i] = Integer.parseInt(br.readLine());
        }
        
        int count = 0;
        int point = points[n-1];
        for(int i = n - 2; i >= 0; i--){
            if(points[i] >= point){
                count += points[i] - point + 1;
                point -= 1;
            }else{
                point = points[i];
            }
        }
        
        System.out.print(count);
    }
}