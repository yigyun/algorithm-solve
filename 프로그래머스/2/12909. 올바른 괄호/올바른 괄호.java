import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == '(') stack.push(ch);
            else{
                if(stack.isEmpty()){
                    return false;
                }
                
                if(stack.peek() == '(') stack.pop();
                else return false;
            }
        }
        
        if(!stack.isEmpty()) answer = false;

        return answer;
    }
}