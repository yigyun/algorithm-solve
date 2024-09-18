import java.util.*;
import java.io.*;

class Main{

    static int F;
    static int S;
    static int G;
    static int U;
    static int D;

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        F = sc.nextInt();
        S = sc.nextInt();
        G = sc.nextInt();
        U = sc.nextInt();
        D = sc.nextInt();

        Queue<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[F+1];
        que.offer(S);
        visited[S] = true;
        int result = 0;
        boolean check = true;
        while(!que.isEmpty()){
            int size = que.size();
            check = true;
            result++;
            for(int i = 0; i < size; i++){
                int number = que.poll();
                if(number == G){
                    check = false; break;
                }
                int nu = number + U;
                int nd = number - D;
                if(nu <= F && !visited[nu]){ que.offer(nu); visited[nu] = true; }
                if(nd >= 1 && !visited[nd]){ que.offer(nd); visited[nd] = true; }
            }
            if(!check) break;
        }

        System.out.println(check ? "use the stairs" : result-1);
    }
}