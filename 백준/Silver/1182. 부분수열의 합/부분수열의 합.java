import java.util.*;
import java.io.*;

class Main{

    static int n;
    static int s;
    static int[] nums;
    static int result;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        nums = new int[n];
        result = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        find(0, 0);
        if(s == 0) result--;
        System.out.print(result);
    }

    static void find(int index, int sum){
        if(sum == s) result++;

        for(int i = index; i < n; i++){
            find(i + 1, sum + nums[i]);
        }
    }
}