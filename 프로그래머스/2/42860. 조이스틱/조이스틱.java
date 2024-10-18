/**
    name 만큼 A를 만들고 시작하고, 다음이 A냐 아니냐에 따라 이동을 정하면 될듯? A 면 무시하고 이동하는게 좋으니까
**/
import java.util.*;

class Solution {
    
    static int min;
    
    public int solution(String name) {
        int answer = 0;
        int count = 0;
        int length = name.length();
        
        for(int i = 0; i < length; i++){
            if(name.charAt(i) == 'A') count++;
            int diff = name.charAt(i) - 'A';
            answer += Math.min(diff, 26 - diff);
        }
        
        int minMove = length - 1;  // 좌우 이동의 최댓값은 끝까지 가는 경우
        
        // 연속된 A를 만났을 때 최적 이동 계산
        for (int i = 0; i < length; i++) {
            int next = i + 1;

            // 연속된 A를 건너뛰기
            while (next < length && name.charAt(next) == 'A') {
                next++;
            }

            // i에서 next로 가는 경우와 다시 되돌아오는 경우 중 최소값을 선택
            // i + i는 처음으로 돌아가는 경로, (length - next)는 남은 거리
            minMove = Math.min(minMove, i + length - next + Math.min(i, length - next));
        }

        answer += minMove;  // 좌우 이동 횟수 더하기

        
        return answer;
    }
}