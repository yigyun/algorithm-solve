class Solution {
    
    /**
        1번은 무조건 1이고, times[0]은 어차피 실행됨
    **/
    
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 1;
        
        int left = 1;
        int right = 100000;
                
        while(left <= right){
            int mid = (left + right) / 2;
            long time = times[0];
            for(int i = 1; i < diffs.length; i++){
                if(diffs[i] <= mid){
                    time += times[i];
                }else{
                    int diff = diffs[i] - mid;
                    time += (diff * (times[i-1] + times[i])) + times[i]; 
                }
            }
            if(time <= limit){
                right = mid - 1;
                answer = mid;
            }else{
                left = mid + 1;
            }
        }
        
        return answer;
    }
}