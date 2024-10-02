import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        Stack<Integer> stack = new Stack<>();
        // key는 숫자, 뒤에는 인덱스
        for(int i = numbers.length-1; i >= 0; i--){
           while(!stack.isEmpty() && stack.peek() <= numbers[i]){
               stack.pop();
           }
            
            if(!stack.isEmpty()){
                answer[i] = stack.peek();
            }
            
            stack.push(numbers[i]);
        }
        
        return answer;
    }
}