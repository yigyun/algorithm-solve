package softeer.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class softeer3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] home = new int[n];
        for(int i = 0; i < n; i++){
            home[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for(int i = 2; i < 100; i++){
            int count = 0;
            for(int j = 0; j < n; j++){
                if(home[j] % i == 0) count++;
            }
            if(count == n){
                result = n;
                break;
            }
            result = Math.max(result, count);
        }

        System.out.print(result);
    }
}
