package programmers.level2;
import java.util.*;
public class Problem2 {
    /**
     A -> B
     미사일을 최소화해서 요격하기
     끝 부분을 기준으로 오름차순으로 정렬하고 같은 범위 내에 있다면 무조건 지우면서 가면 됨.
     **/


    static class Solution {
        public int solution(int[][] targets) {
            int answer = 0;

            Arrays.sort(targets, (o1, o2) -> {
                if(o1[1] == o2[1])
                    return o1[0] - o2[0];
                return o1[1] - o2[1];
            });

            int start = 0;
            int x = 0;
            int y = 0;
            while(start < targets.length){
                answer++;
                x = targets[start][0];
                y = targets[start][1];
                start++;
                while(start < targets.length){
                    if(targets[start][0] >= y) break;
                    start++;
                }
            }

            return answer;
        }
    }
}
