

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 1;
        
        int start = 1;
        int end = 0;
        for(int i = 0; i < diffs.length; i++){
            end = Math.max(diffs[i], end);
        }
        
        while(start <= end){
            int mid = (start + end) / 2;
            long time = 0;
            for(int i = 0; i < diffs.length; i++){
                if(mid >= diffs[i]){
                    time += times[i];
                }else{
                    time += ((times[i - 1] + times[i]) * (diffs[i] - mid)) + times[i];
                }
                if(time > limit) break;
            }
            
            if(time <= limit){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return start;
    }
}