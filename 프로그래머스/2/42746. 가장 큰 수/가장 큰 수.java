import java.util.*;

class Solution {
        
    public String solution(int[] numbers) {
        String answer = "";
        String[] strs = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            strs[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(strs, (o1, o2) -> {
            int num1 = Integer.parseInt(o1 + o2);
            int num2 = Integer.parseInt(o2 + o1);
            
            return num2 - num1;
        });
        
        
        for(int i = 0; i < strs.length; i++){
            answer += strs[i];
        }
        if(answer.charAt(0) == '0') return "0";
        return answer;
    }
}