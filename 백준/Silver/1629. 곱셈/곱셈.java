import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.print(cal(a, b, c));
    }

    static long cal(int a, int b, int c){
        if(b == 0) return 1;
        long num = cal(a, b / 2, c);
        num = (num * num) % c;
        if(b % 2 != 0) num = (num * a) % c;
        return num;
    }
}