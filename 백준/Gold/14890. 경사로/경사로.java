import java.util.*;
import java.io.*;

/**
 n x n
 길은 총 2N개가 있다.

 조건: 길을 지나갈수 있으려면 길에 속한 모든 칸의 높이가 모두 같아야 한다.
 경사로 겹치는 거 X, 경사로의 높이는 항상 1, 경사로 개수 제한 x

 경사로는 낮은 칸에 놓인다. L개의 연속된 칸에 경사로의 바닥이 모두 접해야 한다.

 **/

class Main{

    static int n;
    static int l;

    static int[][] map;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;


        for(int i = 0; i < n; i++){
            count += row(map[i]);
            int[] column = new int[n];
            for(int j = 0; j < n; j++){
                column[j] = map[j][i];
            }
            count += row(column);
        }
        System.out.print(count);
    }

    static int row(int[] line){
        boolean[] slope = new boolean[n];

        for(int i = 0; i < n - 1; i++){
            int diff = line[i + 1] - line[i];

            if(diff == 0) continue;

            if(Math.abs(diff) > 1) return 0;

            if(diff == 1){
                for(int j = 0; j < l; j++){
                    if(i - j < 0 || line[i - j] != line[i] || slope[i - j]){
                        return 0;
                    }
                    slope[i - j] = true;
                }
            }else if(diff == -1){
                for(int j = 1; j <= l; j++){
                    if(i + j >= n || line[i + j] != line[i + 1] || slope[i + j]){
                        return 0;
                    }
                    slope[i + j] = true;
                }
            }
        }

        return 1;
    }
}