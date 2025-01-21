import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int n = s.length();
        
        for(int i = 0; i < n; i++){
            
            Stack<Character> stack = new Stack<>();
            boolean check = true;
            for(int j = 0; j < n; j++){
                char ch = s.charAt((i + j) % n);
                if((ch == '}' || ch == ']' || ch == ')')){
                    if(stack.isEmpty() || (ch == '}' && stack.peek() != '{') || (ch == ')' && stack.peek() != '(') || ch == ']' && stack.peek() != '['){
                        check = false; break;
                    }else{
                        stack.pop();
                    }
                }else stack.push(ch);
            }
            
            if(check && stack.isEmpty()) {
                answer++;
            }
        }
                
        return answer;
    }
}