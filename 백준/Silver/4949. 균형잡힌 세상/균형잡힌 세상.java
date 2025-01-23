import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        while(!str.equals(".")){
            stack.clear();
            boolean check = true;

            for(char ch : str.toCharArray()){
                if(ch == '[' || ch == '(') stack.push(ch);
                else if(ch == ']'){
                    if(stack.isEmpty() || stack.peek() != '['){
                        check = false;
                        break;
                    }
                    stack.pop();
                }else if(ch == ')'){
                    if(stack.isEmpty() || stack.peek() != '('){
                        check = false;
                        break;
                    }
                    stack.pop();
                }
            }
            
            if(!stack.isEmpty()) check = false;
            if(check) sb.append("yes").append('\n');
            else sb.append("no").append('\n');
            
            str = br.readLine();
        }

        System.out.print(sb);
    }
}