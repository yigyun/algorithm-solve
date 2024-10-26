class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        long start = 0;
        long end = 1000000000000000000L;
        
        while(end > start){
            long mid = (start + end) / 2;
            
            long t = 0;
            for(int time : times){
                t += (mid / time);
            }
            
            if(t >= n){
                end = mid;
            }else{
                start = mid + 1;
            }
        }
        
        return start;
    }
}