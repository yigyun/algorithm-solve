package softeer.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class softeer8 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        if(N < M) {System.out.print("normal"); return;}
        int[] recipe = new int[M];
        // 비밀 레시피 입력받음
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            recipe[i] = Integer.parseInt(st.nextToken());
        }

        // 유저 입력
        st = new StringTokenizer(br.readLine());
        int[] input = new int[N];
        int index = 0;
        int size = recipe.length;
        boolean check = true;
        for(int i = 0; i < N; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i <= N-M; i++){
            boolean inCheck = true;
            for(int j = i; j < i+M; j++){
                if(recipe[index] != input[j]){
                    inCheck = false;
                    index = 0;
                    break;
                }
                index++;
            }
            if(inCheck){
                check = false;
                break;
            }
        }

        if(check) System.out.print("normal");
        else System.out.print("secret");
    }
}
