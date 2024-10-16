import java.util.*;
import java.io.*;

class Main{

    static int L;
    static int w;
    static int n;

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        w = sc.nextInt();
        L = sc.nextInt();

        int curWeight = 0;

        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i < n; i++){
            que.offer(sc.nextInt());
        }

        int[] bridge = new int[w];
        int day = 0;

        while(!que.isEmpty()){
            curWeight = 0;
            for(int i = w-1; i >= 0; i--){
                if(i != 0) bridge[i] = bridge[i-1];
                else{
                    bridge[i] = 0;
                }
                curWeight += bridge[i];
            }

            if(curWeight + que.peek() <= L){
                // 가능하다 올리기.
                int num = que.poll();
                curWeight += num;
                bridge[0] = num;
            }
            day++;
        }

        for(int i = 0; i < w; i++){
            if(bridge[i] != 0){
                day += w - i;
                break;
            }
        }
        System.out.print(day);
    }
}