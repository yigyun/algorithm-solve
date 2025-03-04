import java.util.*;
import java.io.*;

class Main{

    static int n;
    static class Egg{
        int w;
        int s;
        Egg(int s, int w){
            this.w = w;
            this.s = s;
        }
    }

    static List<Egg> eggs;
    static boolean[] breaked;
    static int max;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        eggs = new ArrayList<>();
        breaked = new boolean[n];
        max = 0;

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            eggs.add(new Egg(s, w));
        }

        back(0);

        System.out.print(max);
    }

    static void back(int idx){
        if(idx == n){
            int count = 0;
            for(int i = 0; i < n; i++){
                if(breaked[i]) count++;
            }
            max = Math.max(max, count);
            return;
        }

        if(breaked[idx]) back(idx + 1);
        else{
            boolean check = true;
            for(int i = 0; i < n; i++){
                if(i == idx) continue;
                if(!breaked[i]){
                    check = false;
                    Egg left = eggs.get(idx);
                    Egg right = eggs.get(i);
                    right.s -= left.w;
                    left.s -= right.w;
                    if(right.s <= 0) breaked[i] = true;
                    if(left.s <= 0) breaked[idx] = true;
                    back(idx + 1);
                    right.s += left.w;
                    left.s += right.w;
                    if(right.s > 0) breaked[i] = false;
                    if(left.s > 0) breaked[idx] = false;
                }
            }
            if(check) back(idx + 1);
        }
    }
}