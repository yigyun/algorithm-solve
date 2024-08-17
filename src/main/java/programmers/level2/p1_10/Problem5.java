package programmers.level2;
public class Problem5 {

    static class Solution {
        public long solution(int k, int d) {
            long answer = 0;
            int index = d/k;
            for(int a = 0; a <= (d/k); a++){
                for(int b = index; b >= 0; b--){
                    // 두 점 사이의 거리가 가능한지 확인.
                    if(Math.sqrt(Math.pow(a*k - 0, 2) + Math.pow(b*k - 0, 2)) <= d){
                        answer += b + 1;
                        index = b;
                        break;
                    }
                }
            }

            return answer;
        }
    }
}
