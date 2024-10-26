import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        
        int[] counts = new int[10];
        
        for(int num : numbers){
            counts[num]++;
        }
        
        for(int i = 0; i < 10; i++){
            if(counts[i] == 0) answer += i; 
        }
        
        return answer;
    }
}