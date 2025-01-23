import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int result = 0;

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);

            if(ch == '('){
                result += 1;
                stack.push(ch);
            }else if(ch == ')'){
                if(str.charAt(i-1) == '('){
                    stack.pop();
                    result -= 1;
                    result += stack.size();
                }else if(stack.peek() == '('){
                    stack.pop();
                }
            }
        }

        System.out.print(result);
    }
}