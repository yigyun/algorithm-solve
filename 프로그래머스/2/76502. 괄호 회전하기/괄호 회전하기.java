import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        char[] array = s.toCharArray();
        
        for(int i = 0; i < s.length(); i++){
            Stack<Character> stack = new Stack<>();
            for(int j = 0; j < s.length(); j++){
                char ch = array[(i+j) % s.length()];
                if(stack.isEmpty()){
                    stack.push(ch);
                }else{
                    if(ch == '}'){
                        if(stack.peek() == '{'){
                            stack.pop();
                        }else{
                            stack.push(ch);
                        }
                    }else if(ch == ')'){
                        if(stack.peek() == '('){
                            stack.pop();
                        }else{
                            stack.push(ch);
                        }
                    }else if(ch == ']'){
                        if(stack.peek() == '['){
                            stack.pop();
                        }else{
                            stack.push(ch);
                        }
                    }else{
                        stack.push(ch);
                    }
                }
            }
            if(stack.isEmpty()){
               answer++;
            }else{
                while(!stack.isEmpty()){
                    System.out.println(stack.pop());
                }
            }
        }
        
        return answer;
    }
}