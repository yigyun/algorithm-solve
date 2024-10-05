import java.util.*;

class Solution {
    
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> numbers = new ArrayList<>();
        
        long[] facto = new long[n+1];
        
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        
        facto[0] = 1;
        for(int i = 1; i <= n; i++){
            facto[i] = facto[i-1] * i;
        }
        
        k--;
        
        for(int i = 0; i < n; i++){
            int index = (int)(k / facto[n - i - 1]);
            answer[i] = numbers.get(index);
            numbers.remove(index);
            
            k %= facto[n-1-i];
        }
        return answer;
    }
    
}