package leetcode.stack.easy;

import java.util.Stack;

public class ValidParentheses_20 {
    static class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for(char ch : s.toCharArray()){
                if(ch == '{' || ch == '(' || ch == '['){
                    stack.push(ch);
                } else if(ch == '}' || ch == ')' || ch == ']'){
                    if(!stack.isEmpty()){
                        char check = stack.pop();
                        if(ch == '}' && check != '{') return false;
                        if(ch == ')' && check != '(') return false;
                        if(ch == ']' && check != '[') return false;
                    }else{
                        return false;
                    }
                }
            }
            if(!stack.isEmpty()) return false;
            return true;
        }
    }
}
