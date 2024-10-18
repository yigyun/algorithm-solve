import java.util.*;
import java.io.*;

class Main{

    static int[][] map = new int[103][103];
    static int r;
    static int c;
    static int k;

    static int row;
    static int col;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;
        k = Integer.parseInt(st.nextToken());
        row = 3;
        col = 3;

        for(int i = 0; i < 3; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int day = -1;

        for(int i = 0; i < 101; i++){
            if(map[r][c] == k){
                day = i;
                break;
            }
            if(row >= col){
                calR();
            }else{
                calC();
            }
        }

        System.out.print(day);
    }

    static void print(){
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void calC(){
        for(int i = 0; i < col; i++){
            Map<Integer, Integer> temp = new HashMap<>();
            for(int j = 0; j < row; j++){
                if(map[j][i] == 0) continue;
                temp.put(map[j][i], temp.getOrDefault(map[j][i], 0) + 1);
            }
            List<int[]> list = new ArrayList<>();
            for(int num : temp.keySet()){
                list.add(new int[]{num, temp.get(num)});
            }
            Collections.sort(list, (o1, o2) ->{
                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            });

            int index = 0;

            for(int j = 0; j < list.size(); j++){
                map[index][i] = list.get(j)[0];
                map[index + 1][i] = list.get(j)[1];
                index += 2;
            }
            for(int j = index; j < 101; j++){
                map[j][i] = 0;
            }

            row = Math.max(row, index);
        }
    }

    static void calR(){
        for(int i = 0; i < row; i++){
            Map<Integer, Integer> temp = new HashMap<>();
            for(int j = 0; j < col; j++){
                if(map[i][j] == 0) continue;

                temp.put(map[i][j], temp.getOrDefault(map[i][j], 0) + 1);
            }
            List<int[]> list = new ArrayList<>();
            for(int num : temp.keySet()){
                list.add(new int[]{num, temp.get(num)});
            }
            Collections.sort(list, (o1, o2) ->{
                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            });

            int index = 0;

            for(int j = 0; j < list.size(); j++){
                map[i][index] = list.get(j)[0];
                map[i][index + 1] = list.get(j)[1];
                index += 2;
            }

            for(int j  = index; j < 101; j++){
                map[i][j] = 0;
            }

            col = Math.max(col, index);
        }

    }
}