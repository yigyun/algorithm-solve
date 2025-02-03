import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int num = lcm(m, n);

            while(x != y && (x <= num && y <= num)){
                if(x < y) x +=m;
                else y += n;
            }

            if(x > num || y > num) System.out.println(-1);
            else System.out.println(x);
        }
    }

    static int gcd(int a, int b){
        if(a == 0) return b;
        return gcd(b % a, a);
    }

    static int lcm(int a, int b){
        return a / gcd(a, b) * b;
    }
}