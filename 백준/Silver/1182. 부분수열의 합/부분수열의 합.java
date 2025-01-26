import java.util.*;
import java.io.*;

class Main{

    static int count;
    static int[] nums;
    static int n;
    static int s;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        nums = new int[n];
        count = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        found(0, 0);
        if(s == 0) count--;
        System.out.print(count);
    }

    static void found(int index, int c){
        if(c == s){
            count++;
        }
        for(int i = index; i < n; i++){
            found(i + 1, c + nums[i]);
        }
    }
}
