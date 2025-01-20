import java.util.*;
import java.io.*;

class Main{

    static class Stacks{
        int[] nums;
        int pos;

        Stacks(int n){
            this.nums = new int[n];
            this.pos = 0;
        }

        void push(int n){
            nums[pos++] = n;
        }

        int pop(){
            if(pos - 1 < 0) return -1;
            return nums[--pos];
        }

        int size(){
            return pos;
        }

        int empty(){
            if(pos == 0) return 1;
            return 0;
        }

        int top(){
            if(pos - 1 < 0) return -1;
            return nums[pos - 1];
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Stacks st1 = new Stacks(n);
        StringBuilder sb = new StringBuilder();

        for(int t = 0; t < n; t++){
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            if(op.equals("push")){
                int num = Integer.parseInt(st.nextToken());
                st1.push(num);
            }else if(op.equals("pop")){
                sb.append(st1.pop()).append('\n');
            }else if(op.equals("size")){
                sb.append(st1.size()).append('\n');
            }else if(op.equals("empty")){
                sb.append(st1.empty()).append('\n');
            }else{
                sb.append(st1.top()).append('\n');
            }
        }

        System.out.print(sb);
    }
}