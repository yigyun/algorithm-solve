import java.util.*;
import java.io.*;

class Main{

    static int[][] gear;
    static int k;
    static int[] index;

    static int score;
    // N극은 0, S극은 1
    // 1은 시계방향 -1은 반시계 방향
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        gear = new int[4][8];
        for(int i = 0; i < 4; i++){
            String str = br.readLine();
            for(int j = 0; j < 8; j++){
                if(str.charAt(j) == '1')
                    gear[i][j] = 1;
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        score = 0;
        index = new int[4]; // 각 톱니바퀴는 어차피 시작이 0임.
        for(int t = 0; t < k; t++){
            st = new StringTokenizer(br.readLine());
            int moveGear = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());

            boolean[] visited = new boolean[4];
            Queue<int[]> que = new LinkedList<>();
            List<int[]> moveList = new ArrayList<>();
            moveList.add(new int[]{moveGear, dir});
            que.offer(new int[]{moveGear, dir});
            visited[moveGear] = true;

            while(!que.isEmpty()){
                int[] current = que.poll();
                int gearNumber = current[0];
                int dirt = current[1];

                int gearIndex = index[gearNumber];
                int leftIndex = (gearIndex - 2 + 8) % 8;
                int rightIndex = (gearIndex + 2) % 8;

                int prevNumber = gearNumber - 1;
                int nextNumber = gearNumber + 1;

                if(prevNumber >= 0 && !visited[prevNumber]){
                    int prevIndex = index[prevNumber];
                    int prevRight = gear[prevNumber][(prevIndex + 2) % 8];
                    if(prevRight != gear[gearNumber][leftIndex]){
                        visited[prevNumber] = true;
                        que.offer(new int[]{prevNumber, dirt * -1});
                        moveList.add(new int[]{prevNumber, dirt * -1});
                    }
                }

                if(nextNumber < 4 && !visited[nextNumber]){
                    int nextIndex = index[nextNumber];
                    int nextLeftIndex = (nextIndex - 2 + 8) % 8;
                    int nextLeft = gear[nextNumber][nextLeftIndex];
                    if(nextLeft != gear[gearNumber][rightIndex]){
                        que.offer(new int[]{nextNumber, dirt * -1});
                        visited[nextNumber] = true;
                        moveList.add(new int[]{nextNumber, dirt * -1});
                    }
                }
            }

            // moveList 회전하기
            for(int[] num : moveList){
                rotate(num[0], num[1]);
            }

        }

        // 점수
        for(int number = 0; number < 4; number++){
            if(gear[number][index[number]] == 1){
                score += Math.pow(2, number);
            }
        }

        System.out.print(score);
    }

    static void rotate(int gearNumber, int dir){
        if(dir == 1){
            index[gearNumber] = index[gearNumber] - 1 < 0 ? 7 : index[gearNumber] - 1;
        } else if(dir == -1){
            index[gearNumber] = (index[gearNumber] + 1) % 8;
        }
    }
}