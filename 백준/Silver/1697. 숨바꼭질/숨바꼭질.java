import java.util.*;
import java.io.*;

public class Main{

    static boolean[] visited;

    public static void main(String[] args)throws IOException{
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        if(N == K){
            System.out.print(0);
            return;
        }
        Queue<Integer> que = new LinkedList<>();
        visited = new boolean[100001];
        visited[N] = true;
        que.offer(N);
        int time = 0;
        while(!que.isEmpty()){
            int size = que.size();
            boolean check = false;
            for(int i = 0; i < size; i++){
                int number = que.poll();
                if(number == K) {check = true; break;}
                if(isRange(number - 1)){
                    visited[number - 1] = true;
                    que.offer(number - 1);
                }
                if(isRange(number + 1)){
                    visited[number+1] = true;
                    que.offer(number + 1);
                }
                if(isRange(number*2)){
                    visited[number*2] = true;
                    que.offer(number*2);
                }
            }
            if(check) break;
            time++;
        }
        System.out.print(time);
    }

    static boolean isRange(int x){
        if(x >= 0 && x <= 100000 && !visited[x]) return true;
        return false;
    }
}