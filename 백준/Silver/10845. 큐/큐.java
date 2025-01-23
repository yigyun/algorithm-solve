import java.util.*;
import java.io.*;

class Main{

    static class Queues{
        int front;
        int rear;
        int[] nums;
        int s;

        Queues(int n){
            this.nums = new int[10000];
            this.s = 0;
            this.front = 0;
            this.rear = 0;
        }

        void push(int num){
            s++;
            nums[rear++] = num;
        }

        int pop(){
            if(s == 0) return -1;
            s--;
            return nums[front++];
        }

        int size(){
            return s;
        }

        int empty(){
            return this.s == 0 ? 1 : 0;
        }

        int front(){
            if(s > 0) return nums[front];
            return -1;
        }

        int back(){
            if(s > 0) return nums[rear - 1];
            return -1;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());

        Queues que = new Queues(n);

        for(int t = 0; t < n; t++){
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            if(op.equals("push")){
                que.push(Integer.parseInt(st.nextToken()));
            }else if(op.equals("pop")){
                sb.append(que.pop()).append('\n');
            }else if(op.equals("size")){
                sb.append(que.size()).append('\n');
            }else if(op.equals("empty")){
                sb.append(que.empty()).append('\n');
            }else if(op.equals("front")){
                sb.append(que.front()).append('\n');
            }else {
                sb.append(que.back()).append('\n');
            }
        }

        System.out.print(sb);
    }
}