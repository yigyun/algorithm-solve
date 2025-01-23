import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int sum = 1;
        int result = 0;
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            
            if(ch == '('){
                sum *= 2;
                stack.push(ch);
            }else if(ch =='['){
                sum *= 3;
                stack.push(ch);
            }else if(ch == ')'){
                if(stack.isEmpty() || stack.peek() != '('){
                    result = 0; break;
                }else{
                   if(str.charAt(i-1) == '(') result += sum;
                    sum /= 2;
                    stack.pop();
                }
            }else if(ch == ']'){
                if(stack.isEmpty() || stack.peek() != '['){
                    result = 0; break;
                }else{
                   if(str.charAt(i-1) == '[') result += sum;
                    sum /= 3;
                    stack.pop();
                }
            }
        }

        if(!stack.isEmpty()) result = 0;

        System.out.println(result);
    }
}