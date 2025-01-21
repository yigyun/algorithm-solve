import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < k; i++){
            int n = Integer.parseInt(br.readLine());
            if(n == 0 && !stack.isEmpty()) stack.pop();
            else stack.push(n);
        }
        
        int result = 0;
        while(!stack.isEmpty()){
            result += stack.pop();
        }
        
        System.out.print(result);
    }
}