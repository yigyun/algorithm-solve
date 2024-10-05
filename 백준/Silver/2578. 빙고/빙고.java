import java.util.*;
import java.io.*;

class Main{

    static int[] row = new int[5];
    static int[] column = new int[5];
    static int[] diag = new int[2];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Map<Integer, int[]> map = new HashMap<>();

        for(int i = 0; i < 5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++){
                int num = Integer.parseInt(st.nextToken());
                map.put(num, new int[]{i, j});
            }
        }

        int bingo = 0;

        for(int i = 0; i < 5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++){
                int num = Integer.parseInt(st.nextToken());
                int[] current = map.get(num);
                row[current[0]]++;
                column[current[1]]++;
                if(current[0] == current[1]) diag[0]++;
                if(current[0] + current[1] == 4) diag[1]++;

                if(row[current[0]] == 5){ bingo++; row[current[0]] = 6; }
                if(column[current[1]] == 5) {bingo++; column[current[1]] = 6; }
                if(diag[0] == 5) {bingo++; diag[0] = 6; }
                if(diag[1] == 5) {bingo++; diag[1] = 6; }

                if(bingo >= 3){
                    System.out.println(i * 5 + j + 1);
                    return;
                }
            }
        }
    }
}