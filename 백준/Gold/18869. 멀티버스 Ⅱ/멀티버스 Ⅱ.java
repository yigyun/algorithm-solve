import java.util.*;
import java.io.*;

class Main{

    static int[][] rank;
    static int[][] universe;
    static int m, n;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        universe = new int[m][n];
        rank = new int[m][n];

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                universe[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < m; i++){
            rank[i] = getRank(universe[i]);
        }

        int count = 0;

        for(int i = 0; i < m; i++){
            for(int j = i + 1; j < m; j++){
                // 두 우주
                if(Arrays.equals(rank[i], rank[j])) count++;
            }
        }

        System.out.print(count);
    }

    static int[] getRank(int[] arr){
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< sorted.length; i++){
            map.put(sorted[i], i);
        }

        int[] rank = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            rank[i] = map.get(arr[i]);
        }

        return rank;
    }
}