package softeer.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class softeer4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] matrix = new int[3][3];
        int result = 4;

        for(int i = 0; i < 3; i++){
            st = new StringTokenizer(br.readLine());
            int[] row = new int[4];
            for(int j = 0; j < 3; j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < 3; i++){
            int[] row = new int[4];
            int[] col = new int[4];
            int rmax = 0;
            int cmax = 0;
            for(int j = 0; j < 3; j++){
                row[matrix[i][j]] += 1;
                col[matrix[j][i]] += 1;
                rmax = Math.max(rmax, row[matrix[i][j]]);
                cmax = Math.max(cmax, col[matrix[j][i]]);
            }
            int a = cost(rmax);
            int b = cost(cmax);
            if(a == -1){
                for(int n = 1; n < 4; n++){
                    if(row[n] != 0){
                        row[0] = Math.abs(row[0] - n);
                    }
                }
                result = Math.min(row[0], result);
            }else result = Math.min(result, a);
            if(b == -1){
                for(int n = 1; n < 4; n++){
                    if(col[n] != 0){
                        col[0] = Math.abs(col[0] - n);
                    }
                }
                result = Math.min(col[0], result);
            }else result = Math.min(result, b);
        }

        System.out.print(result);
    }

    static int cost(int num){
        if(num == 3) return 0;
        if(num == 1) return 2;
        return -1;
    }
}
