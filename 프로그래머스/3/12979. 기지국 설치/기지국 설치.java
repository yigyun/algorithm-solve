import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int length = 2 * w + 1;
        int lin = 0;
        
        for(int station : stations){
            int start = (station - w) < 1 ? 1 : station - w;
            int end = station + w > n ? n : station + w;
            
            if(start > lin + 1){
                int gap = start - (lin + 1);
                answer += (gap + length - 1) / length;
            }
            
            lin = end;
        }
        
        if(lin < n){
            int gap = n - lin;
            answer += (gap + length -1) / length;
        }
        
        return answer;
    }
}