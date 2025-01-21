// stack을 두 개 두고, 꺼내면서 가능한 만큼 오른쪽 스택에서 꺼내면됨.


import java.util.*;
import java.io.*;

class Main{

    static class Top{
        int h;
        int number;
        Top(int h, int number){
            this.h = h;
            this.number = number;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n+1];
        Stack<Top> stack1 = new Stack<>();
        Stack<Top> stack2 = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= n; i++){
            stack1.push(new Top(Integer.parseInt(st.nextToken()), i));
        }

        StringBuilder sb = new StringBuilder();

        while(!stack1.isEmpty()){
            while(!stack2.isEmpty()){
                if(stack2.peek().h > stack1.peek().h){
                    break;
                }
                nums[stack2.pop().number] = stack1.peek().number;
            }
            stack2.push(stack1.pop());
        }

        for(int i = 1; i <= n; i++){
            sb.append(nums[i]).append(" ");
        }

        System.out.print(sb);
    }
}