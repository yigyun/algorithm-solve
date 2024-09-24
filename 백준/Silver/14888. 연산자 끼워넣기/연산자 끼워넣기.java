import java.util.*;
import java.io.*;

class Main{

    static int N;
    static int[] number;
    static int index;
    // 덧셈, 뺄셈, 곱셈, 나눗셈
    static int[] operations;
    static int min;
    static int max;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        operations = new int[4];
        number = new int[N];
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            number[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            operations[i] = Integer.parseInt(st.nextToken());
        }

        // 여기에서 그냥 모든 방향으로 만들어서 넣으면 됨.
        Queue<int[]> que = new LinkedList<>();
        for(int i = 0; i < 4; i++){
            if(operations[i] != 0){
                int[] temp = new int[]{0, 0, 0, 0, calculate(number[0], number[1], i)};
                temp[i]++;
                que.offer(temp);
            }
        }

        index = 2;
        while(!que.isEmpty() && index < N){
            int size = que.size();
            for(int k = 0; k < size; k++){
                int[] temp = que.poll();
                for(int i = 0; i < 4; i++){
                    if(operations[i] - temp[i] > 0){
                        int[] newTemp = Arrays.copyOf(temp, temp.length);
                        newTemp[i]++;
                        int cal = calculate(newTemp[4], number[index], i);
                        newTemp[4] = cal;
                        que.offer(newTemp);
                    }
                }
            }
            index++;
        }

        while (!que.isEmpty()) {
            int[] temp = que.poll();
            max = Math.max(max, temp[4]);
            min = Math.min(min, temp[4]);
        }
        System.out.println(max);
        System.out.print(min);

    }

    static int calculate(int n1, int n2, int operation){
        if(operation == 0){
            return n1 + n2;
        }else if(operation == 1){
            return n1 - n2;
        }else if(operation == 2){
            return n1 * n2;
        }else {
            return n1 / n2;
        }
    }
}