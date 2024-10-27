import java.util.*;

class Solution {
    boolean solution(String s) {        
        Stack<Character> stack = new Stack<>();
        
        for(char ch : s.toCharArray()){
            if(stack.isEmpty()){
                if(ch == ')') return false;
                stack.push(ch);
            }else{
                if(ch == ')'){
                    if(stack.peek() == '(')
                        stack.pop();
                    else{
                        return false;
                    }
                }
                else{
                    stack.push(ch);
                }
            }
        }
        
        if(!stack.isEmpty()) return false;

        return true;
    }
}