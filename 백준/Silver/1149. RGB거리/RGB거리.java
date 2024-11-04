import java.util.*;
import java.io.*;

class Main{

    static int N;

    static int[][] home;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        home = new int[N][3];
        // 1번은 다 담아주기
        st = new StringTokenizer(br.readLine());
        home[0][0] = Integer.parseInt(st.nextToken());
        home[0][1] = Integer.parseInt(st.nextToken());
        home[0][2] = Integer.parseInt(st.nextToken());
        // 수행하기
        for(int i = 1; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                home[i][j] = Integer.MAX_VALUE;
                int num = Integer.parseInt(st.nextToken());
                for(int k = 0; k < 3; k++){
                    if(j == k) continue;
                    home[i][j]  = Math.min( home[i-1][k] + num, home[i][j]);
                }
            }
        }

        System.out.print(Math.min(home[N-1][0], Math.min(home[N-1][1], home[N-1][2])));
    }
}