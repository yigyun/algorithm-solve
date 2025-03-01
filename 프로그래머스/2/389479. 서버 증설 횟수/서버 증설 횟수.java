class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        // m명 이상이면 증설 즉 m 몫
        int[] dp = new int[25];
        
        for(int i = 1; i <= 24; i++){
            int num = players[i-1] / m;
            if(num > dp[i]){
                num -= dp[i];
                answer += num;
                for(int j = 0; j < k; j++){
                    if(i + j <= 24){
                        dp[i + j] += num;
                    }
                }
            }
        }

        
        return answer;
    }
}