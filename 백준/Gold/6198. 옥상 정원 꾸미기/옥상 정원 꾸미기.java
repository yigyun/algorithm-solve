import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        
        long result = 0;
        
        for(int i = 1; i <= n; i++){
            
            int h = Integer.parseInt(br.readLine());
            
            while(!stack.isEmpty() && stack.peek() <= h){
                stack.pop();
            }
            result += stack.size();
            stack.push(h);
        }        

        System.out.print(result);
    }
}